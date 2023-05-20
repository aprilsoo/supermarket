package com.example.supermarket.service;

import com.example.supermarket.bean.AuthUser;

import javax.servlet.http.HttpSession;

public interface AuthService {
    boolean register(String username,String password);

    AuthUser findUser(HttpSession session);
}
