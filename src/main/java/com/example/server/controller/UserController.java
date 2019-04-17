package com.example.server.controller;

import org.springframework.web.bind.annotation.*;

import com.example.server.model.User;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class UserController {

    @GetMapping(produces = "application/json")
    @RequestMapping({ "/login" })
    public User login() {
        return new User("User successfully authenticated");
    }

}
