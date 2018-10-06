package com.test.restclientlibrary.restclient.token;

public abstract class TokenStore implements ITokenStore {
    IProviderToken token;

    @Override
    public String getToken() {
        return token.getToken();
    }

    @Override
    public void fetchTokenFromProvider(ITokenFetcher<IProviderToken> tokenFetcher) {
        token = tokenFetcher.fetchToken();
    }

    @Override
    public abstract boolean isTokenExpired();
}
