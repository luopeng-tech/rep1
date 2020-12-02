package com.lp.tianmimi.service.impl;

import com.lp.tianmimi.dao.SpuDao;
import com.lp.tianmimi.pojo.Spu;
import com.lp.tianmimi.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SpuServiceImpl implements SpuService {
    @Autowired
    private SpuDao spuDao;
    @Override
    public List<Spu> getSpuList() {
        return spuDao.getSpuList();
    }
}
