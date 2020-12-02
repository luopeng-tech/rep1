package com.lp.tianmimi.service;

import com.lp.tianmimi.pojo.Admin;
import com.lp.tianmimi.pojo.AdminVo;
import com.lp.tianmimi.pojo.RoleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService {
    /**
     * 根据用户名称获取用户对象
     * @param username
     * @return
     */
    public Admin getAdminByName(String username);

    /**
     * 获取所有的管理员对象
     * @return
     */
    List<Admin> getAllAdmin(String admin_name,String admin_nickname);

    /**
     * 插入管理员和管理员角色
     * @param adminVo 封装了管理员和管理员角色信息的对象
     */
    void insertAdmin(AdminVo adminVo);

    /**
     *插入用户角色
     * @param admin_id
     * @param roleids
     */

    void insertRole(@Param("admin_id") Integer admin_id,@Param("roleids") Integer[] roleids);

    /**
     * 删除管理员信息
     * @param id
     */
    void deleteAdmin(Integer id);

    /**
     * 根据id获取管理员信息
     * @param id
     * @return
     */
    AdminVo getAdminById(Integer id);

    /**
     * 修改管理员用户的信息
     * @param adminVo 封装了管理员用户信息的对象
     */

    void updateAdmin(AdminVo adminVo);
}
