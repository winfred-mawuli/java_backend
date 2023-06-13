package com.backend.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Users {
    @Id
    @SequenceGenerator(name = "User_id",
            sequenceName = "user_id_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_id_sequence")
    private Integer id;
    private String name;
    private String email;
    private String password;

}
