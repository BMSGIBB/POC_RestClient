package com.test.restclientlibrary.restclient.test.webuntis.entity.supply;

import java.util.Arrays;

public enum WebUntisDay {

    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7),
    SUNDAY(1);

    private int id;

    WebUntisDay(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public static WebUntisDay getById(int id){
        return Arrays.stream(WebUntisDay.values())
                .filter(day -> day.id == id)
                .findFirst()
                .orElse(WebUntisDay.MONDAY);
    }
}
