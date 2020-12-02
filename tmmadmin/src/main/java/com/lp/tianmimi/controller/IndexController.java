package com.lp.tianmimi.controller;

import com.lp.tianmimi.pojo.Admin;
import com.lp.tianmimi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = {"/", "/index"})
public class IndexController {
    @Autowired
    private AdminService adminService;
    @RequestMapping(value = {"/", "/index"})
    public String index(Authentication authentication, HttpSession session) {
        //System.out.println(adminService);
        String username=authentication.getName();
        Admin admin=adminService.getAdminByName(username);
        session.setAttribute("roleList",admin.getRoleList());
        session.setAttribute("menuList",admin.getMenuList());
        session.setAttribute("admin_nickname",admin.getAdmin_nickname());
        return "index/tmmadminindex";
    }
}
