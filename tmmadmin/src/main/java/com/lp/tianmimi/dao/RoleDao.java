package com.lp.tianmimi.dao;

import com.lp.tianmimi.pojo.Role;
import com.lp.tianmimi.pojo.RoleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    List<Role> getRoleListByAdminId(@Param("admin_id") Integer admin_id);

    List<Role> getRoleListByOperateUrl(@Param("operate_url") String requestUrl);

    //获取所有的角色列表
    List<Role> getAllRoles();

    //获取所有的角色列表
    List<RoleVo> getAllRoleVoList();

    //根据角色id获取角色信息
    RoleVo getRoleById(@Param("role_id") Integer id);
}
