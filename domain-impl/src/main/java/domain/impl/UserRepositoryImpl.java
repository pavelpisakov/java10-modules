package domain.impl;

import domain.UserRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import model.User;

import java.util.Collection;
import java.util.Collections;

public class UserRepositoryImpl implements UserRepository {

    private AtomicLong counter;
    private Map<Long, User> memory;

    public UserRepositoryImpl() {
        counter = new AtomicLong(1L);
        memory = new HashMap<>();
    }

    @Override
    public User save(User user) {
        User newUser = new User();
        newUser.setId(counter.getAndIncrement());
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        memory.put(newUser.getId(), newUser);
        return newUser;
    }

    @Override
    public Collection<User> getAll() {
        return memory.values();
    }

    @Override
    public User findById(Long id) {
        return memory.get(id);
    }

}
