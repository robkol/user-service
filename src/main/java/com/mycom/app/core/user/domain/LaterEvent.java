package com.mycom.app.core.user.domain;

import java.time.Instant;

/**
 * Created by robert on 15/06/17.
 */
public class LaterEvent extends Event {
    private String name;

    public LaterEvent(String name, Instant time) {
        super(time);
        this.name = name;
    }
}
