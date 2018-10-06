package com.test.restclientlibrary;

import com.test.restclientlibrary.restclient.factory.IConverterFactory;
import com.test.restclientlibrary.restclient.test.PostDto;
import com.test.restclientlibrary.restclient.test.ServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

@RestController
public class TestController {

    @Autowired
    ServiceTest serviceTest;


    @RequestMapping("/api/posts/{id}")
    public Observable<PostDto> getPostWithId(@PathVariable("id") int id){
        return serviceTest.getPostWithId(id);
    }
}
