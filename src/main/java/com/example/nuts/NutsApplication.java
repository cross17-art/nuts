package com.example.nuts;

import com.example.nuts.Service.UserServiceImpl;
import com.example.nuts.models.Role;
import com.example.nuts.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class NutsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NutsApplication.class, args);
	}


	@Bean
	CommandLineRunner run (UserServiceImpl  userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_USER2"));
			userService.saveRole(new Role(null,"ROLE_USER3"));
			userService.saveRole(new Role(null,"ROLE_USER4"));

			userService.saveUser(new User(null,"John Taurus","john","123zxc",new ArrayList<>()));
			userService.saveUser(new User(null,"Will Smith","will","123zxc",new ArrayList<>()));
			userService.saveUser(new User(null,"Ivan Shpilevskiy","ivan","123zxc",new ArrayList<>()));
			userService.saveUser(new User(null,"Burning man","burning","123zxc",new ArrayList<>()));

			userService.addRoleToUser("john","ROLE_USER");
			userService.addRoleToUser("john","ROLE_USER2");
			userService.addRoleToUser("will","ROLE_USER2");
			userService.addRoleToUser("ivan","ROLE_USER3");
			userService.addRoleToUser("burning","ROLE_USER4");
			userService.addRoleToUser("burning","ROLE_USER2");
			userService.addRoleToUser("burning","ROLE_USER3");
		};
	}
}
