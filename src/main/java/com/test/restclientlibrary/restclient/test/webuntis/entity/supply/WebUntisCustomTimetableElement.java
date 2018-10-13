package com.test.restclientlibrary.restclient.test.webuntis.entity.supply;

import com.test.restclientlibrary.restclient.test.webuntis.entity.supply.WebUntisTimetableType;
import com.test.restclientlibrary.restclient.test.webuntis.entity.supply.WebUntisTimeTableKeyType;

public class WebUntisCustomTimetableElement {
    String id;
    WebUntisTimetableType type;
    WebUntisTimeTableKeyType keyType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public WebUntisTimetableType getType() {
        return type;
    }

    public void setType(WebUntisTimetableType type) {
        this.type = type;
    }

    public WebUntisTimeTableKeyType getKeyType() {
        return keyType;
    }

    public void setKeyType(WebUntisTimeTableKeyType keyType) {
        this.keyType = keyType;
    }
}
