package com.test.restclientlibrary.restclient.test.webuntis.entity.result;

import java.util.Arrays;

public enum WebUntisTimetableCode {
    EMPTY(""),
    CANCELLED("cancelled"),
    IRREGULAR("irregular");
    String code;

    WebUntisTimetableCode(String code) {
        this.code = code;
    }

    public static WebUntisTimetableCode getByCode(String code){
        return Arrays.stream(WebUntisTimetableCode.values())
                .filter(type -> type.code == code)
                .findFirst()
                .orElse(null);
    }
}
