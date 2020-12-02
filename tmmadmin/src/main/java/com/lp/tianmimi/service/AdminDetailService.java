package com.lp.tianmimi.service;

import com.lp.tianmimi.dao.AdminDao;
import com.lp.tianmimi.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 做用户登录验证所用
 */
@Service
public class AdminDetailService implements UserDetailsService {
    @Autowired
    private AdminDao ad;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Admin admin = ad.getAdminByName(s);
        if (admin == null) {
            System.out.println("进来了嘛");
            throw new UsernameNotFoundException("账户名称填写错误");
        }
       // System.out.println(admin);
        return admin;
    }
}
