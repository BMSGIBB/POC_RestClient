package com.test.restclientlibrary.restclient.test.auth0;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class Auth0Properties {

    @Value("${auth0.audience}")
    private String audience;

    @Value("${auth0.client_id}")
    private String client_id;

    @Value("${auth0.client_secret}")
    private String client_secret;

    @Value("${auth0.grant_type}")
    private String grant_type;

    @Value("${auth0.baseUrl}")
    private String baseUrl;

    public String getAudience() {
        return audience;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
