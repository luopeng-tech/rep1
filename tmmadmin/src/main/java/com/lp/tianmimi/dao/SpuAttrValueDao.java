package com.lp.tianmimi.dao;

import com.lp.tianmimi.pojo.SpuAttrValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpuAttrValueDao {
    /**
     * 获取属性值
     * @param id
     * @return
     */
    List<SpuAttrValue> getSpuAttrValuesByKeyId(@Param("id") Integer id);

    /**
     * 根据id添加属性值
     * @param id
     * @param value_names
     */
    void addAttrValues(@Param("id") Integer id,@Param("value_names") String[] value_names);
}
