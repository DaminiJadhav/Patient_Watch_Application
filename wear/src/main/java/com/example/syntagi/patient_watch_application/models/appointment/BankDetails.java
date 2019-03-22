package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BankDetails {

@SerializedName("accountHolder")
@Expose
private String accountHolder;
@SerializedName("branchName")
@Expose
private String branchName;
@SerializedName("bankName")
@Expose
private String bankName;
@SerializedName("accountNumber")
@Expose
private String accountNumber;
@SerializedName("ifscCode")
@Expose
private String ifscCode;

public String getAccountHolder() {
return accountHolder;
}

public void setAccountHolder(String accountHolder) {
this.accountHolder = accountHolder;
}

public String getBranchName() {
return branchName;
}

public void setBranchName(String branchName) {
this.branchName = branchName;
}

public String getBankName() {
return bankName;
}

public void setBankName(String bankName) {
this.bankName = bankName;
}

public String getAccountNumber() {
return accountNumber;
}

public void setAccountNumber(String accountNumber) {
this.accountNumber = accountNumber;
}

public String getIfscCode() {
return ifscCode;
}

public void setIfscCode(String ifscCode) {
this.ifscCode = ifscCode;
}

}
