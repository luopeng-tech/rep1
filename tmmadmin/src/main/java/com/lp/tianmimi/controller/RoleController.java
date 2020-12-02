package com.lp.tianmimi.controller;

import com.lp.tianmimi.pojo.PermissionVo;
import com.lp.tianmimi.pojo.RoleVo;
import com.lp.tianmimi.service.PermissionService;
import com.lp.tianmimi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
   private PermissionService permissionService;
    //管理角色信息
    @RequestMapping("/admin")
    public String admin(Model model) {
        //获取所有的角色列表
        List<RoleVo> roleVoList=roleService.getAllRoleVoList();
        model.addAttribute("roleList",roleVoList);
        return "/role/admin";
    }
    //修改当前角色的权限
    @RequestMapping("/update")
    public  String update(Integer id,Model model){
        //根据当前角色id获取角色信息和该角色所拥有的及未拥有的所有权限
        RoleVo roleVo=roleService.getRoleById(id);
        //将获取到的角色信息及先关权限展示到页面去
        model.addAttribute("rolevo",roleVo);

        //根据当前角色id获取该角色的所有权限及未拥有的所有权限
       //List<PermissionVo> permissionVoList=permissionService.getAllPermissionByRoleId(id);
        return "/role/update";
    }
    //保存当前修改的角色及权限信息
    @RequestMapping("/save")
    public  String save(RoleVo roleVo){
        //System.out.println(roleVo.getRole_id());
       // System.out.println(roleVo.getRole_name());
       // System.out.println(Arrays.toString(roleVo.getPermissionids()));
        //先根据中间表将原来的permission删除
        //再根据获取的permissionids添加新的角色权限
        return "redirect:/role/update?id="+roleVo.getRole_id();
    }
}
