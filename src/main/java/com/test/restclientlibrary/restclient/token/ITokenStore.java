package com.test.restclientlibrary.restclient.token;

public interface ITokenStore<T extends IProviderToken> {
    String getToken();
    boolean isTokenExpired();
}
