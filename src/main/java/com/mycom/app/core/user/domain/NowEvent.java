package com.mycom.app.core.user.domain;

import java.time.Instant;

/**
 * Created by robert on 15/06/17.
 */
public class NowEvent extends Event {
    public NowEvent() {
        super(Instant.now());
    }
}
