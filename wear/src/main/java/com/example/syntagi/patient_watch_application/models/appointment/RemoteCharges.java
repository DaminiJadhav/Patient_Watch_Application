package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RemoteCharges {

@SerializedName("chatCharges")
@Expose
private ChatCharges chatCharges;
@SerializedName("audioCharges")
@Expose
private AudioCharges audioCharges;
@SerializedName("videoCharges")
@Expose
private VideoCharges videoCharges;

public ChatCharges getChatCharges() {
return chatCharges;
}

public void setChatCharges(ChatCharges chatCharges) {
this.chatCharges = chatCharges;
}

public AudioCharges getAudioCharges() {
return audioCharges;
}

public void setAudioCharges(AudioCharges audioCharges) {
this.audioCharges = audioCharges;
}

public VideoCharges getVideoCharges() {
return videoCharges;
}

public void setVideoCharges(VideoCharges videoCharges) {
this.videoCharges = videoCharges;
}

}