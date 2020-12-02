package com.lp.tianmimi.service;

import com.lp.tianmimi.pojo.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 获取所有的分类列表
     * @return
     */
    List<Category> getAllCategoryList();

    /**
     * 添加分类以及分类和品牌表之间的关系
     * @param category
     * @param i
     */
    void addCategory(Category category, int i);
}
