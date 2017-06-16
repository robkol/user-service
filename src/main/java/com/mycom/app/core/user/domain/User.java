package com.mycom.app.core.user.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by robert on 15/06/17.
 */
public class User {
    private UUID id;
    private String name;
    private String surname;
    private List<Event> userEvents;

    public User(String name, String surname, List<Event> userEvents) {
        this(UUID.randomUUID(), name, surname, userEvents);
    }

    public User(UUID id, String name, String surname, List<Event> userEvents) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.userEvents = userEvents;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void addEvent(Event event) {
        this.userEvents.add(event);
    }

    public List<Event> getUserEvents() {
        return new ArrayList<Event>(userEvents);
    }
}
