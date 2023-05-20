package com.example.supermarket;

import com.example.supermarket.bean.Goods;
import com.example.supermarket.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SupermarketApplicationTests {

    @Autowired
    GoodsService goodsService;
    @Test
    void contextLoads() {
        List<Integer> test = new ArrayList<>();
        test.add(5);
        test.add(6);
        goodsService.batchDeleteGoods(test);
    }

}
