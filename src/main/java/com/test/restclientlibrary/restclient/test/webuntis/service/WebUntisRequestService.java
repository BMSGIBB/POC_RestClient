package com.test.restclientlibrary.restclient.test.webuntis.service;


import com.test.restclientlibrary.restclient.test.webuntis.entity.WebUntisRequest;
import com.test.restclientlibrary.restclient.test.webuntis.entity.WebUntisResult;
import com.test.restclientlibrary.restclient.test.webuntis.entity.param.WebUntisCustomTimetableParams;
import com.test.restclientlibrary.restclient.test.webuntis.entity.param.WebUntisTimetableParams;
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

    @POST("/WebUntis/jsonrpc.do?school=gibb")
    Observable<WebUntisResult<List<WebUntisTimegridResult>>> getTimegrid(@Body WebUntisRequest request);

    @POST("/WebUntis/jsonrpc.do?school=gibb")
    Observable<WebUntisResult<WebUntisCurrentSchoolYearResult>> getCurrentSchoolYear(@Body WebUntisRequest request);

    @POST("/WebUntis/jsonrpc.do?school=gibb")
    Observable<WebUntisResult<List<WebUntisCurrentSchoolYearResult>>> getSchoolYears(@Body WebUntisRequest request);

    @POST("/WebUntis/jsonrpc.do?school=gibb")
    Observable<WebUntisResult<List<WebUntisTimetableResult>>> getTimetable(@Body WebUntisRequest<WebUntisTimetableParams> request);

    @POST("/WebUntis/jsonrpc.do?school=gibb")
    Observable<WebUntisResult<List<WebUntisCustomTimetableResult>>> getCustomTimetable(@Body WebUntisRequest<WebUntisCustomTimetableParams> request);
}
