package com.mycom.app.core.user.operations;

import com.mycom.app.core.user.domain.NowEvent;
import com.mycom.app.core.user.domain.User;
import com.mycom.app.core.user.repository.UserRepo;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by robert on 15/06/17.
 */
public class AddNowEventImpl implements AddNowEvent {

    private UserRepo userRepo;
    private EmitUser emitUser;

    public AddNowEventImpl(UserRepo userRepo, EmitUser emitUser) {
        this.userRepo = userRepo;
        this.emitUser = emitUser;
    }

    @Override
    public boolean addTo(String userId) {
        Optional<User> userOptional = userRepo.load(UUID.fromString(userId));

        return userOptional.map((user) -> {
            user.addEvent(new NowEvent());
            boolean save = userRepo.save(user);
            emitUser.emit(user);
            return save;
        })
        .orElse(false);
    }
}
