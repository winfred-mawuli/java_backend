package com.backend.services;

import com.backend.models.User;


import java.util.List;
import java.util.Optional;


public interface UserService {
    public List<User> getUsers();

    public void addMember(User user);

    void deleteUser(Integer userId);

    void updateUser(Integer userId, String name, String email, String password);

    Optional<User> getUser(Integer userId);
}
