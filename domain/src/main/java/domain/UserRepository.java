package domain;

import model.User;

import java.util.Collection;

public interface UserRepository {

    User save(User user);
    Collection<User> getAll();
    User findById(Long id);

}
