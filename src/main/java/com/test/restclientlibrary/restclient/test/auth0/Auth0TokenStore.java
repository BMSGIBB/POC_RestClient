package com.test.restclientlibrary.restclient.test.auth0;

import com.test.restclientlibrary.restclient.client.IRetrofitAuthenticationService;
import com.test.restclientlibrary.restclient.token.IProviderToken;
import com.test.restclientlibrary.restclient.token.ITokenFetcher;
import com.test.restclientlibrary.restclient.token.TokenStore;

import java.time.LocalDateTime;

public class Auth0TokenStore extends TokenStore {

    private IRetrofitAuthenticationService<Auth0Token> retrofitService;
    private LocalDateTime pointOfExpiration;
    private int expiresIn = 86400;

    public Auth0TokenStore (IRetrofitAuthenticationService<Auth0Token> retrofitService){
        this.retrofitService = retrofitService;
    }

    @Override
    public boolean isTokenExpired() {
        LocalDateTime currentTime = LocalDateTime.now().minusMinutes(10);
        if(pointOfExpiration == null || pointOfExpiration.isAfter(currentTime)){
            return true;
        }
        return false;
    }

    @Override
    public ITokenFetcher<IProviderToken> createTokenFetcher() {
        return () -> {
            Auth0Token authToken = retrofitService
                    .getAuthenticationToken()
                    .toBlocking()
                    .first();
            pointOfExpiration = LocalDateTime.now().plusSeconds(86400);
            return authToken;
        };
    }
}
