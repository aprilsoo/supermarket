package com.example.supermarket.controller;

import com.example.supermarket.service.CategroyService;
import com.example.supermarket.service.GoodsService;
import com.example.supermarket.utils.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PageController {

    @Autowired
    CategroyService categroyService;

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/category")
    public String category(Model model){
        model.addAttribute("categoryList",categroyService.getAllCategory());
        return "category";
    }

    @RequestMapping("/addc_page")
    public String addCategory(){
        return "add_category";
    }

    @RequestMapping("/updc_page")
    public String updateCategory(@RequestParam("cid") int cid,Model model){
        model.addAttribute("category",categroyService.getCategoryById(cid));
        return "upd_category";
    }

    @RequestMapping("/goods_admin")
    public String goodsAdmin(Model model){
        model.addAttribute("goodsList",goodsService.getAllGoods());
        return "goods_admin";
    }

    @RequestMapping("/addg_page")
    public String addGoods(Model model){
        model.addAttribute("categoryList",categroyService.getAllCategory());
        return "add_goods";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Map<String,Object> upload(MultipartFile file){
        String base64= Base64Util.converToBase64(file);
        Map<String,Object> map=new HashMap();
        map.put("img",base64);
        return map;
    }

    @RequestMapping("/updg_page")
    public String updateGoods(@RequestParam("gid") int gid,Model model){
        model.addAttribute("goods",goodsService.getGoodsById(gid));
        model.addAttribute("categoryList",categroyService.getAllCategory());
        return "upd_goods";
    }

    @RequestMapping("/goods_user")
    public String goodsUser(Model model){
        model.addAttribute("categoryList",categroyService.getAllCategory());
        model.addAttribute("goodsList",goodsService.getGoodsByStatus("已上架"));
        List<Integer> cids = new ArrayList<>();
        model.addAttribute("cids",cids);
        return "goods_user";
    }

    @RequestMapping("/")
    public String index(){
        return "redirect:login";
    }
}
