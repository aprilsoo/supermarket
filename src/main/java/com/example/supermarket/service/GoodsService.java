package com.example.supermarket.service;

import com.example.supermarket.bean.Category;
import com.example.supermarket.bean.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> getAllGoods();

    Goods getGoodsById(int gid);

    int deleteGoods(int gid);

    int deleteGoodsByCid(int cid);

    int addGoods(Goods goods);

    int updateGoods(Goods goods);

    int updateGoodsByCid(Category category);

    int batchDeleteGoods(List<Integer> gids);

    List<Goods> getGoodsByStatus(String status);

    List<Goods> getGoodsByCid(List<Integer> cids);
}
