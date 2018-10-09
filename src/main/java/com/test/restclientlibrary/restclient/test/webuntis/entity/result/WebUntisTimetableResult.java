package com.test.restclientlibrary.restclient.test.webuntis.entity.result;

import java.util.Date;
import java.util.List;

public class WebUntisTimetableResult {
    int id;
    Date date;
    int startTime;
    int endTime;
    List<WebUntisTimetableIdResult> kl;
    List<WebUntisTimetableIdResult> te;
    List<WebUntisTimetableIdResult> su;
    List<WebUntisTimetableIdResult> ro;
    String activityType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }


    public List<WebUntisTimetableIdResult> getKl() {
        return kl;
    }

    public void setKl(List<WebUntisTimetableIdResult> kl) {
        this.kl = kl;
    }

    public List<WebUntisTimetableIdResult> getTe() {
        return te;
    }

    public void setTe(List<WebUntisTimetableIdResult> te) {
        this.te = te;
    }

    public List<WebUntisTimetableIdResult> getSu() {
        return su;
    }

    public void setSu(List<WebUntisTimetableIdResult> su) {
        this.su = su;
    }

    public List<WebUntisTimetableIdResult> getRo() {
        return ro;
    }

    public void setRo(List<WebUntisTimetableIdResult> ro) {
        this.ro = ro;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }
}
