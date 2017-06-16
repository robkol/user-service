package com.mycom.app.core.user.domain;

import java.time.Instant;

/**
 * Created by robert on 15/06/17.
 */
public class Event implements Comparable<Event> {
    private Instant timestamp;
    
    public Event(Instant timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int compareTo(Event o) {
        return timestamp.compareTo(o.timestamp);
    }
}
