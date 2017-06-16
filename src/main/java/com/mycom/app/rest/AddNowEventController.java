package com.mycom.app.rest;

import com.mycom.app.core.user.operations.AddNowEvent;
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
public class AddNowEventController {

    @Autowired
    private AddNowEvent addNowEvent;

    @RequestMapping(value = "/now/{id}", method = RequestMethod.GET)
    public void addNowEvent(@PathVariable("id") String id) {
        addNowEvent.addTo(id);
    }

}
