package domain.impl;

import domain.UserRepository;
import model.User;

import java.util.Collection;
import java.util.Collections;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public Collection<User> list() {
        return Collections.singletonList(new User(1L, "hello", "world"));
    }

}
