package com.bzh.scope.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Slf4j
@NoArgsConstructor
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Event {

    @Autowired
    private Counter counter;

    private Map<String, String> info = new HashMap<>();

    @PostConstruct
    public void postConstruct() {
        log.info("Create new object");
        counter.incNbEventObject();
    }

    public void addInfo(String key, String data) {
        info.put(key, data);
    }

}
