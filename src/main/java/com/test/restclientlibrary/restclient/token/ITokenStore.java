package com.test.restclientlibrary.restclient.token;

public interface ITokenStore {
    String getToken();
    void fetchTokenFromProvider(ITokenFetcher<IProviderToken> tokenFetcher);
    boolean isTokenExpired();
}
