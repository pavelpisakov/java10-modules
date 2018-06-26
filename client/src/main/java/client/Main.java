package client;

import domain.UserRepository;
import java.util.Optional;
import java.util.stream.LongStream;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ServiceLoader;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        new Main().test();
    }

    private void test() {

        ServiceLoader<UserRepository> repos = ServiceLoader.load(UserRepository.class);
        Optional<UserRepository> optionalRepository = repos.findFirst();

        if (!optionalRepository.isPresent()) {
            logger.error("repository is null");
            System.exit(1);
        }

        UserRepository repository = optionalRepository.get();

        LongStream.range(1, 10).forEach(l -> {
            User user = new User();
            user.setName("User " + l);
            user.setEmail("user" + l + "@mail.ru");
            repository.save(user);
        });

        for (User user: repository.getAll()) {
            logger.info("user: {}", user);
        }

        User withNumber2 = repository.findById(2L);
        logger.info("user by id: {}", withNumber2);

    }

}
