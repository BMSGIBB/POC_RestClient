package com.test.restclientlibrary.restclient.test.webuntis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class WebUntisProperties {

    @Value("${webuntis.baseUrl}")
    private String baseUrl;

    @Value("${webuntis.username}")
    private String username;

    @Value("${webuntis.password}")
    private String password;

    @Value("${webuntis.client}")
    private String client;

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getClient() {
        return client;
    }
}
