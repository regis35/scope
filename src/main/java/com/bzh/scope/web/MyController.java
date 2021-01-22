package com.bzh.scope.web;

import com.bzh.scope.data.Event;
import com.bzh.scope.data.MyData;
import com.bzh.scope.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class MyController  {

    @Autowired
    private MyService service;

    @Autowired
    private Event event;

    @PostMapping(value="/data/{name}")
    public CreateResponse create(@PathVariable("name") String name) {

        event.addInfo("method" ,"create");

        MyData data = service.createDate(name);
        data = service.changeId(data);

        event.getInfo().forEach( (k,v) -> {
            log.info("controler -> {}:{}",k,v);
        });

        return CreateResponse.builder().id(data.getId()).build();
    }
    
    
}
