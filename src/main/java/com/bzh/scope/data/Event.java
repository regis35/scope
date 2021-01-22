package com.bzh.scope.data;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Slf4j
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Event {

    private Map<String,String> info = new HashMap<>();

    public Event(){
        log.info("Create new object");
    }

    public void addInfo(String key, String data) {
        info.put(key,data);
    }

}
