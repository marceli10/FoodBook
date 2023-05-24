package com.example.foodbook.service;

import com.example.foodbook.model.User;
import com.example.foodbook.model.security.Provider;
import com.example.foodbook.repository.UserRepository;
import com.example.foodbook.service.dto.GoogleProfileDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.foodbook.model.security.SecurityRoles.USER;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserFromGoogle(GoogleProfileDto profileDto) {
        Optional<User> user = userRepository.findUserByEmailAndProvider(profileDto.email(), Provider.GOOGLE);
        if (user.isEmpty()) {
            user = Optional.of(registerNewGoogleUser(profileDto));
        }
        return user.get();
    }

    private User registerNewGoogleUser(GoogleProfileDto profileDto) {
        User user = new User(
                profileDto.email(),
                profileDto.pictureUrl(),
                profileDto.firstName(),
                profileDto.lastName(),
                Provider.GOOGLE,
                USER
        );
        return userRepository.save(user);
    }
}
