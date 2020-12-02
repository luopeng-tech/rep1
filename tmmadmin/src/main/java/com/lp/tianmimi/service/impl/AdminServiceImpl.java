package com.lp.tianmimi.service.impl;

import com.lp.tianmimi.dao.AdminDao;
import com.lp.tianmimi.pojo.Admin;
import com.lp.tianmimi.pojo.AdminVo;
import com.lp.tianmimi.pojo.Menu;
import com.lp.tianmimi.pojo.RoleVo;
import com.lp.tianmimi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao ad;

    @Override
    public Admin getAdminByName(String username) {
       //System.out.println(username);
        Admin admin = ad.getAdminByName(username);
        /*for (Menu m : admin.getMenuList()
        ) {
            System.out.println("fu:" + m.getMenu_name());
            for (Menu m1 : m.getZiMenuList()
            ) {
                System.out.println("zi" + m1.getMenu_name());
            }

        }*/
        return admin;
    }

    @Override
    public List<Admin> getAllAdmin(String admin_name,String admin_nickname) {
        return ad.getAllAdminList(admin_name,admin_nickname);
    }

    @Override
    public void insertAdmin(AdminVo adminVo) {
        //添加admin，完成之后再做关联表的操作
        ad.insertAdmin(adminVo);
    }

    @Override
    public void insertRole(Integer admin_id, Integer[] roleids) {
        ad.insertAdminRole(admin_id, roleids);
    }

    @Override
    public void deleteAdmin(Integer id) {
        ad.deleteAdmin(id);
    }

    @Override
    public AdminVo getAdminById(Integer id) {
        AdminVo adminVo = ad.getAdminById(id);
        List<RoleVo> roleVoList=ad.getRoleListByAdminId(id);
       // System.out.println(roleVoList);
       adminVo.setRoleVoList(roleVoList);
        return adminVo;
    }

    @Override
    public void updateAdmin(AdminVo adminVo) {
        //修改员工信息的时候
        //1.修改员工信息
        ad.updateAdmin(adminVo);
        //2.删除数据库中间表中员工所有的角色信息
        ad.deleteRolesByAdminId(adminVo.getAdmin_id());
        //3.根据当前的选择，重新插入员工的角色信息
        ad.insertAdminRole(adminVo.getAdmin_id(),adminVo.getRoleids());
    }


}
