package dao;

public interface DaoFactory {
    UserRepository createRegisteredUserRepository();
}
