package com.test.restclientlibrary;

import com.test.restclientlibrary.restclient.test.PostDto;
import com.test.restclientlibrary.restclient.test.ServiceTest;
import com.test.restclientlibrary.restclient.test.TypicodeRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TestController {

    @Autowired
    TypicodeRestService typicodeRestService;


    @RequestMapping("/api/posts/{idList}")
    public Observable<List<PostDto>> getPostWithIds(@PathVariable("idList") String idList) {
        List<Integer> intList = Arrays
                .stream(idList.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return typicodeRestService.getPostWithIds(intList);
    }
}
