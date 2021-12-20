package com.example.nuts.Repository;

import com.example.nuts.models.Role;
import com.example.nuts.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByName(String name);

}
