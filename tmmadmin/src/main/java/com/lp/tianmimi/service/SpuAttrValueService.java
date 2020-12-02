package com.lp.tianmimi.service;

import com.lp.tianmimi.pojo.SpuAttrValue;

import java.util.List;

public interface SpuAttrValueService {
    /**
     * 根据id获取属性值
     * @param id 属性键的id
     * @return
     */
    List<SpuAttrValue> getSpuAttrValuesByKeyId(Integer id);

    /**
     * 根据id添加属性值
     * @param id
     * @param value_names
     */
    void addAttrValues(Integer id, String[] value_names);
}
