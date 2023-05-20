package com.example.supermarket.service.impl;

import com.example.supermarket.bean.AuthUser;
import com.example.supermarket.mapper.UserMapper;
import com.example.supermarket.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean register(String username,String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        AuthUser user = new AuthUser(0,username,encoder.encode(password),"user");
        if (userMapper.registerUser(user) <= 0){
            throw new RuntimeException("注册失败");
        }
        return true;
    }

    @Override
    public AuthUser findUser(HttpSession session) {
        AuthUser user = (AuthUser) session.getAttribute("user");
        if (user == null){
            SecurityContext context = SecurityContextHolder.getContext();
            Authentication authentication = context.getAuthentication();
            user = userMapper.getPasswordByUsername(authentication.getName());
        }
        return user;
    }
}
