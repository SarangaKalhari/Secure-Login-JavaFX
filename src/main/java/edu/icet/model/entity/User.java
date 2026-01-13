package edu.icet.model.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
}
