package com.test.restclientlibrary.restclient.test.webuntis.entity.result;

import java.util.List;

public class WebUntisTimegridResult {
    WebUntisDay day;
    List<WebUntisTimeUnit> result;

    public WebUntisDay getDay() {
        return day;
    }

    public void setDay(WebUntisDay day) {
        this.day = day;
    }

    public List<WebUntisTimeUnit> getResult() {
        return result;
    }

    public void setResult(List<WebUntisTimeUnit> result) {
        this.result = result;
    }
}
