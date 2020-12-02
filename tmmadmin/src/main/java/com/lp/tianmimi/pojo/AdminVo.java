package com.lp.tianmimi.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdminVo {
    private Integer admin_id;       // 员工编号

    private String admin_name;      // 登录账户名称

    private String admin_pass;      // 登录账户密码

    private String admin_nickname;
    private Integer[] roleids;
    private List<Role> roleList = new ArrayList<>();
    private List<RoleVo> roleVoList = new ArrayList<>();

    public List<RoleVo> getRoleVoList() {
        return roleVoList;
    }

    public void setRoleVoList(List<RoleVo> roleVoList) {
        this.roleVoList = roleVoList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_pass() {
        return admin_pass;
    }

    public void setAdmin_pass(String admin_pass) {
        this.admin_pass = admin_pass;
    }

    public String getAdmin_nickname() {
        return admin_nickname;
    }

    public void setAdmin_nickname(String admin_nickname) {
        this.admin_nickname = admin_nickname;
    }

    public Integer[] getRoleids() {
        return roleids;
    }

    public void setRoleids(Integer[] roleids) {
        this.roleids = roleids;
    }

    @Override
    public String toString() {
        return "AdminVo{" +
                "admin_id=" + admin_id +
                ", admin_name='" + admin_name + '\'' +
                ", admin_pass='" + admin_pass + '\'' +
                ", admin_nickname='" + admin_nickname + '\'' +
                ", roleids=" + Arrays.toString(roleids) +
                ", roleList=" + roleList +
                ", roleVoList=" + roleVoList +
                '}';
    }
}
