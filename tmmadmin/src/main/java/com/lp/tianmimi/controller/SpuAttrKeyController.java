package com.lp.tianmimi.controller;

import com.lp.tianmimi.pojo.Category;
import com.lp.tianmimi.pojo.SpuAttrKey;
import com.lp.tianmimi.service.CategoryService;
import com.lp.tianmimi.service.SpuAttrKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/spuattrkey")
public class SpuAttrKeyController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SpuAttrKeyService spuAttrKeyService;

    @RequestMapping("/admin")
    public String admin(Model model) {
        //根据品牌查询对应的属性键
        List<SpuAttrKey> spuAttrKeyList = spuAttrKeyService.getAttrKeyList();
        model.addAttribute("spuAttrkeyList", spuAttrKeyList);

        return "/spuattrkey/admin";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        //获取分类情况
        List<Category> categoryList = categoryService.getAllCategoryList();
        model.addAttribute("categoryList", categoryList);
        return null;
    }

    @RequestMapping("/save")
    public String save(SpuAttrKey spuAttrKey,Integer cate_id) {
        //往属性中添加属性键
        //往属性-分类表中添加关系
        spuAttrKey.setCreatetime(new Date());
        spuAttrKey.setUpdatetime(new Date());
        spuAttrKeyService.addSpuAttrKey(spuAttrKey,cate_id);

        return "redirect:/spuattrkey/admin";
    }
}
