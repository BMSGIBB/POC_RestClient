package com.test.restclientlibrary.restclient.test.webuntis.entity.supply;

import java.util.Arrays;

public enum WebUntisTimeTableKeyType {
    ID("id"),
    NAME("name"),
    EXTERNAL("externalkey");

    String keyType;

    WebUntisTimeTableKeyType(String keyType) {
        this.keyType = keyType;
    }

    public String getKeyType() {
        return keyType;
    }

    public static WebUntisTimeTableKeyType getByCode(String keyType){
        return Arrays.stream(WebUntisTimeTableKeyType.values())
                .filter(table -> table.keyType.equals(keyType))
                .findFirst()
                .orElse(null);
    }
}
