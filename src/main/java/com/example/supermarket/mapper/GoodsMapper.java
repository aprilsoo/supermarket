package com.example.supermarket.mapper;

import com.example.supermarket.bean.Category;
import com.example.supermarket.bean.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper {
    @Select("select * from goods")
    List<Goods> allGoods();

    @Select("select * from goods where gid = #{gid}")
    Goods getGoodsById(int gid);

    @Delete("delete from goods where gid = #{gid}")
    int deleteGoods(int gid);

    @Delete("delete from goods where cid = #{cid}")
    int deleteGoodsByCid(int cid);

    @Insert("insert into goods(cid,gname,cname,price,number,status,img) values(#{cid},#{gname},#{cname},#{price},#{number},#{status},#{img})")
    int addGoods(Goods goods);

    @Update("update goods set cid = #{cid},gname = #{gname},cname = #{cname},price = #{price},number = #{number},status = #{status},img = #{img} where gid = #{gid}")
    int updateGoods(Goods goods);

    @Update("update goods set cname = #{cname} where cid = #{cid}")
    int updateGoodsByCid(Category category);

    @Delete("<script> delete from goods where gid in <foreach collection='list' item='gid' open='(' separator=',' close=')'>#{gid}</foreach> </script>")
    int batchDeleteGoods(List<Integer> gids);

    @Select("select * from goods where status = #{status}")
    List<Goods> getGoodsByStatus(String status);

    @Select("<script> select * from goods where status = \'已上架\' and cid in <foreach collection='list' item='cid' open='(' separator=',' close=')'>#{cid}</foreach> </script>")
    List<Goods> getGoodsByCid(List<Integer> cids);
}
