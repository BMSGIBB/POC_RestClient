package com.test.restclientlibrary.restclient.client;

import com.test.restclientlibrary.restclient.generator.IRetrofitGenerator;
import com.test.restclientlibrary.restclient.generator.IRetrofitConfiguration;
import com.test.restclientlibrary.restclient.supply.IRetrofitConfigurationTemplate;
import com.test.restclientlibrary.restclient.supply.IRetrofitInterceptorTemplate;
import com.test.restclientlibrary.restclient.token.ITokenStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;

@Service
public abstract class RestService implements IRestService {

    public Retrofit retrofit;
    private IRetrofitConfiguration configuration;
    public IRetrofitGenerator generator;
    public IRetrofitConfigurationTemplate configurationTemplate;
    public IRetrofitInterceptorTemplate interceptorTemplate;
    public ITokenStore tokenStore;

    @Autowired
    public RestService(
            IRetrofitGenerator retroFitGenerator,
            IRetrofitConfigurationTemplate retrofitConfigurationTemplate,
            IRetrofitInterceptorTemplate retrofitInterceptorTemplate
    ) {
        this.interceptorTemplate = retrofitInterceptorTemplate;
        this.configurationTemplate = retrofitConfigurationTemplate;
        this.generator = retroFitGenerator;
    }

    public void initialize(){
        this.configuration = createRetrofitConfiguration();
        this.retrofit = generator.generate(configuration);
    }

    public abstract IRetrofitConfiguration createRetrofitConfiguration();
}
