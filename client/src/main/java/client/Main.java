package client;

import domain.UserRepository;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.ServiceLoader;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        new Main().test();
    }

    public void test() {

        ServiceLoader<UserRepository> repos = ServiceLoader.load(UserRepository.class);
        UserRepository repository = repos.findFirst().orElse(null);

        Collection<User> users = repository.list();
        logger.info("list users: {}", users);

        User user = users.iterator().next();
        logger.info("user: {}", user);

    }

}
