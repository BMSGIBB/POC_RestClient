package com.test.restclientlibrary.restclient.test.webuntis.request;


import com.test.restclientlibrary.restclient.test.webuntis.entity.WebUntisRequest;
import com.test.restclientlibrary.restclient.test.webuntis.entity.WebUntisResult;
import com.test.restclientlibrary.restclient.test.webuntis.entity.result.WebUntisTeacherResult;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

import java.util.List;

public interface WebUntisRequestService {
    @POST("/WebUntis/jsonrpc.do?school=gibb")
    Observable<WebUntisResult<List<WebUntisTeacherResult>>> getTeachers(@Body WebUntisRequest request);
}
