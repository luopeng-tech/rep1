package com.lp.tianmimi.pojo;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private Integer menu_id;
    private  String menu_name;
    private  String menu_url;
    private  Integer pid;
    private List<Menu> ziMenuList=new ArrayList<>();

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<Menu> getZiMenuList() {
        return ziMenuList;
    }

    public void setZiMenuList(List<Menu> ziMenuList) {
        this.ziMenuList = ziMenuList;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menu_id=" + menu_id +
                ", menu_name='" + menu_name + '\'' +
                ", menu_url='" + menu_url + '\'' +
                ", pid=" + pid +
                ", ziMenuList=" + ziMenuList +
                '}';
    }
}
