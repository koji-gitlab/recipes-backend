package com.example.recipesbackend.runner;

import com.example.recipesbackend.domain.Role;
import com.example.recipesbackend.domain.User;
import com.example.recipesbackend.properties.UserProperties;
import com.example.recipesbackend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class UserCreationRunner implements ApplicationRunner {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserProperties userProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            for (UserProperties.User newUser : userProperties.getUsers()) {
                User user = User.builder()
                        .userName(newUser.getUserName())
                        .password(passwordEncoder.encode(newUser.getPassword()))
                        .role(Role.ROLE_USER)
                        .build();

                if (! userRepository.existsByUserName(user.getUserName())) {
                    user = userRepository.save(user);
                    log.info("User {} created for {}...", user.getId() , newUser.getUserName());
                }
            }
        } catch (Exception ex) {
            log.error("Error running system init", ex);
            throw ex;
        }
    }

}
