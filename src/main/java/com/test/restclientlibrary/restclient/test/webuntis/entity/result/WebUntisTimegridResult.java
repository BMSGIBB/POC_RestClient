package com.test.restclientlibrary.restclient.test.webuntis.entity.result;

import com.test.restclientlibrary.restclient.test.webuntis.entity.supply.WebUntisDay;
import com.test.restclientlibrary.restclient.test.webuntis.entity.supply.WebUntisTimeUnit;

import java.util.List;

public class WebUntisTimegridResult {
    public WebUntisDay day;
    public List<WebUntisTimeUnit> timeUnits;

    public WebUntisDay getDay() {
        return day;
    }

    public void setDay(WebUntisDay day) {
        this.day = day;
    }

    public List<WebUntisTimeUnit> getTimeUnits() {
        return timeUnits;
    }

    public void setTimeUnits(List<WebUntisTimeUnit> timeUnits) {
        this.timeUnits = timeUnits;
    }
}
