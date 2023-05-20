package com.example.supermarket.controller;

import com.example.supermarket.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    AuthService authService;

    @RequestMapping(value = "/doRegister",method = RequestMethod.POST)
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password){
        authService.register(username,password);
        return "login";
    }
}
