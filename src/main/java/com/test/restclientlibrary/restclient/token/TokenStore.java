package com.test.restclientlibrary.restclient.token;

public abstract class TokenStore implements ITokenStore<IProviderToken> {
    IProviderToken token;
    ITokenFetcher<IProviderToken> tokenFetcher;

    @Override
    public String getToken() {
        if(isTokenExpired()){
            fetchTokenFromProvider(tokenFetcher);
        }
        return token.getToken();
    }

    private void fetchTokenFromProvider(ITokenFetcher<IProviderToken> tokenFetcher) {
        token = tokenFetcher.fetchToken();
    }

    @Override
    public abstract boolean isTokenExpired();

    public abstract ITokenFetcher<IProviderToken> createTokenFetcher();
}
