package com.lp.tianmimi.controller;

import com.lp.tianmimi.dao.CategoryDao;
import com.lp.tianmimi.pojo.Category;
import com.lp.tianmimi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@Transactional
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/admin")
    public String admin(Model model){
        //获取分类信息
        List<Category> categoryList=categoryService.getAllCategoryList();

        model.addAttribute("categoryList",categoryList);
        return "/category/admin";
    }
    @RequestMapping("/add")
    public  String add(){
        return "/category/add";
    }
    @RequestMapping("/save")
    public  String save(Category category){
        category.setCreatetime(new Date());
        category.setUpdatetime(new Date());
        //i是品牌的id
        categoryService.addCategory(category,1);
        return "redirect:/category/admin";
    }
}
