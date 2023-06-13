package com.backend.services;

import com.backend.models.Users;


import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<Users> getUsers();
    public void addMember(Users user);
    void deleteUser(Integer userId);

    void updateUser(Integer userId, String name, String email, String password);

    Optional<Users> getUser(Integer userId);
}
