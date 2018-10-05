package com.test.restclientlibrary.restclient.factory;

import okhttp3.OkHttpClient;

public interface IHttpClientFactory {
    OkHttpClient getBaseClient();
}
