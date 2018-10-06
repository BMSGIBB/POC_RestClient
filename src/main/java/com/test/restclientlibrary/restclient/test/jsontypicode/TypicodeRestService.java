package com.test.restclientlibrary.restclient.test.jsontypicode;

import com.test.restclientlibrary.restclient.client.RestService;
import com.test.restclientlibrary.restclient.generator.IRetrofitConfiguration;
import com.test.restclientlibrary.restclient.generator.IRetrofitGenerator;
import com.test.restclientlibrary.restclient.supply.IRetrofitConfigurationTemplate;
import com.test.restclientlibrary.restclient.supply.IRetrofitInterceptorTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.List;

@Service
public class TypicodeRestService extends RestService {

    @Autowired
    public TypicodeRestService(IRetrofitGenerator retroFitGenerator, IRetrofitConfigurationTemplate retrofitConfigurationTemplate, IRetrofitInterceptorTemplate retrofitInterceptorTemplate) {
        super(retroFitGenerator, retrofitConfigurationTemplate, retrofitInterceptorTemplate);
    }

    @Override
    public IRetrofitConfiguration createRetrofitConfiguration() {
        return configurationTemplate.noAuthentication("https://jsonplaceholder.typicode.com");
    }

    public Observable<List<PostDto>> getPostWithIds(List<Integer> idList){
        TypicodeRequest typicodeRequest = retrofit.create(TypicodeRequest.class);
        Observable<List<PostDto>> listObservable = Observable
                .from(idList)
                .flatMap(typicodeRequest::getPost)
                .toList()
                .subscribeOn(Schedulers.io());
        return listObservable;
    }
}
