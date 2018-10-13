package com.test.restclientlibrary.restclient.test.webuntis.service;

import com.test.restclientlibrary.restclient.test.webuntis.entity.result.WebUntisAuthenticationResult;
import com.test.restclientlibrary.restclient.test.webuntis.entity.WebUntisRequest;
import com.test.restclientlibrary.restclient.test.webuntis.entity.param.WebUntisAuthenticationParams;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;


public interface WebUntisAuthenticationRequest {
    @POST("/WebUntis/jsonrpc.do?school=gibb")
    Observable<WebUntisAuthenticationResult> authenticate(@Body WebUntisRequest<WebUntisAuthenticationParams> request);
}
