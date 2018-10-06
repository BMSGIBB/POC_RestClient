package com.test.restclientlibrary.restclient.test.auth0;

import com.test.restclientlibrary.restclient.client.IRetrofitAuthenticationService;
import retrofit2.http.GET;
import rx.Observable;

public interface Auth0RequestService extends IRetrofitAuthenticationService<Auth0Token> {
    @Override
    @GET("/oauth/token")
    Observable<Auth0Token> getAuthenticationToken();
}

