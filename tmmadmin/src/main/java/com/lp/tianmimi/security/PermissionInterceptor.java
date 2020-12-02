package com.lp.tianmimi.security;


import com.lp.tianmimi.dao.RoleDao;
import com.lp.tianmimi.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class PermissionInterceptor implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private RoleDao rd;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<Role> roleList = rd.getRoleListByOperateUrl(requestUrl);

        if (!roleList.isEmpty() && roleList.size() > 0) {
// 定义 String类型的数组 存放 授权列表
            String[] grantArray = new String[roleList.size()];
         //   System.out.println("********** 开始授权 **********");
// 循环 拥有当前URL访问权限的每一个角色
            for (int i = 0; i <= roleList.size() - 1; i++) {
// 将 当前循环到的角色的角色名称 存放 授权名称数组中
                grantArray[i] = roleList.get(i).getRole_name();
           //     System.out.println("** 授权角色：" + roleList.get(i).getRole_name());
            }
            //System.out.println("********** 授权完毕 **********");
// 生成授权列表 返回
            return SecurityConfig.createList(grantArray);
        } else {
// 避免返回null（任何角色都能访问）
            return SecurityConfig.createList("ROLE_LOGIN");
        }
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
