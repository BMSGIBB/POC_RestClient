package com.test.restclientlibrary.restclient.test;

import com.test.restclientlibrary.restclient.generator.RetrofitConfiguration;
import com.test.restclientlibrary.restclient.generator.IRetrofitGenerator;
import com.test.restclientlibrary.restclient.supply.RetrofitCofigurations;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.http.POST;
import rx.Observable;

import java.lang.reflect.Type;
import java.sql.PreparedStatement;

@Service
public class ServiceTest {
    private Retrofit retrofit;

    RetrofitConfiguration configuration;

    public ServiceTest(IRetrofitGenerator retroFitGenerator, RetrofitCofigurations retrofitCofigurations) {
        this.configuration = retrofitCofigurations.notAuthentication("https://jsonplaceholder.typicode.com");
        this.retrofit = retroFitGenerator.generate(configuration);
    }

    public Observable<PostDto> getPostWithId(int id){
        return retrofit
                .create(TypicodeRequest.class)
                .getPost(id);
    }
}
