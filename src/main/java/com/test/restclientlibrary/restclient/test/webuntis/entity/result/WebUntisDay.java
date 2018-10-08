package com.test.restclientlibrary.restclient.test.webuntis.entity.result;

public enum WebUntisDay {

    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7),
    SUNDAY(1);

    private int name;

    WebUntisDay(int name){
        this.name = name;
    }

    public int getName(){
        return this.name;
    }
}
