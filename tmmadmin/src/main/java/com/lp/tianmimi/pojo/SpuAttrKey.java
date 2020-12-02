package com.lp.tianmimi.pojo;



import java.util.Date;
import java.util.List;

public class SpuAttrKey {
    private  Integer id;
    private  String key_name;
    private Date createtime;
    private Date updatetime;
    private List<SpuAttrValue> spuAttrValueList;

    public List<SpuAttrValue> getSpuAttrValueList() {
        return spuAttrValueList;
    }

    public void setSpuAttrValueList(List<SpuAttrValue> spuAttrValueList) {
        this.spuAttrValueList = spuAttrValueList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey_name() {
        return key_name;
    }

    public void setKey_name(String key_name) {
        this.key_name = key_name;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "SpuAttrKey{" +
                "id=" + id +
                ", key_name='" + key_name + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", spuAttrValueList=" + spuAttrValueList +
                '}';
    }
}
