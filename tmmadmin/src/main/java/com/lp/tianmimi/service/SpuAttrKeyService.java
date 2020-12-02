package com.lp.tianmimi.service;

import com.lp.tianmimi.pojo.SpuAttrKey;

import java.util.List;

public interface SpuAttrKeyService {
    /**
     * 获取属性键
     * @return
     */
    List<SpuAttrKey> getAttrKeyList();

    /**
     * 添加属性键
     * @param spuAttrKey
     * @param cate_id
     */
    void addSpuAttrKey(SpuAttrKey spuAttrKey, Integer cate_id);

    /**
     * 根据id获取属性键
     * @param id
     * @return
     */
    SpuAttrKey getSpuAttrKeyById(Integer id);

    /**
     * 根据分类id获取对应的属性键和值
     * @param id
     * @return
     */
    List<SpuAttrKey> getAttrKeySByCateId(Integer id);
}
