package com.lp.tianmimi.dao;

import com.lp.tianmimi.pojo.PermissionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionDao {
    /**
     * 获取当前角色的所有权限，包括未获取的权限
     * @param id 角色的id
     * @return
     */
    List<PermissionVo> getAllPermissionByRoleId(@Param("role_id") Integer id);
}
