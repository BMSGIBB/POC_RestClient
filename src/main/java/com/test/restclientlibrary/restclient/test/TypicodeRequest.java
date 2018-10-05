package com.test.restclientlibrary.restclient.test;

import org.springframework.web.bind.annotation.PathVariable;
import retrofit2.http.GET;
import rx.Observable;

public interface TypicodeRequest {
    @GET("/todos/{id}")
    Observable<PostDto> getPost(@PathVariable("id") int id);
}
