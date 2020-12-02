package com.lp.tianmimi.dao;

import org.apache.ibatis.annotations.Param;

import java.awt.*;
import java.util.List;

public interface MenuDao {
    public List<Menu> getMenuList(@Param("admin_id") Integer admin_id);
}
