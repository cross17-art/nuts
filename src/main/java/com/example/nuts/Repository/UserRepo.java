package com.example.nuts.Repository;

import com.example.nuts.models.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepo extends JpaRepository<User,Long> {
    User findUserByUsername(String username);
}
