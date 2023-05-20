package com.example.supermarket.service.impl;

import com.example.supermarket.bean.Category;
import com.example.supermarket.bean.Goods;
import com.example.supermarket.mapper.CategoryMapper;
import com.example.supermarket.service.CategroyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategroyService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategory() {
        return categoryMapper.allCategory();
    }

    @Override
    public Category getCategoryById(int cid) {
        return categoryMapper.getCategoryById(cid);
    }

    @Override
    public int deleteCategory(int cid) {
        return categoryMapper.deleteCategory(cid);
    }

    @Override
    public int addCategory(String cname) {
        return categoryMapper.addCategory(cname);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryMapper.updateCategory(category);
    }

}
