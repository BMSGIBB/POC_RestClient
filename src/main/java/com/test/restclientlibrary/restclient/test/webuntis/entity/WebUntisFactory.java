package com.test.restclientlibrary.restclient.test.webuntis.entity;

import com.test.restclientlibrary.restclient.test.webuntis.entity.param.WebUntisAuthenticateParams;
import org.springframework.stereotype.Component;

@Component
public class WebUntisFactory {
    public WebUntisRequest generateRequest(String method, Object param) {
        WebUntisRequest request = new WebUntisRequest();
        request.jsonrps = "2.0";
        request.id = "ID";
        request.method = method;
        request.params = param;
        return request;
    }

    public WebUntisRequest generateAuthenticateRequest(WebUntisAuthenticateParams params){
        WebUntisRequest request = new WebUntisRequest();
        request.jsonrps = "2.0";
        request.id = "ID";
        request.method = "authenticate";
        request.params = params;
        return request;
    }
}
