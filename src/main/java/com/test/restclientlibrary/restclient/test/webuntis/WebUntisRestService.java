package com.test.restclientlibrary.restclient.test.webuntis;

import com.test.restclientlibrary.restclient.client.RestService;
import com.test.restclientlibrary.restclient.generator.IRetrofitConfiguration;
import com.test.restclientlibrary.restclient.generator.IRetrofitGenerator;
import com.test.restclientlibrary.restclient.supply.IRetrofitConfigurationTemplate;
import com.test.restclientlibrary.restclient.supply.IRetrofitInterceptorTemplate;
import com.test.restclientlibrary.restclient.test.webuntis.entity.WebUntisFactory;
import com.test.restclientlibrary.restclient.test.webuntis.entity.request.WebUntisRequest;
import com.test.restclientlibrary.restclient.test.webuntis.entity.WebUntisResult;
import com.test.restclientlibrary.restclient.test.webuntis.entity.param.WebUntisAuthenticationParams;
import com.test.restclientlibrary.restclient.test.webuntis.entity.request.WebUntisTimetableRequest;
import com.test.restclientlibrary.restclient.test.webuntis.entity.result.*;
import com.test.restclientlibrary.restclient.test.webuntis.service.WebUntisAuthenticationRequest;
import com.test.restclientlibrary.restclient.test.webuntis.service.WebUntisRequestService;
import okhttp3.CookieJar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import rx.Observable;

import java.util.List;

@Service
public class WebUntisRestService extends RestService {

    WebUntisFactory webUntisFactory;
    WebUntisProperties webUntisProperties;
    WebUntisRequestService webUntisRequestService;

    @Autowired
    public WebUntisRestService(
            IRetrofitGenerator retroFitGenerator,
            IRetrofitConfigurationTemplate retrofitConfigurationTemplate,
            IRetrofitInterceptorTemplate retrofitInterceptorTemplate,
            WebUntisProperties webUntisProperties,
            WebUntisFactory webUntisFactory) {
        super(retroFitGenerator, retrofitConfigurationTemplate, retrofitInterceptorTemplate);
        this.webUntisFactory = webUntisFactory;
        this.webUntisProperties = webUntisProperties;
        initialize();
        this.webUntisRequestService = retrofit.create(WebUntisRequestService.class);
    }

    @Override
    public IRetrofitConfiguration createRetrofitConfiguration() {
        WebUntisAuthenticationParams params = new WebUntisAuthenticationParams();
        params.setUser(webUntisProperties.getUsername());
        params.setPassword(webUntisProperties.getPassword());
        params.setClient(webUntisProperties.getClient());

        WebUntisRequest requestBody = webUntisFactory.generateAuthenticateRequest(params);

        Retrofit webuntisAuthenticationRetrofit = generator.generate(configurationTemplate.noAuthentication(webUntisProperties.getBaseUrl()));
        WebUntisAuthenticationRequest authenticationRequest = webuntisAuthenticationRetrofit.create(WebUntisAuthenticationRequest.class);

        CookieJar cookieJar = interceptorTemplate.withJsessonId(new WebUntisTokenStore(authenticationRequest, requestBody));
        return configurationTemplate.withCookieAuhentication(webUntisProperties.getBaseUrl(), cookieJar);
    }

    /**
     * Implementation for WebUntis endpoint => 3) Request teachers
     * @return List of all teachers from the school
     */
    public Observable<WebUntisResult<List<WebUntisTeacherResult>>> getTeachers() {
        return this.webUntisRequestService.getTeachers(webUntisFactory.generateRequestWithoutParams(WebUntisMethod.GET_TEACHERS.getName()));
    }

    /**
     * Implementation for WebUntis endpoint => 4) Request students
     * @return List of all students from the school
     */
    public Observable<WebUntisResult<List<WebUntisStudentResult>>> getStudents(){
        return this.webUntisRequestService.getStudents(webUntisFactory.generateRequestWithoutParams(WebUntisMethod.GET_STUDENTS.getName()));
    }

    /**
     * Implementation for WebUntis ednpoint => 5) Request base class
     * @return List of all school classes from the school
     */
    public Observable<WebUntisResult<List<WebUntisSchoolClassResult>>> getSchoolClasses(){
        return this.webUntisRequestService.getSchoolClasses(webUntisFactory.generateRequestWithoutParams(WebUntisMethod.GET_SCHOOL_CLASSES.getName()));
    }

    /**
     * Implementation for WebUntis endpoint => 6) Request subjects
     * @return List of all subjects from the school
     */
    public Observable<WebUntisResult<List<WebUntisSubjectResult>>> getSubjects(){
        return this.webUntisRequestService.getSubjects(webUntisFactory.generateRequestWithoutParams(WebUntisMethod.GET_SUBJECTS.getName()));
    }

    /**
     * Implementation for WebUntis endpoint => 7) Request rooms
     * @return List of all rooms from the school
     */
    public Observable<WebUntisResult<List<WebUntisRoomResult>>> getRooms(){
        return this.webUntisRequestService.getRooms(webUntisFactory.generateRequestWithoutParams(WebUntisMethod.GET_ROOMS.getName()));
    }

    /**
     * Implementation for WebUntis endpoint => 8) Request departments
     * @return List of all departments from the school
     */
    public Observable<WebUntisResult<List<WebUntisDepartmentResult>>> getDepartments(){
        return this.webUntisRequestService.getDepartments(webUntisFactory.generateRequestWithoutParams(WebUntisMethod.GET_DEPARTMENTS.getName()));
    }

    /**
     * Implementation for WebUntis endpoint => 9) Request holidays
     * @return List of all holidays from the school
     */
    public Observable<WebUntisResult<List<WebUntisHolidayResult>>> getHolidays(){
        return this.webUntisRequestService.getHolidays(webUntisFactory.generateRequestWithoutParams(WebUntisMethod.GET_HOLIDAYS.getName()));
    }

    /**
     * Implementation for WebUntis endpoint => 10) Request timegrid
     * @return School timegrid
     */
    public Observable<WebUntisResult<List<WebUntisTimegridResult>>> getTimeGrid(){
        return this.webUntisRequestService.getTimegrid(webUntisFactory.generateRequestWithoutParams(WebUntisMethod.GET_TIMEGRID_UNITS.getName()));
    }

    /**
     * Implementation for WebUntis endpoint => 12) Request current school year
     * @return Current school year
     */
    public Observable<WebUntisResult<WebUntisCurrentSchoolYearResult>> getCurrentSchoolYear(){
        return this.webUntisRequestService.getCurrentSchoolYear(webUntisFactory.generateRequestWithoutParams(WebUntisMethod.GET_CURRENT_SCHOOL_YEAR.getName()));
    }

    /**
     * Implementation for WebUntis endpoint => 13) Request schoolyears
     * @return List of school years from the school
     */
    public Observable<WebUntisResult<List<WebUntisCurrentSchoolYearResult>>> getSchoolYears(){
        return this.webUntisRequestService.getSchoolYears(webUntisFactory.generateRequestWithoutParams(WebUntisMethod.GET_SCHOOL_YEARS.getName()));
    }

    /**
     * Implementation for WebUntis ednpoint => 14 Request timetable for an element (simple)
     * @param request Timetable filter which should be applied to the request (e. g filter by teacher id)
     * @return Timetable with applied filter
     */
    public Observable<WebUntisResult<List<WebUntisTimetableResult>>> getTimetable(WebUntisTimetableRequest request){
        return this.webUntisRequestService.getTimetable(webUntisFactory.generateRequest(WebUntisMethod.GET_TIMETABLE.getName(), request));
    }
}
