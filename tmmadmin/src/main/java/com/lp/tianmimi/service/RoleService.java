package com.lp.tianmimi.service;

import com.lp.tianmimi.pojo.Role;
import com.lp.tianmimi.pojo.RoleVo;

import java.util.List;

public interface RoleService {
    /**
     * 获取所有的角色列表
     * @return
     */
    List<Role> getAllRoles();

    /**
     * 获取所有的角色列表
     * @return
     */
    List<RoleVo> getAllRoleVoList();

    /**
     * 根据角色id获取角色信息及其获得和未获得的权限信息
     * @param id
     * @return
     */
    RoleVo  getRoleById(Integer id);
}
