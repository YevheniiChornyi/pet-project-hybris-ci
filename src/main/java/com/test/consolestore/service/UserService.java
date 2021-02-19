package com.test.consolestore.service;

import com.test.consolestore.entity.User;
import com.test.consolestore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User authorizeOrCreateUser(Scanner scanner) {
        System.out.println("Input login: ");
        String login = scanner.next();

        User user = new User();
        user.setLogin(login);

        Optional<User> userFromDb = findUser(user);
        if (!userFromDb.isPresent()) {
            System.out.println("User with input login not found. Do you want to sign up?(yes/no)");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("yes")) {
                return createUser(user);
            } else {
                throw new IllegalArgumentException("User declined registration");
            }
        } else {
            return userFromDb.get();
        }
    }

    private Optional<User> findUser(User user) {
        return userRepository.findByLogin(user.getLogin());
    }

    private User createUser(User user) {
        return userRepository.save(user);
    }
}
