package com.irctc.irctc_backend.service;

import com.irctc.irctc_backend.exception.InvalidUserException;
import com.irctc.irctc_backend.exception.UserAlreadyExistsException;
import com.irctc.irctc_backend.model.User;
import com.irctc.irctc_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserService {

    private final UserRepository userRepository;

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(User user) {

        if (userRepository.existsById(user.getUserId())) {
            throw new UserAlreadyExistsException(
                    "User already exists with id: " + user.getUserId()
            );
        }

        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new InvalidUserException("Name cannot be empty");
        }

        if (user.getEmail() == null ||
                !EMAIL_PATTERN.matcher(user.getEmail()).matches()) {
            throw new InvalidUserException("Invalid email");
        }

        userRepository.save(user);
    }

    public User getUser(int id) {
        return userRepository.findById(id)
                .orElse(null);
    }
}
