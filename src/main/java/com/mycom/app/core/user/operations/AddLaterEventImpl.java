package com.mycom.app.core.user.operations;

import com.mycom.app.core.user.domain.LaterEvent;
import com.mycom.app.core.user.domain.User;
import com.mycom.app.core.user.repository.UserRepo;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by robert on 16/06/17.
 */
public class AddLaterEventImpl implements AddLaterEvent {

    private UserRepo userRepo;
    private EmitUser emitUser;
    private NotifyUser notifyUser;

    public AddLaterEventImpl(UserRepo userRepo, EmitUser emitUser, NotifyUser notifyUser) {
        this.userRepo = userRepo;
        this.emitUser = emitUser;
        this.notifyUser = notifyUser;
    }

    @Override
    public boolean addTo(String userId, long time) {
        Optional<User> userOptional = userRepo.load(UUID.fromString(userId));

        return userOptional.map((user) -> {
                user.addEvent(new LaterEvent("Some event name", Instant.ofEpochMilli(time)));
                boolean save = userRepo.save(user);
                this.notifyUser.notify(user);
                this.emitUser.emit(user);
                return save;
        })
        .orElse(false);

    }
}
