package com.lp.tianmimi.service;

import com.lp.tianmimi.pojo.Brand;

import java.util.List;

public interface BrandService {
    /**
     * 获取品牌列表
     * @return
     */
    List<Brand> getBrandList();

    /**
     * 添加品牌
     * @param brand 封装了品牌信息的对象
     */
    void addBrand(Brand brand);
}
