package com.lp.tianmimi.dao;

import com.lp.tianmimi.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandDao {
    /**
     * 获取所有的品牌列表
     * @return
     */
    List<Brand> getBrandList();

    /**
     * 添加品牌
     * @param brand
     */
    void addBrand(Brand brand);

    /**
     * 根据id获取品牌信息
     * @param spu_brand_id
     * @return
     */
    Brand getBrandById(@Param("spu_brand_id") Integer spu_brand_id);
}
