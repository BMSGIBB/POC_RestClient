package com.test.restclientlibrary.restclient.test.webuntis.entity.converter;



import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.test.restclientlibrary.restclient.test.webuntis.entity.WebUntisTimetableType;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Optional;

@JsonComponent
public class WebUntisTimetableTypeDeserializer extends JsonDeserializer<WebUntisTimetableType>{
    @Override
    public WebUntisTimetableType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        int number = jsonParser.getValueAsInt();
        Optional<WebUntisTimetableType> first = Arrays.stream(WebUntisTimetableType.values())
                .filter(x -> x.id == number)
                .findFirst();
        if(first.isPresent()) return first.get();
        return null;
    }
}
