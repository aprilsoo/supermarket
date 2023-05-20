package com.example.supermarket.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthUser {
    int uid;
    String username;
    String password;
    String role;
}