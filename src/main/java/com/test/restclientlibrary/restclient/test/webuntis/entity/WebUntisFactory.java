package com.test.restclientlibrary.restclient.test.webuntis.entity;

import org.springframework.stereotype.Component;

@Component
public class WebUntisFactory {
    public <T> WebUntisRequest<T> generateRequest(String method, T requestType) {
        WebUntisRequest<T> request = new WebUntisRequest<>();
        request.jsonrpc = "2.0";
        request.id = "ID";
        request.method = method;
        return request;
    }

    public <Param> WebUntisRequest<Param> generateAuthenticateRequest(Param param){
        WebUntisRequest<Param> request = new WebUntisRequest<Param>();
        request.jsonrpc = "2.0";
        request.id = "ID";
        request.method = "authenticate";
        request.params = param;
        return request;
    }
}
