package client;

import domain.UserRepository;
import model.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.ServiceLoader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    @Test
    public void test() {

        ServiceLoader<UserRepository> repos = ServiceLoader.load(UserRepository.class);
        UserRepository repository = repos.findFirst().orElse(null);

        assertThat(repository, is(not(nullValue())));

        Collection<User> users = repository.getAll();
        logger.info("getAll users: {}", users);

        assertThat(users, iterableWithSize(1));

        User user = users.iterator().next();
        assertThat(user, is(not(nullValue())));
        assertThat(user.getName(), equalTo("Hello"));
        assertThat(user.getEmail(), equalTo("World"));

        logger.info("getAll users: {}", repository.getAll());

    }

}
