package com.mycom.app.outgoing;

import com.google.gson.Gson;
import com.mycom.app.core.user.domain.User;
import com.mycom.app.core.user.operations.EmitUser;

/**
 * Created by robert on 16/06/17.
 */
public class SystemOutEmitUser implements EmitUser {
    @Override
    public void emit(User user) {
        System.out.println(new Gson().toJson(user));
    }
}
