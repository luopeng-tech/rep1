package com.lp.tianmimi.pojo;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {
    private Integer role_id;
    private String role_name;

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    @Override
    public String getAuthority() {
        return this.getRole_name();
    }
}
