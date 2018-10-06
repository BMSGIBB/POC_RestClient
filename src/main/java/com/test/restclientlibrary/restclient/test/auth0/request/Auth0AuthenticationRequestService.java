package com.test.restclientlibrary.restclient.test.auth0.request;

import com.test.restclientlibrary.restclient.test.auth0.entity.Auth0Token;
import com.test.restclientlibrary.restclient.test.auth0.entity.Auth0TokenRequest;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface Auth0AuthenticationRequestService {
    @POST("/oauth/token")
    Observable<Auth0Token> getAuthenticationToken(@Body Auth0TokenRequest request);
}
