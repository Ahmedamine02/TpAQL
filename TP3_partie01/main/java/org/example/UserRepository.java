package org.example;


public interface UserRepository {
    User findUserById(long id);

    void save(User user);

    Object findById(long id);
}
