package com.yoyling.domain;

import java.io.Serializable;
import java.util.Date;

public class Notify implements Serializable {
    private Integer notifyId;

    private Date notifyDate;

    private String notifyContent;

    private static final long serialVersionUID = 1L;

    public Integer getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(Integer notifyId) {
        this.notifyId = notifyId;
    }

    public Date getNotifyDate() {
        return notifyDate;
    }

    public void setNotifyDate(Date notifyDate) {
        this.notifyDate = notifyDate;
    }

    public String getNotifyContent() {
        return notifyContent;
    }

    public void setNotifyContent(String notifyContent) {
        this.notifyContent = notifyContent == null ? null : notifyContent.trim();
    }

    @Override
    public String toString() {
        return "Notify{" +
                "notifyId=" + notifyId +
                ", notifyDate=" + notifyDate +
                ", notifyContent='" + notifyContent + '\'' +
                '}';
    }
}