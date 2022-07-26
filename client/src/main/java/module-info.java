import domain.UserRepository;

module client {
    requires domain;
    requires org.slf4j;
    uses UserRepository;
}