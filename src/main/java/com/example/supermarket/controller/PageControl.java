package com.example.supermarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageControl{
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
