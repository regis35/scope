package com.bzh.scope.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
@NoArgsConstructor
@Slf4j
@ToString
public class Id {

    private final String id = Integer.toString(new Random().nextInt());
    @Autowired
    private Counter counter;

    @PostConstruct
    public void postConstruct() {
        log.info("Create new object");
        counter.incNbIdObject();
    }


}
