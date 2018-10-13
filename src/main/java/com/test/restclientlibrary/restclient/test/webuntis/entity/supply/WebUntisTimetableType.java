package com.test.restclientlibrary.restclient.test.webuntis.entity.supply;

import java.util.Arrays;


public enum WebUntisTimetableType {
    KLASSE(1),
    TEACHER(2),
    SUBJECT(3),
    ROOM(4),
    STUDENT(5);

    public int id;

    WebUntisTimetableType(int id){
        this.id = id;
    }


    public static WebUntisTimetableType getById(int id){
        return Arrays.stream(WebUntisTimetableType.values())
                .filter(type -> type.id == id)
                .findFirst()
                .orElse(null);
    }
}
