package com.test.restclientlibrary.restclient.test;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface TypicodeRequest {
    @GET("/todos/{id}")
    Observable<PostDto> getPost(@Path("id") int id);
}
