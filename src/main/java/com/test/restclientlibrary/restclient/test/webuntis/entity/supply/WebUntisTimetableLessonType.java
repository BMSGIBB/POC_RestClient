package com.test.restclientlibrary.restclient.test.webuntis.entity.supply;

import java.util.Arrays;

public enum WebUntisTimetableLessonType {
    LESSON("ls"),
    OFFICE_HOUR("oh"),
    STANDBY("sb"),
    BREAK_SUPERVISION("bs"),
    EXAMINATION("ex");

    String identifier;

    WebUntisTimetableLessonType(String identifier){
        this.identifier = identifier;
    }

    public static WebUntisTimetableLessonType getByIdentifier(String identifier){
        return Arrays.stream(WebUntisTimetableLessonType.values())
                .filter(type -> type.identifier == identifier)
                .findFirst()
                .orElse(WebUntisTimetableLessonType.STANDBY);
    }
}
