package com.test.restclientlibrary.restclient.token;

public abstract class TokenStore implements ITokenStore<IProviderToken> {
    IProviderToken token;
    public ITokenFetcher<IProviderToken> tokenFetcher;

    @Override
    public String getToken() {
        if(tokenFetcher == null) throw  new IllegalArgumentException("TokenFetcher not available");

        if (isTokenExpired()) {
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
