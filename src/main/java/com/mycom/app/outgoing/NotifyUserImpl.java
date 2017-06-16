package com.mycom.app.outgoing;

import com.mycom.app.core.user.domain.User;
import com.mycom.app.core.user.operations.NotifyUser;

/**
 * Created by robert on 16/06/17.
 */
public class NotifyUserImpl implements NotifyUser {

    public NotifyUserImpl() {
    }

    @Override
    public void notify(User user) {
        // logic to notify a user, it could be an email or a push notification or whatever.
        System.out.println(String.format("Notifying user somehow %s", user.getId()));
    }
}
