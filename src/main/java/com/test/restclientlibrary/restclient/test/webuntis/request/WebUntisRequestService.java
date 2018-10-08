package com.test.restclientlibrary.restclient.test.webuntis.request;


import com.test.restclientlibrary.restclient.test.webuntis.entity.WebUntisRequest;
import com.test.restclientlibrary.restclient.test.webuntis.entity.WebUntisResult;
import com.test.restclientlibrary.restclient.test.webuntis.entity.result.*;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

import java.util.List;

public interface WebUntisRequestService {
    @POST("/WebUntis/jsonrpc.do?school=gibb")
    Observable<WebUntisResult<List<WebUntisTeacherResult>>> getTeachers(@Body WebUntisRequest request);

    @POST("/WebUntis/jsonrpc.do?school=gibb")
    Observable<WebUntisResult<List<WebUntisStudentResult>>> getStudents(@Body WebUntisRequest request);

    @POST("/WebUntis/jsonrpc.do?school=gibb")
    Observable<WebUntisResult<List<WebUntisSchoolClassResult>>> getSchoolClasses(@Body WebUntisRequest request);

    @POST("/WebUntis/jsonrpc.do?school=gibb")
    Observable<WebUntisResult<List<WebUntisSubjectResult>>> getSubjects(@Body WebUntisRequest request);

    @POST("/WebUntis/jsonrpc.do?school=gibb")
    Observable<WebUntisResult<List<WebUntisRoomResult>>> getRooms(@Body WebUntisRequest request);

    @POST("/WebUntis/jsonrpc.do?school=gibb")
    Observable<WebUntisResult<List<WebUntisDepartmentResult>>> getDepartments(@Body WebUntisRequest request);

    @POST("/WebUntis/jsonrpc.do?school=gibb")
    Observable<WebUntisResult<List<WebUntisHolidayResult>>> getHolidays(@Body WebUntisRequest request);
}
