package com.mycom.app.persistence;

import com.mycom.app.core.user.domain.User;
import com.mycom.app.core.user.repository.UserRepo;

import java.util.*;

/**
 * Created by robert on 16/06/17.
 */
public class UserRepoHashMap implements UserRepo {

    HashMap<UUID, User> db;

    public UserRepoHashMap() {
        db = new HashMap<>();
    }

    public UserRepoHashMap(HashMap<UUID, User> db) {
        this.db = db;
    }

    @Override
    public Optional<User> load(UUID userId) {
        User user = db.get(userId);
        return Optional.ofNullable(user);
    }

    @Override
    public boolean save(User user) {
        User put = db.put(user.getId(), user);
        return put != null;
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(db.values());
    }
}
