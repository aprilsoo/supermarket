package com.example.supermarket.mapper;

import com.example.supermarket.bean.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select("select * from category")
    List<Category> allCategory();

    @Select("select * from category where cid = #{cid}")
    Category getCategoryById(int cid);

    @Delete("delete from category where cid = #{cid}")
    int deleteCategory(int cid);

    @Insert("insert into category(cname) values(#{cname})")
    int addCategory(String cname);

    @Update("update category set cname = #{cname} where cid = #{cid}")
    int updateCategory(Category category);
}
