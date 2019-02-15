package com.example.syntagi.patient_watch_application.models;

import java.io.Serializable;

public class OtpResponseData implements Serializable {

    private String oneTimePassword;
    private boolean debugMode;

    public String getOneTimePassword() {
        return oneTimePassword;
    }

    public void setOneTimePassword(String oneTimePassword) {
        this.oneTimePassword = oneTimePassword;
    }

    public boolean isDebugMode() {
        return debugMode;
    }

    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }
    public String showMessage() {
        return "You are in debug mode your pin is "+oneTimePassword;
    }
}

