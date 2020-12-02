package com.lp.tianmimi.service.impl;

import com.lp.tianmimi.dao.CategoryDao;
import com.lp.tianmimi.pojo.Category;
import com.lp.tianmimi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public List<Category> getAllCategoryList() {
        return categoryDao.getAllCategoryList();
    }

    @Override
    public void addCategory(Category category, int i) {
        //i代表的是当前品牌的id
        //将分类添加到分类表
        categoryDao.addCategory(category);
        System.out.println(category.getId());
        //根据分类的id添加关系表
        categoryDao.addBrand_Category(i,category.getId());

    }
}
