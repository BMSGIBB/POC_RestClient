package com.test.restclientlibrary.restclient.test.webuntis.entity.supply;

import com.test.restclientlibrary.restclient.test.webuntis.entity.supply.WebUntisTimetableId;

public class WebUntisCustomTimetableField extends WebUntisTimetableId {
    String name;
    String longName;
    String externalkey;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getExternalkey() {
        return externalkey;
    }

    public void setExternalkey(String externalkey) {
        this.externalkey = externalkey;
    }
}
