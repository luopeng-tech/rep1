package com.lp.tianmimi.service;

import com.lp.tianmimi.pojo.PermissionVo;

import java.util.List;

public interface PermissionService {
    //获取角色的所有权限(包括当前角色未拥有的权限)
    List<PermissionVo> getAllPermissionByRoleId(Integer id);
}
