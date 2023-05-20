
package com.example.supermarket.controller;

import com.example.supermarket.bean.Category;
import com.example.supermarket.bean.Goods;
import com.example.supermarket.service.CategroyService;
import com.example.supermarket.service.GoodsService;
import org.omg.CORBA.StringHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @Autowired
    CategroyService categroyService;

    @RequestMapping("/delete_goods")
    public String deleteGoods(@RequestParam("gid") int gid){
        goodsService.deleteGoods(gid);
        return "redirect:goods_admin";
    }

    @RequestMapping("/add_goods")
    public String addGoods(Goods goods){
        String cname = categroyService.getCategoryById(goods.getCid()).getCname();
        goods.setCname(cname);
        goodsService.addGoods(goods);
        return "redirect:goods_admin";
    }

    @RequestMapping("/update_goods")
    public String updateGoods(Goods goods){
        String cname = categroyService.getCategoryById(goods.getCid()).getCname();
        goods.setCname(cname);
        goodsService.updateGoods(goods);
        return "redirect:goods_admin";
    }

    @RequestMapping("/batchDeleteGoods")
    public String batchDeleteGoods(@RequestBody List<Integer> gids){
        goodsService.batchDeleteGoods(gids);
        return "redirect:goods_admin";
    }

    @RequestMapping("/search_goods")
    public String searchGoods(@RequestParam(value = "cid",required = false) List<Integer> cids, Model model){
        if (cids == null)   return "redirect:goods_user";
        model.addAttribute("categoryList",categroyService.getAllCategory());
        model.addAttribute("cids",cids);
        model.addAttribute("goodsList",goodsService.getGoodsByCid(cids));
        return "goods_user";
    }
}
