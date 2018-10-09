package com.test.restclientlibrary.restclient.test.webuntis;

import com.test.restclientlibrary.restclient.test.webuntis.entity.WebUntisAuthenticationResult;
import com.test.restclientlibrary.restclient.test.webuntis.entity.WebUntisRequest;
import com.test.restclientlibrary.restclient.test.webuntis.entity.param.WebUntisAuthenticationParams;
import com.test.restclientlibrary.restclient.test.webuntis.request.WebUntisAuthenticationRequest;
import com.test.restclientlibrary.restclient.token.IProviderToken;
import com.test.restclientlibrary.restclient.token.ITokenFetcher;
import com.test.restclientlibrary.restclient.token.TokenStore;

import java.time.LocalDateTime;

public class WebUntisTokenStore extends TokenStore {

    private WebUntisAuthenticationRequest retrofitService;
    private WebUntisRequest<WebUntisAuthenticationParams> tokenRequest;
    private LocalDateTime pointOfExpiration;
    private int expiresIn = 720;

    public WebUntisTokenStore(WebUntisAuthenticationRequest webUntisAuthenticationRequest, WebUntisRequest<WebUntisAuthenticationParams> tokenRequest){
        this.retrofitService = webUntisAuthenticationRequest;
        this.tokenRequest = tokenRequest;
        tokenFetcher = createTokenFetcher();
    }

    @Override
    public boolean isTokenExpired() {
        LocalDateTime currentTime = LocalDateTime.now().plusMinutes(2);
        if(pointOfExpiration == null || currentTime.isAfter(pointOfExpiration)){
            return true;
        }
        return false;
    }

    @Override
    public ITokenFetcher<IProviderToken> createTokenFetcher() {
        return () -> {
            WebUntisAuthenticationResult authToken = retrofitService
                    .authenticate(tokenRequest)
                    .toBlocking()
                    .first();
            pointOfExpiration = LocalDateTime.now().plusSeconds(expiresIn);
            return authToken;
        };
    }
}
