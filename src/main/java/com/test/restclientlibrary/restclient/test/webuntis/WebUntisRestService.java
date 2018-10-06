package com.test.restclientlibrary.restclient.test.webuntis;

import com.test.restclientlibrary.restclient.client.RestService;
import com.test.restclientlibrary.restclient.generator.IRetrofitConfiguration;
import com.test.restclientlibrary.restclient.generator.IRetrofitGenerator;
import com.test.restclientlibrary.restclient.supply.IRetrofitConfigurationTemplate;
import com.test.restclientlibrary.restclient.supply.IRetrofitInterceptorTemplate;
import com.test.restclientlibrary.restclient.test.webuntis.entity.WebUntisFactory;
import com.test.restclientlibrary.restclient.test.webuntis.entity.WebUntisRequest;
import com.test.restclientlibrary.restclient.test.webuntis.entity.param.WebUntisAuthenticateParams;

public class WebUntisRestService extends RestService {

    WebUntisFactory webUntisFactory;
    WebUntisProperties webUntisProperties;

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
    }

    @Override
    public IRetrofitConfiguration createRetrofitConfiguration() {

        WebUntisAuthenticateParams params = new WebUntisAuthenticateParams() {{
            user = webUntisProperties.getUsername();
            password = webUntisProperties.getPassword();
            client = webUntisProperties.getClient();
        }};

        WebUntisRequest<WebUntisAuthenticateParams> requestBody =
                webUntisFactory.generateAuthenticateRequest(params);
        //TODO Go on implementing WebUntis authentication request
        return null;
    }
}
