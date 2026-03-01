package edu.icet.model.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
