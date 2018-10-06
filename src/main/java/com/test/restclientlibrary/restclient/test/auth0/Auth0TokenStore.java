package com.test.restclientlibrary.restclient.test.auth0;

import com.test.restclientlibrary.restclient.test.auth0.entity.Auth0Token;
import com.test.restclientlibrary.restclient.test.auth0.entity.Auth0TokenRequest;
import com.test.restclientlibrary.restclient.test.auth0.request.Auth0AuthenticationRequestService;
import com.test.restclientlibrary.restclient.token.IProviderToken;
import com.test.restclientlibrary.restclient.token.ITokenFetcher;
import com.test.restclientlibrary.restclient.token.TokenStore;

import java.time.LocalDateTime;

public class Auth0TokenStore extends TokenStore {

    private Auth0AuthenticationRequestService retrofitService;
    private Auth0TokenRequest tokenRequest;
    private LocalDateTime pointOfExpiration;
    private int expiresIn = 86400;

    public Auth0TokenStore (Auth0AuthenticationRequestService auth0RequestService, Auth0TokenRequest tokenRequest){
        this.retrofitService = auth0RequestService;
        this.tokenRequest = tokenRequest;
        tokenFetcher = createTokenFetcher();
    }

    @Override
    public boolean isTokenExpired() {
        LocalDateTime currentTime = LocalDateTime.now().minusMinutes(10);
        if(pointOfExpiration == null || !pointOfExpiration.isAfter(currentTime)){
            return true;
        }
        return false;
    }

    @Override
    public ITokenFetcher<IProviderToken> createTokenFetcher() {
        return () -> {
            Auth0Token authToken = retrofitService
                    .getAuthenticationToken(tokenRequest)
                    .toBlocking()
                    .first();
            pointOfExpiration = LocalDateTime.now().plusSeconds(expiresIn);
            return authToken;
        };
    }
}
