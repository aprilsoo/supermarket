package com.example.supermarket.bean;

import lombok.Data;

@Data
public class Goods {
    int gid;
    int cid;
    String gname;
    String cname;
    double price;
    int number;
    String status;
    String img;
}
