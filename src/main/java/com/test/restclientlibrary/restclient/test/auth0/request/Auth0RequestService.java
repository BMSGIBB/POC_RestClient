package com.test.restclientlibrary.restclient.test.auth0.request;

import com.test.restclientlibrary.restclient.test.auth0.entity.Auth0Token;
import com.test.restclientlibrary.restclient.test.auth0.entity.Auth0TokenRequest;
import com.test.restclientlibrary.restclient.test.auth0.entity.Auth0User;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

public interface Auth0RequestService {

    @POST("/oauth/token")
    Observable<Auth0Token> getAuthenticationToken(@Body Auth0TokenRequest request);

    @GET("/api/v2/users/{userId}")
    Observable<Auth0User> getUserById(@Path("userId") String userId);
}

