package com.example.syntagi.patient_watch_application;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.syntagi.patient_watch_application.Interfaces.ApiInterface;
import com.example.syntagi.patient_watch_application.models.medicine.Interactions;
import com.example.syntagi.patient_watch_application.models.medicine.MedicineData;
import com.example.syntagi.patient_watch_application.models.medicine.MedicineDetailData;
import com.google.android.gms.common.util.CollectionUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MedicineDetailActivity extends AppCompatActivity {
  ProgressDialog progressDoalog;
    //    WearableNavigationDrawerView navigationDrawerView;
    private LinearLayout layHeader;
    private LinearLayout layOther;
    Retrofit retrofit = null;
    ApiInterface apiInterface = null;
    private MedicineData medicineData;


    public static void startActivity(Fragment context, MedicineData medicineData) {
        Intent intent = new Intent(context.getActivity(), MedicineDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("medicineDetails", medicineData);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_detail);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            medicineData = (MedicineData) bundle.getSerializable("medicineDetails");
        }

        layHeader = findViewById(R.id.lay_header_data);
        layOther = findViewById(R.id.lay_other_data);

    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (medicineData != null) {
            fetchMedicineDetail(medicineData.getMedicineId());

        }
    }

    private void fetchMedicineDetail(String medicineId) {

        progressDoalog = new ProgressDialog(MedicineDetailActivity.this);
        progressDoalog.setMessage("Loading....");

//        progressDoalog.setMax(5);
        // show it
        progressDoalog.show();
        retrofit = new Retrofit.Builder().baseUrl("http://13.127.133.104:8082")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
        apiInterface.getMedicineById(medicineId, "12345678", 4).enqueue(new Callback<MedicineDetailData>() {
            @Override
            public void onResponse(Call<MedicineDetailData> call, Response<MedicineDetailData> response) {
                if (response.isSuccessful()) {
                    MedicineDetailData medicineDetailData = response.body();
                    if (medicineDetailData!=null){
                          setData(medicineDetailData);
                    }
                }
                else {
                    Toast.makeText(MedicineDetailActivity.this,"Code:" +response.code(),Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<MedicineDetailData> call, Throwable t) {
                Toast.makeText(MedicineDetailActivity.this,"Error",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setData(MedicineDetailData medicineDetailData) {
        if (layHeader != null) {
            addHeader("Form:", medicineDetailData.getForm());
            addHeader("MRP:", "₹" + medicineDetailData.getPrice());
            addHeader("Manufacturer:", medicineDetailData.getManufacturer());
            if (!CollectionUtils.isEmpty(medicineDetailData.getConstituents())) {
                addHeader("Constituents:", medicineDetailData.getConstituentsString());
            }
        }
        if (layOther != null) {
            if (!CollectionUtils.isEmpty(medicineDetailData.getComponents())) {
                addDescriptionData("Therapeutic class:", medicineDetailData.therapeuticClasses());
                addDescriptionData("Side effects:", medicineDetailData.getSideEffectes());
                addDescriptionData("Used for:", medicineDetailData.getUsedFor());
                Interactions interactions = medicineDetailData.getInteractions();
                if (interactions != null) {
                    if (interactions.getPregnancy() != null) {
                        addDescriptionTagData("Pregnancy:", interactions.getPregnancy().getLabel(), interactions.getPregnancy().getTagColor(), medicineDetailData.getPregnancy().getCategory(), interactions.getPregnancy().getDescription());
                    }
                    if (interactions.getLactation() != null) {
                        addDescriptionTagData("Lactation:", interactions.getLactation().getLabel(), interactions.getLactation().getTagColor(), medicineDetailData.getLactation().getCategory(), interactions.getLactation().getDescription());
                    }
                    if (interactions.getAlcohol() != null) {
                        addDescriptionTagData("Alcohol:", interactions.getAlcohol().getLabel(), interactions.getAlcohol().getTagColor(), "", interactions.getAlcohol().getDescription());
                    }
                    if (interactions.getFood() != null) {
                        addDescriptionTagData("Food:", interactions.getFood().getLabel(), interactions.getFood().getTagColor(), "", interactions.getFood().getDescription());
                    }
                }
                addDescriptionData("How it works:", medicineDetailData.getSideHowItsWorks());
            }
        }
        progressDoalog.dismiss();

    }


    private void addHeader(String title, String description) {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_header_data, layHeader, false);
        setText(title, R.id.tv_title, view);
        setText(description, R.id.tv_value, view);
        layHeader.addView(view);
    }

    private void addDescriptionData(String title, String description) {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_other_data, layOther, false);
        setText(title, R.id.tv_title, view);
        setText(description, R.id.tv_value, view);
        layOther.addView(view);
    }

    private void addDescriptionTagData(String title, String tag, String tagColor, String category, String description) {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_other_safe_data, layOther, false);
        setText(title, R.id.tv_title, view);
        setText(tag, R.id.tv_tag, tagColor, view);
        if (!TextUtils.isEmpty(category)) {
            setText("Category " + category, R.id.tv_category, view);
        }
        setText(description, R.id.tv_description, view);
        layOther.addView(view);
    }

    public void setText(String text, int tvId, View view) {
        ((TextView) view.findViewById(tvId)).setText(getHtmlText(text));
    }


    private static Spanned getHtmlText(String displaytext) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(displaytext, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(displaytext);
        }
    }

    private void setText(String text, int tvId, String colorCode, View view) {
        TextView textView = (TextView) view.findViewById(tvId);
        if (TextUtils.isEmpty(text)) {
            text = "UNKNOWN";
        }
        textView.setText(getHtmlText(text));
        if (!TextUtils.isEmpty(colorCode)) {
            try {
                textView.setBackgroundColor(Color.parseColor(colorCode));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}