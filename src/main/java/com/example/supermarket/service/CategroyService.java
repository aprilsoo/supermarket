package com.example.supermarket.service;

import com.example.supermarket.bean.Category;

import java.util.List;

public interface CategroyService {
    List<Category> getAllCategory();

    Category getCategoryById(int cid);

    int deleteCategory(int cid);

    int addCategory(String cname);

    int updateCategory(Category category);

}
