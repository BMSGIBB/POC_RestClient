package com.test.restclientlibrary.restclient.test.webuntis;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.test.restclientlibrary.restclient.client.RestService;
import com.test.restclientlibrary.restclient.generator.IRetrofitConfiguration;
import com.test.restclientlibrary.restclient.generator.IRetrofitGenerator;
import com.test.restclientlibrary.restclient.supply.IRetrofitConfigurationTemplate;
import com.test.restclientlibrary.restclient.supply.IRetrofitInterceptorTemplate;
import com.test.restclientlibrary.restclient.test.webuntis.entity.WebUntisFactory;
import com.test.restclientlibrary.restclient.test.webuntis.entity.WebUntisRequest;
import com.test.restclientlibrary.restclient.test.webuntis.entity.WebUntisResult;
import com.test.restclientlibrary.restclient.test.webuntis.entity.param.WebUntisAuthenticationParams;
import com.test.restclientlibrary.restclient.test.webuntis.entity.result.WebUntisTeacherResult;
import com.test.restclientlibrary.restclient.test.webuntis.request.WebUntisAuthenticationRequest;
import com.test.restclientlibrary.restclient.test.webuntis.request.WebUntisRequestService;
import okhttp3.CookieJar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import rx.Observable;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class WebUntisRestService extends RestService {

    WebUntisFactory webUntisFactory;
    WebUntisProperties webUntisProperties;
    WebUntisRequestService webUntisRequestService;

    @Autowired
    public WebUntisRestService(
            IRetrofitGenerator retroFitGenerator,
            IRetrofitConfigurationTemplate retrofitConfigurationTemplate,
            IRetrofitInterceptorTemplate retrofitInterceptorTemplate,
            WebUntisProperties webUntisProperties,
            WebUntisFactory webUntisFactory) {
        super(retroFitGenerator, retrofitConfigurationTemplate, retrofitInterceptorTemplate);
        this.webUntisFactory = webUntisFactory;
        this.webUntisProperties = webUntisProperties;
        initialize();
        this.webUntisRequestService = retrofit.create(WebUntisRequestService.class);
    }

    @Override
    public IRetrofitConfiguration createRetrofitConfiguration() {
        WebUntisAuthenticationParams params = new WebUntisAuthenticationParams();
        params.setUser(webUntisProperties.getUsername());
        params.setPassword(webUntisProperties.getPassword());
        params.setClient(webUntisProperties.getClient());

        WebUntisRequest requestBody = webUntisFactory.generateAuthenticateRequest(params);

        Retrofit webuntisAuthenticationRetrofit = generator.generate(configurationTemplate.noAuthentication(webUntisProperties.getBaseUrl()));
        WebUntisAuthenticationRequest authenticationRequest = webuntisAuthenticationRetrofit.create(WebUntisAuthenticationRequest.class);

        CookieJar cookieJar = interceptorTemplate.withJsessonId(new WebUntisTokenStore(authenticationRequest, requestBody));
        return configurationTemplate.withCookieAuhentication(webUntisProperties.getBaseUrl(), cookieJar);
    }

    public Observable<WebUntisResult<List<WebUntisTeacherResult>>> getTeachers() {
        return this.webUntisRequestService.getTeachers(webUntisFactory.generateRequest(WebUntisMethod.GET_TEACHERS.getName(), Object.class));
    }
}
