package com.lp.tianmimi.controller;

import com.lp.tianmimi.pojo.SpuAttrKey;
import com.lp.tianmimi.pojo.SpuAttrValue;
import com.lp.tianmimi.service.SpuAttrKeyService;
import com.lp.tianmimi.service.SpuAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/spuattrvalue")
public class SpuAttrValueController {
    @Autowired
    private SpuAttrValueService spuAttrValueService;
    @Autowired
    private SpuAttrKeyService spuAttrKeyService;

    @RequestMapping("/admin")
    public String admin(Model model) {
        //根据品牌查询对应的属性键
        List<SpuAttrKey> spuAttrKeyList = spuAttrKeyService.getAttrKeyList();
        model.addAttribute("spuAttrkeyList", spuAttrKeyList);
        return "/spuattrvalue/admin";
    }

    @RequestMapping("/add")
    public String add(Model model, Integer id) {
        SpuAttrKey spuAttrKey = spuAttrKeyService.getSpuAttrKeyById(id);
        model.addAttribute("spuAttrKey", spuAttrKey);
        return "/spuattrvalue/add";
    }

    @RequestMapping("/detail")
    public String detail(Integer id, Model model) {
        //根据属性键查询对应的属性键
        SpuAttrKey spuAttrKey = spuAttrKeyService.getSpuAttrKeyById(id);
        System.out.println(spuAttrKey);
        //根据id查询对应的属性值
        List<SpuAttrValue> spuAttrValueList = spuAttrValueService.getSpuAttrValuesByKeyId(id);
        System.out.println(spuAttrValueList);
        model.addAttribute("spuAttrKey", spuAttrKey);
        model.addAttribute("spuAttrValueList", spuAttrValueList);
        return "/spuattrvalue/detail";
    }

    @RequestMapping("/save")
    public String save(Integer id, String[] value_names) {
        spuAttrValueService.addAttrValues(id, value_names);
        return "redirect:/spuattrvalue/admin?id=" + id;
    }
}
