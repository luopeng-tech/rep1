package com.lp.tianmimi.service.impl;

import com.lp.tianmimi.dao.PermissionDao;
import com.lp.tianmimi.pojo.PermissionVo;
import com.lp.tianmimi.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    @Override
    public List<PermissionVo> getAllPermissionByRoleId(Integer id) {
        return permissionDao.getAllPermissionByRoleId(id);
    }
}
