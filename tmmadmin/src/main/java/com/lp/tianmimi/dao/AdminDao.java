package com.lp.tianmimi.dao;

import com.lp.tianmimi.pojo.Admin;
import com.lp.tianmimi.pojo.AdminVo;
import com.lp.tianmimi.pojo.RoleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDao {
    Admin getAdminByName(@Param("admin_name") String s);

    /**
     * 获取员工列表
     * @param admin_name
     * @param admin_nickname
     * @return
     */
    List<Admin> getAllAdminList(@Param("admin_name") String admin_name,@Param("admin_nickname") String admin_nickname);

    /**
     * 插入管理员用户和相关的角色信息
     * @param adminVo
     */
    void insertAdmin(AdminVo adminVo);

    /**
     * 插入用户的角色信息
     * @param admin_id
     * @param roleids
     */
    void insertAdminRole(@Param("admin_id") Integer admin_id,@Param("roleids") Integer[] roleids);

    /**
     * 删除管理员员工列表信息(将其状态信息修改为无效)
     * @param id 员工id
     */
    void deleteAdmin(@Param("admin_id") Integer id);

    /**
     * 根据id获取管理员信息
     * @param id
     * @return
     */
    AdminVo getAdminById(@Param("admin_id") Integer id);

    /**
     * 获取当前管理员的角色以及没有拥有的所有角色
     * @param id admin_id用户id
     * @return 角色列表
     */
    List<RoleVo> getRoleListByAdminId(@Param("admin_id") Integer id);

    /**
     * 修改员工信息
     * @param adminVo 封装了员工信息的对象
     */
    void updateAdmin(AdminVo adminVo);

    /**
     * 删除员工的角色信息
     * @param admin_id 员工的id
     */
    void deleteRolesByAdminId(@Param("admin_id") Integer admin_id);



}
