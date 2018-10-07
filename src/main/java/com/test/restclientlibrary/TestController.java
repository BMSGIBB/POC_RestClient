package com.test.restclientlibrary;

import com.test.restclientlibrary.restclient.test.jsontypicode.PostDto;
import com.test.restclientlibrary.restclient.test.jsontypicode.TypicodeRestService;
import com.test.restclientlibrary.restclient.test.auth0.Auth0RestService;
import com.test.restclientlibrary.restclient.test.auth0.entity.Auth0User;
import com.test.restclientlibrary.restclient.test.webuntis.WebUntisRestService;
import com.test.restclientlibrary.restclient.test.webuntis.entity.WebUntisResult;
import com.test.restclientlibrary.restclient.test.webuntis.entity.result.WebUntisTeacherResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping(value = "/api/posts/{idList}", method = RequestMethod.GET)
    public Observable<List<PostDto>> getPostWithIds(@PathVariable("idList") String idList) {
        List<Integer> intList = Arrays
                .stream(idList.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return typicodeRestService.getPostWithIds(intList);
    }

    @RequestMapping(value = "/api/user/{userId}", method = RequestMethod.GET)
    public Observable<Auth0User> getUserById(@PathVariable("userId") String userId){
        return auth0RestService.getUserById(userId);
    }

    @RequestMapping(value = "/api/webuntis/connection", method = RequestMethod.GET)
    public Observable<WebUntisResult<List<WebUntisTeacherResult>>> testConection(){
        return webUntisRestService.getTeachers();
    }
}
