package com.example.nuts.Service;

import com.example.nuts.Repository.RoleRepo;
import com.example.nuts.Repository.UserRepo;
import com.example.nuts.models.Role;
import com.example.nuts.models.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        log.info("Save new user {} to the database", user.getName());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Save new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Add new role {} to the user {}", roleName, username);
        User user = userRepo.findUserByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String userName) {
        log.info("Get user {}", userName);
        return userRepo.findUserByUsername(userName);
    }

    @Override
    public List<User> getUsers() {
        log.info("Gea all Users");
        return userRepo.findAll();
    }
}
