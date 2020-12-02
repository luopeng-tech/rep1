package com.lp.tianmimi.pojo;

import java.util.ArrayList;
import java.util.List;

public class RoleVo {
    private Integer role_id;
    private String role_name;
    private Integer yrole_id;//标识，如果有值表示当前用户拥有该角色
    private List<PermissionVo> permissionVoList=new ArrayList<>();
    private  Integer[] permissionids;

    public Integer[] getPermissionids() {
        return permissionids;
    }

    public void setPermissionids(Integer[] permissionids) {
        this.permissionids = permissionids;
    }

    public List<PermissionVo> getPermissionVoList() {
        return permissionVoList;
    }

    public void setPermissionVoList(List<PermissionVo> permissionVoList) {
        this.permissionVoList = permissionVoList;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Integer getYrole_id() {
        return yrole_id;
    }

    public void setYrole_id(Integer yrole_id) {
        this.yrole_id = yrole_id;
    }

    @Override
    public String toString() {
        return "RoleVo{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", yrole_id=" + yrole_id +
                ", permissionVoList=" + permissionVoList +
                '}';
    }
}

