package com.test.restclientlibrary;

import com.test.restclientlibrary.restclient.test.jsontypicode.PostDto;
import com.test.restclientlibrary.restclient.test.jsontypicode.TypicodeRestService;
import com.test.restclientlibrary.restclient.test.auth0.Auth0RestService;
import com.test.restclientlibrary.restclient.test.auth0.entity.Auth0User;
import com.test.restclientlibrary.restclient.test.webuntis.WebUntisRestService;
import com.test.restclientlibrary.restclient.test.webuntis.entity.WebUntisResult;
import com.test.restclientlibrary.restclient.test.webuntis.entity.request.WebUntisTimetableRequest;
import com.test.restclientlibrary.restclient.test.webuntis.entity.result.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import rx.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TestController {

    @Autowired
    TypicodeRestService typicodeRestService;

    @Autowired
    Auth0RestService auth0RestService;

    @Autowired
    WebUntisRestService webUntisRestService;

    @RequestMapping(value = "/api/jsontypicode/{idList}", method = RequestMethod.GET)
    public Observable<List<PostDto>> getPostWithIds(@PathVariable("idList") String idList) {
        List<Integer> intList = Arrays
                .stream(idList.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return typicodeRestService.getPostWithIds(intList);
    }

    @RequestMapping(value = "/api/auth0/{userId}", method = RequestMethod.GET)
    public Observable<Auth0User> getUserById(@PathVariable("userId") String userId) {
        return auth0RestService.getUserById(userId);
    }

    @RequestMapping(value = "/api/webuntis/getAllTeachers", method = RequestMethod.GET)
    public Observable<WebUntisResult<List<WebUntisTeacherResult>>> getAllTeachers() {
        return webUntisRestService.getTeachers();
    }

    @RequestMapping(value = "/api/webuntis/getAllStudents", method = RequestMethod.GET)
    public Observable<WebUntisResult<List<WebUntisStudentResult>>> getAllStudents() {
        return webUntisRestService.getStudents();
    }

    @RequestMapping(value = "/api/webuntis/getAllSchoolClasses", method = RequestMethod.GET)
    public Observable<WebUntisResult<List<WebUntisSchoolClassResult>>> getAllSchoolClasses() {
        return webUntisRestService.getSchoolClasses();
    }

    @RequestMapping(value = "/api/webuntis/getAllSubjects", method = RequestMethod.GET)
    public Observable<WebUntisResult<List<WebUntisSubjectResult>>> getAllSubjects() {
        return webUntisRestService.getSubjects();
    }

    @RequestMapping(value = "/api/webuntis/getAllRooms", method = RequestMethod.GET)
    public Observable<WebUntisResult<List<WebUntisRoomResult>>> getAllRooms() {
        return webUntisRestService.getRooms();
    }

    @RequestMapping(value = "/api/webuntis/getAllDepartments", method = RequestMethod.GET)
    public Observable<WebUntisResult<List<WebUntisDepartmentResult>>> getAllDepartments() {
        return webUntisRestService.getDepartments();
    }

    @RequestMapping(value = "/api/webuntis/getAllHolidays", method = RequestMethod.GET)
    public Observable<WebUntisResult<List<WebUntisHolidayResult>>> getAllHolidays() {
        return webUntisRestService.getHolidays();
    }

    @RequestMapping(value = "/api/webuntis/getTimeGrid", method = RequestMethod.GET)
    public Observable<WebUntisResult<List<WebUntisTimegridResult>>> getTimegrid() {
        return webUntisRestService.getTimeGrid();
    }

    @RequestMapping(value = "/api/webuntis/getCurrentSchoolYear", method = RequestMethod.GET)
    public Observable<WebUntisResult<WebUntisCurrentSchoolYearResult>> getCurrentSchoolYear() {
        return webUntisRestService.getCurrentSchoolYear();
    }

    @RequestMapping(value = "/api/webuntis/getAllSchoolYears", method = RequestMethod.GET)
    public Observable<WebUntisResult<List<WebUntisCurrentSchoolYearResult>>> getAllSchoolYears() {
        return webUntisRestService.getSchoolYears();
    }

    @RequestMapping(value = "/api/webuntis/getTimetable", method = RequestMethod.POST)
    public Observable<WebUntisResult<List<WebUntisTimetableResult>>> getTimeTable(@RequestBody WebUntisTimetableRequest request) {
        return webUntisRestService.getTimetable(request);
    }

    @RequestMapping(value = "/api/test", method = RequestMethod.POST)
    public TestEntity test(@RequestBody TestEntity testEntity) {
        return testEntity;
    }

    public class TestEntity {
        public String firstName;
        public String lastName;
    }
}
