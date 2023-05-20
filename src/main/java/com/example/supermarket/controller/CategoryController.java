package com.example.supermarket.controller;

import com.example.supermarket.bean.Category;
import com.example.supermarket.mapper.CategoryMapper;
import com.example.supermarket.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {
    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @RequestMapping("/delete_category")
    String delete(@RequestParam("cid") int cid){
        categoryMapper.deleteCategory(cid);
        goodsMapper.deleteGoodsByCid(cid);
        return "redirect:category";
    }

    @RequestMapping("/add_category")
    String add(@RequestParam("cname") String cname){
        categoryMapper.addCategory(cname);
        return "redirect:category";
    }

    @RequestMapping("/update_category")
    String update(Category category){
        categoryMapper.updateCategory(category);
        goodsMapper.updateGoodsByCid(category);
        return "redirect:category";
    }
}
