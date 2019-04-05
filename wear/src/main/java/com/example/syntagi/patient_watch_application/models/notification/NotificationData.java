package com.example.syntagi.patient_watch_application.models.notification;
import com.example.syntagi.patient_watch_application.models.appointments.BaseApiData;
import java.io.Serializable;

public class NotificationData extends BaseApiData implements Serializable {

    private FromUser fromUser;
    private ToUser toUser;

    private String title;
    private String description;
    private Integer notificationStatus;
    private String metaData;
    private Integer notificationType;
    private Integer notificationParentType;
    private String notificationId;

    public FromUser getFromUser() {
        return fromUser;
    }

    public void setFromUser(FromUser fromUser) {
        this.fromUser = fromUser;
    }
    public ToUser getToUser() {
        return toUser;
    }
    public void setToUser(ToUser toUser) {
        this.toUser = toUser;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(Integer notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }

    public Integer getNotificationType() {
        return notificationType;
    }
    public void setNotificationType(Integer notificationType) {
        this.notificationType = notificationType;
    }

    public Integer getNotificationParentType() {
        return notificationParentType;
    }

    public void setNotificationParentType(Integer notificationParentType) {
        this.notificationParentType = notificationParentType;
    }

    public String getNotificationId() {
        return notificationId;
    }
    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }
}
