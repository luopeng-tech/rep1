package com.lp.tianmimi.controller;

import com.alibaba.fastjson.JSON;
import com.lp.tianmimi.pojo.Brand;
import com.lp.tianmimi.pojo.Spu;
import com.lp.tianmimi.pojo.SpuAttrKey;
import com.lp.tianmimi.service.BrandService;
import com.lp.tianmimi.service.SpuAttrKeyService;
import com.lp.tianmimi.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.jws.WebParam;
import java.io.Serializable;

@Controller
@RequestMapping("/spu")
public class SpuController {
    @Autowired
    private SpuAttrKeyService spuAttrKeyService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private SpuService spuService;

    @RequestMapping("/admin")
    public String admin(Model model) {
        List<Spu> spuList = spuService.getSpuList();
        model.addAttribute("spuList", spuList);
        return "/spu/admin";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        //查询品牌分类信息，提供选择
        List<Brand> brandList = brandService.getBrandList();
        model.addAttribute("brand", brandList.get(0));
        return "/spu/add";
    }


    //根据分类的id获取属性键值
    @RequestMapping("/get")
    @ResponseBody
    public String getSpuAttrKeys(Integer id) { //根据分类的id获取所有的key的集合

        //获取数据库里面所有的key以及所有的values
        List<SpuAttrKey> list = spuAttrKeyService.getAttrKeySByCateId(id);

        String str = JSON.toJSONString(list);



        return str;
    }

    @RequestMapping("/save")
    public String save(Spu spu, MultipartFile filelist) {
        System.out.println(spu);
        System.out.println(filelist.getOriginalFilename());
        return "redirect:/spu/admin";
    }
}
