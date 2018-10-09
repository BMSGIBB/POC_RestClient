package com.test.restclientlibrary.restclient.test.webuntis;

public enum WebUntisMethod {
    GET_TEACHERS("getTeachers"),
    GET_STUDENTS("getStudents"),
    GET_SCHOOL_CLASSES("getKlassen"),
    GET_SUBJECTS("getSubjects"),
    GET_ROOMS("getRooms"),
    GET_DEPARTMENTS("getDepartments"),
    GET_HOLIDAYS("getHolidays"),
    GET_TIMEGRID_UNITS("getTimegridUnits"),
    GET_CURRENT_SCHOOL_YEAR("getCurrentSchoolyear"),
    GET_SCHOOL_YEARS("getSchoolyears"),
    GET_TIMETABLE("getTimetable");

    private String name;

    WebUntisMethod(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
