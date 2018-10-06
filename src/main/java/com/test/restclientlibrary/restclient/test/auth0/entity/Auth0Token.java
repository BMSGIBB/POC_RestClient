package com.test.restclientlibrary.restclient.test.auth0.entity;

import com.test.restclientlibrary.restclient.token.IProviderToken;

public class Auth0Token implements IProviderToken {

    public String access_token;
    public String token_type;

    @Override
    public String getToken() {
        return access_token;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }
}
