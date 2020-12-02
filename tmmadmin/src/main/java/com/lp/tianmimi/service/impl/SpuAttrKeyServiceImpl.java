package com.lp.tianmimi.service.impl;

import com.lp.tianmimi.dao.SpuAttrKeyDao;
import com.lp.tianmimi.pojo.SpuAttrKey;
import com.lp.tianmimi.service.SpuAttrKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpuAttrKeyServiceImpl implements SpuAttrKeyService {
    @Autowired
    private SpuAttrKeyDao spuAttrKeyDao;
    @Override
    public List<SpuAttrKey> getAttrKeyList() {
        return spuAttrKeyDao.getAttrKeyList();
    }

    @Override
    public void addSpuAttrKey(SpuAttrKey spuAttrKey, Integer cate_id) {
        //添加属性键
        spuAttrKeyDao.insertSpuAttrKey(spuAttrKey);
        spuAttrKeyDao.insertCategory_SpuAttrKey(cate_id,spuAttrKey.getId());
        //添加属性键与分类表之间的关系
    }

    @Override
    public SpuAttrKey getSpuAttrKeyById(Integer id) {
        return spuAttrKeyDao.getSpuAttrKeyById(id);
    }

    @Override
    public List<SpuAttrKey> getAttrKeySByCateId(Integer id) {
        return spuAttrKeyDao. getAttrKeySByCateId(id);
    }
}
