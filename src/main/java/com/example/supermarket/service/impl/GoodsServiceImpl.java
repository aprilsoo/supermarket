package com.example.supermarket.service.impl;

import com.example.supermarket.bean.Category;
import com.example.supermarket.bean.Goods;
import com.example.supermarket.mapper.GoodsMapper;
import com.example.supermarket.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> getAllGoods() {
        return goodsMapper.allGoods();
    }

    @Override
    public Goods getGoodsById(int gid) {
        return goodsMapper.getGoodsById(gid);
    }

    @Override
    public int deleteGoods(int gid) {
        return goodsMapper.deleteGoods(gid);
    }

    @Override
    public int deleteGoodsByCid(int cid) {
        return goodsMapper.deleteGoodsByCid(cid);
    }

    @Override
    public int addGoods(Goods goods) {
        return goodsMapper.addGoods(goods);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods);
    }

    @Override
    public int updateGoodsByCid(Category category) {
        return updateGoodsByCid(category);
    }

    @Override
    public int batchDeleteGoods(List<Integer> gids) {
        return goodsMapper.batchDeleteGoods(gids);
    }

    @Override
    public List<Goods> getGoodsByStatus(String status) {
        return goodsMapper.getGoodsByStatus(status);
    }

    @Override
    public List<Goods> getGoodsByCid(List<Integer> cids) {
        return goodsMapper.getGoodsByCid(cids);
    }
}
