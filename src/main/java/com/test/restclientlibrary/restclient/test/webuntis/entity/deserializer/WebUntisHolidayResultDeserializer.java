package com.test.restclientlibrary.restclient.test.webuntis.entity.deserializer;

import com.google.gson.*;
import com.test.restclientlibrary.restclient.test.webuntis.entity.result.WebUntisHolidayResult;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WebUntisHolidayResultDeserializer implements JsonDeserializer<WebUntisHolidayResult>{
    @Override
    public WebUntisHolidayResult deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        //Assign values to WebUntisHolidayResult from JSON object
        WebUntisHolidayResult holidayResult = new WebUntisHolidayResult();
        holidayResult.setId(jsonObject.get("id").getAsInt());
        holidayResult.setLongName(jsonObject.get("longName").getAsString());
        holidayResult.setName(jsonObject.get("name").getAsString());
        try {
            holidayResult.setStartDate(originalFormat.parse(jsonObject.get("startDate").getAsString()));
            holidayResult.setEndDate(originalFormat.parse(jsonObject.get("endDate").getAsString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return holidayResult;
    }
}
