package com.bzh.scope.service;

import com.bzh.scope.data.Event;
import com.bzh.scope.data.Id;
import com.bzh.scope.data.MyData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyService {

    @Autowired
    private Event event;

    @Autowired
    private Id id;

    public MyData createDate(String name) {
        log.info("first id {}" , id.getId());
        String id_1 = id.getId();
        log.info("second id {}" , id_1);
        MyData data =  MyData.builder().label(name).id(id_1).build();
        log.info("createDate with id {}" , data.getId());

        event.addInfo("label",data.getLabel());
        event.addInfo("id",data.getId());

        return data;
    }

    public MyData changeId(MyData data) {

        event.addInfo("old id",data.getId());
        data.setId(id.getId());
        event.addInfo("id",data.getId());

        return data;
    }

}
