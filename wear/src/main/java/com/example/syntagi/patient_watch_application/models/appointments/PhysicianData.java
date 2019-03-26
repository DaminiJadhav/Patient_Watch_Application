package com.example.syntagi.patient_watch_application.models.appointments;

import com.google.android.gms.common.util.CollectionUtils;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PhysicianData {
    @SerializedName(Fields.PHYSICIAN_ID)
    private String physicianId;
    @SerializedName(Fields.REGISTERATION_NUMBER)
    private String registrationNumber;
    public PhysicianProfile profile;
    private Education education;
    @SerializedName(Fields.CERTIFICATES)
    private Certificates certificates;
    private List<PhysiciansClinicData> clinicInfoList;
    @SerializedName(Fields.AUTHORISED)
    private boolean authorised;
    @SerializedName(Fields.DECLEARATION)
    private boolean declarationSigned;
    @SerializedName(Fields.PIN)
    private Integer pin;
    private String token;
//    @SerializedName(Fields.PREFERENCES)
//    private PhysicianPreferences preferences;
    @SerializedName(Fields.LETTER_HEAD_DATA)
    private List<String> letterHeadData;
    @SerializedName(Fields.EXPERENCE)
    private PhysiciansExperience experience;
    @SerializedName(Fields.CODE)
    private String code;
    @SerializedName(Fields.CODE_DATE)
    private String codeDate;
    @SerializedName(Fields.REMOTE_CHARGES)
    private RemoteConsultationCharges remoteCharges;
    @SerializedName(Fields.PIN_UPDATED)
    private boolean pinUpdated;
    private boolean isFollowUp;
//    private BankDetails bankDetails;
    public List<String> getClinics() {
        List<String> clinicIds = new ArrayList<>();
        List<PhysiciansClinicData> clinicInfoList = getClinicInfoList();
        if (!CollectionUtils.isEmpty(clinicInfoList)) {
            for (PhysiciansClinicData physiciansClinicData : clinicInfoList) {
                clinicIds.add(physiciansClinicData.getClinicId());
            }
        }
        return clinicIds;
    }

    public interface Fields extends BaseApiData.Fields {
        String PHYSICIAN_ID = "physicianId";
        String FIRST_NAME = "firstName";
        String LAST_NAME = "lastName";
        String FULL_NAME = "fullname";
        String EMAIL = "emailId";
        String GENDER = "gender";
        String DATE_OF_BIRTH = "dateOfBirth";
        String IMAGE_URL = "imageUrl";
        String ADDRESS = "address";
        String PHONE_NUMBER = "phoneNumber";
        String ALTERNATE_PHONE_NUMBER = "alternatePhoneNumber";
        String ABOUT_ME = "aboutMe";
        String QUALIFICATION_LIST = "qualificationsList";
        String SPECIALIZATION_LIST = "specializationList";
        String CERTIFICATES = "certificates";
        String REGISTERATION_NUMBER = "registrationNumber";
        String PIN = "pin";
        String AUTHORISED = "authorised";
        String PREFERENCES = "preferences";
        String LETTER_HEAD_DATA = "letterHeadData";
        String EXPERENCE = "experience";
        String DECLEARATION = "declarationSigned";
        String CODE = "code";
        String CODE_DATE = "codeDate";
        String REMOTE_CHARGES = "remoteCharges";
        String PIN_UPDATED = "pinUpdated";
    }

    public String getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(String physicianId) {
        this.physicianId = physicianId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public PhysicianProfile getProfile() {
        return profile;
    }

    public void setProfile(PhysicianProfile profile) {
        this.profile = profile;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Certificates getCertificates() {
        return certificates;
    }

    public void setCertificates(Certificates certificates) {
        this.certificates = certificates;
    }

    public List<PhysiciansClinicData> getClinicInfoList() {
        return clinicInfoList;
    }

    public void setClinicInfoList(List<PhysiciansClinicData> clinicInfoList) {
        this.clinicInfoList = clinicInfoList;
    }

    public boolean isAuthorised() {
        return authorised;
    }

    public void setAuthorised(boolean authorised) {
        this.authorised = authorised;
    }

    public boolean isDeclarationSigned() {
        return declarationSigned;
    }

    public void setDeclarationSigned(boolean declarationSigned) {
        this.declarationSigned = declarationSigned;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

//    public PhysicianPreferences getPreferences() {
//        return preferences;
//    }
//
//    public void setPreferences(PhysicianPreferences preferences) {
//        this.preferences = preferences;
//    }

    public List<String> getLetterHeadData() {
        return letterHeadData;
    }

    public void setLetterHeadData(List<String> letterHeadData) {
        this.letterHeadData = letterHeadData;
    }

    public PhysiciansExperience getExperience() {
        return experience;
    }

    public void setExperience(PhysiciansExperience experience) {
        this.experience = experience;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeDate() {
        return codeDate;
    }

    public void setCodeDate(String codeDate) {
        this.codeDate = codeDate;
    }

    public RemoteConsultationCharges getRemoteCharges() {
        return remoteCharges;
    }

    public void setRemoteCharges(RemoteConsultationCharges remoteCharges) {
        this.remoteCharges = remoteCharges;
    }

    public boolean isPinUpdated() {
        return pinUpdated;
    }

    public void setPinUpdated(boolean pinUpdated) {
        this.pinUpdated = pinUpdated;
    }

    public boolean isFollowUp() {
        return isFollowUp;
    }

    public void setFollowUp(boolean followUp) {
        isFollowUp = followUp;
    }
//
//    public BankDetails getBankDetails() {
//        return bankDetails;
//    }
//
//    public void setBankDetails(BankDetails bankDetails) {
//        this.bankDetails = bankDetails;
//    }
}