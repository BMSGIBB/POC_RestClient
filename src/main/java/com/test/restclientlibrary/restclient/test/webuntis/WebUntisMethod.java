package com.test.restclientlibrary.restclient.test.webuntis;

public enum WebUntisMethod {
    GET_TEACHERS("getTeachers");

    private String name;

    WebUntisMethod(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
