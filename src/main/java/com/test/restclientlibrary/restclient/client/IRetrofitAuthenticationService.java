package com.test.restclientlibrary.restclient.client;

import com.test.restclientlibrary.restclient.token.IProviderToken;
import rx.Observable;

public interface IRetrofitAuthenticationService<T extends IProviderToken> {
    Observable<T> getAuthenticationToken();
}
