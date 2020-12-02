package com.lp.tianmimi.service.impl;

import com.lp.tianmimi.dao.BrandDao;
import com.lp.tianmimi.pojo.Brand;
import com.lp.tianmimi.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDao brandDao;
    @Override
    public List<Brand> getBrandList() {
        return brandDao.getBrandList();
    }

    @Override
    public void addBrand(Brand brand) {
        brandDao.addBrand(brand);
    }
}
