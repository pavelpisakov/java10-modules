package domain;

import model.User;

import java.util.Collection;

public interface UserRepository {

    Collection<User> list();

}
