package com.lp.tianmimi.dao;

import com.lp.tianmimi.pojo.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryDao {
    /**
     * 获取所有的分类列表
     * @return
     */
    List<Category> getAllCategoryList();

    /**
     * 将分类添加到分类列表
     * @param category
     */
    void addCategory(Category category);

    /**
     * 添加品牌和分类之间的关系
     * @param i 品牌id
     * @param id 分类的id
     */
    void addBrand_Category(@Param("brand_id") int i, @Param("category_id") Integer id);

    /**
     * 根据id查询品牌信息
     * @param spu_category_id
     * @return
     */
    Category getCategoryById(@Param("spu_category_id") Integer spu_category_id);

    /**
     * 根据品牌id获取分类列表
     * @param id
     * @return
     */
    List<Category> getCategoryListByBrandId(@Param("brand_id") Integer id);
}
