package com.example.nuts.api;


import com.example.nuts.Service.UserService;
import com.example.nuts.Service.UserServiceImpl;
import com.example.nuts.models.Role;
import com.example.nuts.models.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/path")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;


    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }


    @PostMapping("/users/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/path/users").toUriString());
        System.out.println("uri users" + uri);
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }


    @PostMapping("/role/save")
    public ResponseEntity<Role> saveUser(@RequestBody RoleToUser roleToUser) {
        userService.addRoleToUser(roleToUser.getUsername(), roleToUser.getRolename());
        return ResponseEntity.ok().build();
    }


}

@Data
class RoleToUser {
    private String username;
    private String rolename;
}