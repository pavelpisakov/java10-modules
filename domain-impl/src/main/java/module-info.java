import domain.UserRepository;
import domain.impl.UserRepositoryImpl;

module domain.impl {
    requires domain;
    provides UserRepository with UserRepositoryImpl;
}