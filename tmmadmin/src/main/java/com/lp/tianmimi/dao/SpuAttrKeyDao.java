package com.lp.tianmimi.dao;

import com.lp.tianmimi.pojo.SpuAttrKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpuAttrKeyDao {
    /**
     * 获取商品属性键
     * @return
     */
    List<SpuAttrKey> getAttrKeyList();

    /**
     *属性键表中插入属性
     * @param spuAttrKey
     */
    void insertSpuAttrKey(SpuAttrKey spuAttrKey);

    /**
     * 属性-分类表中插入关系
     * @param cate_id
     * @param id
     */
    void insertCategory_SpuAttrKey(@Param("cate_id") Integer cate_id,@Param("spuattrkey_id") Integer id);

    /**
     * 根据id获取属性键
     * @param id
     * @return
     */
    SpuAttrKey getSpuAttrKeyById(@Param("id") Integer id);

    /**
     * 根据分类id获取对应的属性键和值
     * @param id
     * @return
     */
    List<SpuAttrKey> getAttrKeySByCateId(@Param("cate_id") Integer id);
}
