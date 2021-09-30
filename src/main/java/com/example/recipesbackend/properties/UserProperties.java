package com.example.recipesbackend.properties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties("app.data")
@Getter
@Setter
public class UserProperties {

    private List<User> users = new ArrayList<>();

    @Getter
    @Setter
    @NoArgsConstructor
    public static  class User {
        private String userName;
        private String password;
    }

}
