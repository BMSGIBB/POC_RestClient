package com.test.restclientlibrary.restclient.test.webuntis.entity;

import com.test.restclientlibrary.restclient.test.webuntis.entity.request.WebUntisRequest;
import org.springframework.stereotype.Component;

@Component
public class WebUntisFactory {
    public <T> WebUntisRequest<T> generateRequestWithoutParams(String method) {
        WebUntisRequest<T> request = new WebUntisRequest<>();
        request.jsonrpc = "2.0";
        request.id = "ID";
        request.method = method;
        return request;
    }

    public <Param> WebUntisRequest<Param> generateRequest(String method, Param param) {
        WebUntisRequest<Param> request = new WebUntisRequest<>();
        request.jsonrpc = "2.0";
        request.id = "ID";
        request.method = method;
        request.params = param;
        return request;
    }

    public <Param> WebUntisRequest<Param> generateAuthenticateRequest(Param param) {
        WebUntisRequest<Param> request = new WebUntisRequest<Param>();
        request.jsonrpc = "2.0";
        request.id = "ID";
        request.method = "authenticate";
        request.params = param;
        return request;
    }
}
