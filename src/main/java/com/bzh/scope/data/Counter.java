package com.bzh.scope.data;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@ToString
@NoArgsConstructor
public class Counter {

    private int nbIdObject = 0;
    private int nbEventObject = 0;

    public void incNbIdObject() {
        nbIdObject++;
    }

    public void incNbEventObject() {
        nbEventObject++;
    }

}
