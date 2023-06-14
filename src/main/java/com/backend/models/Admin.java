package com.backend.models;

import com.backend.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
public class Admin {
    @Id
    @SequenceGenerator(
            name = "Admin_id",
            sequenceName = "admin_id_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "admin_id_sequence")
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private Role role;

    public Admin(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = Role.ADMIN;
    }


}
