import domain.UserRepository;

module client {
    requires domain;
    requires slf4j.api;
    uses UserRepository;
}