package com.test.restclientlibrary.restclient.test.auth0;

import com.test.restclientlibrary.restclient.client.RestService;
import com.test.restclientlibrary.restclient.generator.IRetrofitConfiguration;
import com.test.restclientlibrary.restclient.generator.IRetrofitGenerator;
import com.test.restclientlibrary.restclient.supply.IRetrofitConfigurationTemplate;
import com.test.restclientlibrary.restclient.supply.IRetrofitInterceptorTemplate;
import com.test.restclientlibrary.restclient.test.auth0.entity.Auth0TokenRequest;
import com.test.restclientlibrary.restclient.test.auth0.entity.Auth0User;
import com.test.restclientlibrary.restclient.test.auth0.request.Auth0AuthenticationRequestService;
import com.test.restclientlibrary.restclient.test.auth0.request.Auth0RequestService;
import okhttp3.Interceptor;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import rx.Observable;


@Service
public class Auth0RestService extends RestService{

    Auth0RequestService auth0RequestService;
    Auth0AuthenticationRequestService auth0AuthenticationRequestService;
    Auth0Properties auth0Properties;

    public Auth0RestService(IRetrofitGenerator retroFitGenerator, IRetrofitConfigurationTemplate retrofitConfigurationTemplate, IRetrofitInterceptorTemplate retrofitInterceptorTemplate, Auth0Properties auth0Properties) {
        super(retroFitGenerator, retrofitConfigurationTemplate, retrofitInterceptorTemplate);
        this.auth0Properties = auth0Properties;
        initialize();
        this.auth0RequestService = retrofit.create(Auth0RequestService.class);
    }

    @Override
    public IRetrofitConfiguration createRetrofitConfiguration() {

        Auth0TokenRequest tokenRequest = new Auth0TokenRequest();
        tokenRequest.audience = auth0Properties.getAudience();
        tokenRequest.client_id = auth0Properties.getClient_id();
        tokenRequest.client_secret = auth0Properties.getClient_secret();
        tokenRequest.grant_type = auth0Properties.getGrant_type();

        Retrofit authenticationRetrofit = generator.generate(configurationTemplate.noAuthentication(auth0Properties.getBaseUrl()));
        auth0AuthenticationRequestService = authenticationRetrofit.create(Auth0AuthenticationRequestService.class);

        Interceptor interceptor = interceptorTemplate.withBearerToken(new Auth0TokenStore(auth0AuthenticationRequestService, tokenRequest));
        return configurationTemplate.withAuthenticaton(auth0Properties.getBaseUrl(), interceptor);
    }

    public Observable<Auth0User> getUserById(String id){
        return this.auth0RequestService.getUserById(id);
    }
}
