package com.lp.tianmimi.controller;

import com.lp.tianmimi.pojo.Brand;
import com.lp.tianmimi.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;
    @RequestMapping("/admin")
    public String admin(Model model){
        List<Brand> brandList=brandService.getBrandList();
        model.addAttribute("brandList",brandList);
        return  "/brand/admin";
    }
    @RequestMapping("/add")
    public  String add(){
        return "/brand/add";
    }
    @RequestMapping("/save")
    public String save(Brand brand){
        brand.setBrand_introduction(brand.getBrand_name());
        brand.setUpdatetime(new Date());
        brand.setSortno(1);
        brand.setCreatetime(new Date());
        //执行添加品牌的操作
        brandService.addBrand(brand);
        return "redirect:/brand/admin";
    }
}
