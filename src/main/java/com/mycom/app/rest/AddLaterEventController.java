package com.mycom.app.rest;

import com.mycom.app.core.user.operations.AddLaterEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by robert on 16/06/17.
 */
@RestController
@RequestMapping("/user")
public class AddLaterEventController {

    @Autowired
    AddLaterEvent addLaterEvent;

    @RequestMapping(value = "/later/{id}/{time}", method = RequestMethod.GET)
    public void addLaterEvent(@PathVariable("id") String id, @PathVariable("time") long time) {
        addLaterEvent.addTo(id, time);
    }
}
