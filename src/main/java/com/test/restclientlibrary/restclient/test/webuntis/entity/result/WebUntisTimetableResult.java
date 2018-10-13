package com.test.restclientlibrary.restclient.test.webuntis.entity.result;

import com.test.restclientlibrary.restclient.test.webuntis.entity.supply.WebUntisTimetableId;

import java.util.Date;
import java.util.List;

public class WebUntisTimetableResult {
    int id;
    Date date;
    int startTime;
    int endTime;
    List<WebUntisTimetableId> kl;
    List<WebUntisTimetableId> te;
    List<WebUntisTimetableId> su;
    List<WebUntisTimetableId> ro;
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


    public List<WebUntisTimetableId> getKl() {
        return kl;
    }

    public void setKl(List<WebUntisTimetableId> kl) {
        this.kl = kl;
    }

    public List<WebUntisTimetableId> getTe() {
        return te;
    }

    public void setTe(List<WebUntisTimetableId> te) {
        this.te = te;
    }

    public List<WebUntisTimetableId> getSu() {
        return su;
    }

    public void setSu(List<WebUntisTimetableId> su) {
        this.su = su;
    }

    public List<WebUntisTimetableId> getRo() {
        return ro;
    }

    public void setRo(List<WebUntisTimetableId> ro) {
        this.ro = ro;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }
}
