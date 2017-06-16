package com.mycom.app;

import com.mycom.app.outgoing.NotifyUserImpl;
import com.mycom.app.outgoing.SystemOutEmitUser;
import com.mycom.app.persistence.UserRepoHashMap;
import com.mycom.app.core.user.domain.User;
import com.mycom.app.core.user.operations.*;
import com.mycom.app.core.user.repository.UserRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by robert on 16/06/17.
 */
@Configuration
public class AppConfig {

    @Bean
    public UserRepo createUserRepo() {
        HashMap<UUID, User> init = new HashMap<>();
        User user = new User("foo", "bar", new ArrayList<>());
        init.put(user.getId(), user);
        return new UserRepoHashMap(init);
    }

    @Bean
    public EmitUser createEmitUser() {
        return new SystemOutEmitUser();
    }

    @Bean
    public AddNowEvent createAddNowEvent(UserRepo userRepo, EmitUser emitUser) {
        return new AddNowEventImpl(userRepo, emitUser);
    }

    @Bean
    public AddLaterEvent createAddLaterEvent(UserRepo userRepo, EmitUser emitUser) {
        return new AddLaterEventImpl(userRepo, emitUser, new NotifyUserImpl());
    }

    @Bean
    public ListUsers createListUsers(UserRepo userRepo) {
        return new ListUsersImpl(userRepo);
    }
}
