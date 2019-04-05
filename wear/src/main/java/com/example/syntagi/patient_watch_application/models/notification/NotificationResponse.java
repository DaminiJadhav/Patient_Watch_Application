package com.example.syntagi.patient_watch_application.models.notification;

import com.example.syntagi.patient_watch_application.models.BaseApiResponse;
import java.io.Serializable;
import java.util.List;

public class NotificationResponse extends BaseApiResponse implements Serializable {
    List<NotificationData> data;
    public List<NotificationData> getData() {
        return data;
    }

    public void setData(List<NotificationData> data) {
        this.data = data;
    }
}
