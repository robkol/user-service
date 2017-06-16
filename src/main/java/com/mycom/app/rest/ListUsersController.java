package com.mycom.app.rest;

import com.mycom.app.core.user.domain.User;
import com.mycom.app.core.user.operations.ListUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by robert on 16/06/17.
 */
@RestController
@RequestMapping("/users")
public class ListUsersController {

    @Autowired
    private ListUsers listUsers;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> list() {
        return listUsers.list();
    }

}
