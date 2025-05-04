package org.example;


public class UsService {
    private final UserRepository userRepository;

    public UsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(long id) {
        return userRepository.findUserById(id);
    }
}
