package com.lp.tianmimi.service.impl;

import com.lp.tianmimi.dao.RoleDao;
import com.lp.tianmimi.pojo.Role;
import com.lp.tianmimi.pojo.RoleVo;
import com.lp.tianmimi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao rd;
    @Override
    public List<Role> getAllRoles() {
        return rd.getAllRoles();
    }

    @Override
    public List<RoleVo> getAllRoleVoList() {
        return rd.getAllRoleVoList();
    }

    @Override
    public RoleVo getRoleById(Integer id) {
        return rd.getRoleById(id);
    }
}
