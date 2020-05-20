package com.codegym.controller;

import com.codegym.model.Role;
import com.codegym.model.Users;
import com.codegym.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UsersService usersService;

    @PostMapping("api/register")
    public ResponseEntity<Void> saveUsers(@RequestBody Users users) {
        System.out.println(users.getEmail());
        System.out.println(users.getUserName());
        System.out.println(users.getPassword());
        System.out.println(users.getPhone());
        String role="ROLE_USER";
        Role role1= new Role(1L,role);
        users.setRole(role1);
        usersService.save(users);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
