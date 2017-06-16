package com.mycom.app.core.user.repository;

import com.mycom.app.core.user.domain.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by robert on 15/06/17.
 */
public interface UserRepo {
    public Optional<User> load(UUID userId);
    public boolean save(User user);
    public List<User> getAllUsers();
}
