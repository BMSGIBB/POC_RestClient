package com.test.restclientlibrary.restclient.test;

import com.test.restclientlibrary.restclient.generator.IRetrofitConfiguration;
import com.test.restclientlibrary.restclient.generator.IRetrofitGenerator;
import com.test.restclientlibrary.restclient.supply.RetrofitConfigurationTemplate;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.List;

@Service
public class ServiceTest {
    private Retrofit retrofit;

    IRetrofitConfiguration configuration;

    public ServiceTest(IRetrofitGenerator retroFitGenerator, RetrofitConfigurationTemplate retrofitConfigurationTemplate) {
        this.configuration = retrofitConfigurationTemplate.noAuthentication("https://jsonplaceholder.typicode.com");
        this.retrofit = retroFitGenerator.generate(configuration);
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
