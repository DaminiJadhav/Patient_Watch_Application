package com.example.syntagi.patient_watch_application.models.medicine;

public class InteractionData {
    private String tag;
    private String description;
    private String label;
    private boolean show_alert;
    private ColorCode color_code;

    public String getTag() {
        return tag;
    }

    public String getDescription() {
        return description;
    }

    public String getLabel() {
        return label;
    }

    public boolean isShow_alert() {
        return show_alert;
    }

    public String getTagColor() {
        if(color_code!=null){
            return color_code.getLabel();
        }
        return null;
    }
}