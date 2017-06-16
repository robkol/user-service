package com.mycom.app.core.user.operations;

import com.mycom.app.core.user.domain.User;
import com.mycom.app.core.user.repository.UserRepo;

import java.util.List;

/**
 * Created by robert on 16/06/17.
 */
public class ListUsersImpl implements ListUsers {
    private UserRepo userRepo;

    public ListUsersImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> list() {
        return userRepo.getAllUsers();
    }
}
