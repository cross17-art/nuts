package com.example.nuts.Service;

import com.example.nuts.models.Role;
import com.example.nuts.models.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String userName);

    List<User> getUsers();

}
