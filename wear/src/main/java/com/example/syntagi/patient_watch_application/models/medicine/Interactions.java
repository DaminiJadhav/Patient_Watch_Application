package com.example.syntagi.patient_watch_application.models.medicine;

public class Interactions {
    private InteractionData pregnancy;
    private InteractionData food;
    private InteractionData lactation;
    private InteractionData alcohol;

    public InteractionData getPregnancy() {
        return pregnancy;
    }

    public InteractionData getFood() {
        return food;
    }

    public InteractionData getLactation() {
        return lactation;
    }

    public InteractionData getAlcohol() {
        return alcohol;
    }
}