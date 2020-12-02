package com.lp.tianmimi.pojo;

public class PermissionVo {
    private  Integer permission_id;
    private  String  permission_name;
    private  Integer pid;
    private  Integer ypermission_id;

    public Integer getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(Integer permission_id) {
        this.permission_id = permission_id;
    }

    public String getPermission_name() {
        return permission_name;
    }

    public void setPermission_name(String permission_name) {
        this.permission_name = permission_name;
    }



    public Integer getYpermission_id() {
        return ypermission_id;
    }

    public void setYpermission_id(Integer ypermission_id) {
        this.ypermission_id = ypermission_id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "PermissionVo{" +
                "permission_id=" + permission_id +
                ", permission_name='" + permission_name + '\'' +
                ", pid=" + pid +
                ", ypermission_id=" + ypermission_id +
                '}';
    }
}
