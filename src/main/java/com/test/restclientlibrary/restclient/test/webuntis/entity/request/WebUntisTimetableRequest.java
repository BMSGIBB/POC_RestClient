package com.test.restclientlibrary.restclient.test.webuntis.entity.request;

import com.test.restclientlibrary.restclient.test.webuntis.entity.WebUntisTimetableType;

import java.util.Date;

public class WebUntisTimetableRequest {
    int id;
    WebUntisTimetableType type;
    Date startDate;
    Date endDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WebUntisTimetableType getType() {
        return type;
    }

    public void setType(WebUntisTimetableType type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
