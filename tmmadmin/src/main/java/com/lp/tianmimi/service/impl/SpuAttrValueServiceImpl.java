package com.lp.tianmimi.service.impl;

import com.lp.tianmimi.dao.SpuAttrValueDao;
import com.lp.tianmimi.pojo.SpuAttrValue;
import com.lp.tianmimi.service.SpuAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpuAttrValueServiceImpl  implements SpuAttrValueService {
    @Autowired
    private SpuAttrValueDao spuAttrValueDao;
    @Override
    public List<SpuAttrValue> getSpuAttrValuesByKeyId(Integer id) {
        return spuAttrValueDao.getSpuAttrValuesByKeyId(id);
    }

    @Override
    public void addAttrValues(Integer id, String[] value_names) {
        spuAttrValueDao.addAttrValues(id,value_names);
    }
}
