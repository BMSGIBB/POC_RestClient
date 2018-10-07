package com.test.restclientlibrary.restclient.test.webuntis.entity;

import com.test.restclientlibrary.restclient.test.webuntis.entity.result.WebUntisAuthenticateResult;
import com.test.restclientlibrary.restclient.token.IProviderToken;

public class WebUntisAuthenticationResult implements IProviderToken {
    public String jsonrpc;
    public String id;
    public WebUntisAuthenticateResult result;

    @Override
    public String getToken() {
        return result.sessionId;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public WebUntisAuthenticateResult getResult() {
        return result;
    }

    public void setResult(WebUntisAuthenticateResult result) {
        this.result = result;
    }
}
