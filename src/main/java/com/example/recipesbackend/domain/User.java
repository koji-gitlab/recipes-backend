package com.example.recipesbackend.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
@Data
@Builder
public class User {

    @Id
    private String id;

    private String userName;

    private String password;

    private Role role;

}
