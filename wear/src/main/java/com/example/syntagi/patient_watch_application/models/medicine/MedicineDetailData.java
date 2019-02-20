package com.example.syntagi.patient_watch_application.models.medicine;

import com.google.android.gms.common.util.CollectionUtils;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MedicineDetailData {
    @SerializedName("medicine_id")
    private String medicineId;

    @SerializedName("name")
    private String medicationName;

    @SerializedName("price")
    private Double price;

    @SerializedName("manufacturer")
    private String manufacturer;

    @SerializedName("form")
    private String form;

    @SerializedName("size")
    private String size;

    private PregnancyData pregnancy;
    private PregnancyData lactation;

    private List<ConstituentData> constituents;

    private List<MedicineComponentData> components;

    private Interactions interactions;

    public String getMedicineId() {
        return medicineId;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public Double getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getForm() {
        return form;
    }

    public String getSize() {
        return size;
    }

    public PregnancyData getPregnancy() {
        if(pregnancy==null){
            return new PregnancyData();
        }
        return pregnancy;
    }

    public PregnancyData getLactation() {
        if(lactation==null){
            return new PregnancyData();
        }
        return lactation;
    }

    public List<ConstituentData> getConstituents() {
        return constituents;
    }

    public List<MedicineComponentData> getComponents() {
        return components;
    }

    public Interactions getInteractions() {
        return interactions;
    }

    public String getConstituentsString() {
        StringBuilder stringBuilder=new StringBuilder();
        if(!CollectionUtils.isEmpty(constituents)){
            for(ConstituentData constituentData:constituents){
                stringBuilder.append(constituentData.getName()+"-"+constituentData.getStrength()).append(", ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        return stringBuilder.toString();
    }

    public String getSideEffectes() {
        StringBuilder stringBuilder=new StringBuilder();
        if(!CollectionUtils.isEmpty(components)){
            for(MedicineComponentData medicineComponentData:components){
                stringBuilder.append(medicineComponentData.getSide_effects()).append(", ");
            }
        }
        return removeDuplicate(stringBuilder);
    }
    public String getSideHowItsWorks() {
        StringBuilder stringBuilder=new StringBuilder();
        if(!CollectionUtils.isEmpty(components)){
            for(MedicineComponentData medicineComponentData:components){
                stringBuilder.append(medicineComponentData.getHow_it_works()).append(", ");
            }
        }
        return removeDuplicate(stringBuilder);
    }

    public String therapeuticClasses() {
        StringBuilder stringBuilder=new StringBuilder();
        if(!CollectionUtils.isEmpty(components)){
            for(MedicineComponentData medicineComponentData:components){
                stringBuilder.append(medicineComponentData.getTherapeutic_class()).append(", ");
            }
        }
        return removeDuplicate(stringBuilder);
    }

    public String getUsedFor() {
        StringBuilder stringBuilder=new StringBuilder();
        if(!CollectionUtils.isEmpty(components)){
            for(MedicineComponentData medicineComponentData:components){
                stringBuilder.append(medicineComponentData.getUsed_for()).append(", ");
            }
        }
        return removeDuplicate(stringBuilder);
    }

    public String getStrength() {
        StringBuilder stringBuilder=new StringBuilder();
        if(!CollectionUtils.isEmpty(components)){
            for(MedicineComponentData medicineComponentData:components){
                stringBuilder.append(medicineComponentData.getStrength()).append(", ");
            }
        }
        return removeDuplicate(stringBuilder);
    }
    public String removeDuplicate(StringBuilder stringBuilder){
        String[] split = stringBuilder.toString().split(", ");
        if(split!=null&&split.length>0){
            stringBuilder.setLength(0);
            Set<String> set=new HashSet(Arrays.asList(split));
            for(String s:set){
                stringBuilder.append(s.trim()).append(", ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        return stringBuilder.toString();
    }
}