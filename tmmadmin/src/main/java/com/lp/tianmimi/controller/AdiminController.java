package com.lp.tianmimi.controller;

import com.lp.tianmimi.pojo.Admin;
import com.lp.tianmimi.pojo.AdminVo;
import com.lp.tianmimi.pojo.Role;
import com.lp.tianmimi.pojo.RoleVo;
import com.lp.tianmimi.service.AdminService;
import com.lp.tianmimi.service.RoleService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.SpringContextUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdiminController {
    //显示登录的页面
    //管理员的服务层对象
    @Autowired
    private AdminService as;
    //角色的服务层对象
    @Autowired
    private RoleService rs;

    @RequestMapping(value = "/login")
    public String login() {
        return null;
    }

    //进行登录的操作，获取登录用户auth
    @RequestMapping("/dologin")
    public String dologin(String username, String password) {
        return null;
    }

    @RequestMapping("/admin")
    //进入员工管理页面
    public String staffManage(String admin_name, String admin_nickname, Model model, HttpSession session) {
        //从数据库中获取所有管理员列表
        List<Admin> list = as.getAllAdmin(admin_name, admin_nickname);
        //用于页面显示
        model.addAttribute("adminList", list);
        //用于下载用户信息
        session.setAttribute("adminList", list);
        //搜素回显
        model.addAttribute("search_admin_name", admin_name);
        model.addAttribute("search_admin_nickname", admin_nickname);
        return "/admin/admin";
    }

    //显示添加用户的页面
    @RequestMapping("/add")
    public String add(Model model) {
        //获取所有的角色列表
        List<Role> roleList = rs.getAllRoles();
        model.addAttribute("roleList", roleList);
        return null;
    }

    //管理员确认添加员工
    @RequestMapping("/save")
    public String save(AdminVo adminVo) {
        //System.out.println(adminVo);
        //添加用户时候设置初始密码
        adminVo.setAdmin_pass(new BCryptPasswordEncoder().encode("123456"));
        //将用户信息存入admin表单
        as.insertAdmin(adminVo);
        //System.out.println(adminVo);
        //如果没有选择角色的id也可以进行插入用户,此时在中间表是不需要插入相对应的角色
        if (null != adminVo.getRoleids()) {
            //如果adminvo的角色信息不为空，进行管理员角色的插入工作
            as.insertRole(adminVo.getAdmin_id(), adminVo.getRoleids());
        }

        //重定向到员工列表页面
        return "redirect:/admin/admin";
    }

    //管理员删除员工，并不是将员工信息从数据库中删除，而是改变其状态
    @RequestMapping("/delete")
    public String delete(Integer id) {
        as.deleteAdmin(id);
        //删除信息后从定向到员工列表页面
        return "redirect:/admin/admin";
    }

    //显示员工信息修改页面
    @RequestMapping("/update")
    public String update(Integer id, Model model) {
        //根据admin_id获取管理员信息
        AdminVo vo = as.getAdminById(id);

        model.addAttribute("adminvo", vo);

        return null;
    }

    @RequestMapping("/alter")
    public String adminAlter(AdminVo adminVo) {
        //System.out.println(adminVo);
        as.updateAdmin(adminVo);
        return "redirect:/admin/update?id=" + adminVo.getAdmin_id();
    }

    @RequestMapping("/download")
    public void download(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException {
        //如果d盘存在对应文件，先删除
        File file =new File("d:\\demoadmin.xls");
        if(file.exists()){
            file.delete();
        }
        //创建工作簿
        HSSFWorkbook workBook = new HSSFWorkbook();
        //创建工作表 工作表（sheet）的名字叫hello
        HSSFSheet sheet = workBook.createSheet("hello");
      //----------------------------------------------------
      //创建行,第1行
        HSSFRow row0 = sheet.createRow(0);
       //创建列，1行第1列，设置第1行1列的值
        HSSFCell cell0000 = row0.createCell(0);
        cell0000.setCellValue("ID");
        //创建列，1行第2列，设置第1行2列的值
        HSSFCell cell0001 = row0.createCell(1);
        cell0001.setCellValue("用户名");
        //创建列，1行第3列，设置第1行2列的值
        HSSFCell cell0002 = row0.createCell(2);
        cell0002.setCellValue("昵称");
//第一行结束---------------------------------------------
       //从session中取值
        int i=1;
        List<Admin> list= (List<Admin>) session.getAttribute("adminList");
        for (Admin admin:list
             ) {
            HSSFRow row1=sheet.createRow(i);
            HSSFCell cell0100=row1.createCell(0);
            cell0100.setCellValue(admin.getAdmin_id());
            HSSFCell cell0101=row1.createCell(1);
            cell0101.setCellValue(admin.getAdmin_name());
            HSSFCell cell0102=row1.createCell(2);
            cell0102.setCellValue(admin.getAdmin_nickname());
            i++;
        }
        //生成文件
        workBook.write(new FileOutputStream(new File("d:\\demoadmin.xls")));
       //最后记得关闭工作簿
        workBook.close();
        //执行下载操作
        String fileName="demoadmin.xls";
//服务器加载用户要下载的文件数据。
        File downfile = new File("d:\\",fileName);
//通知浏览器以下载的方式请求资源
//设置文件媒体格式
        response.setContentType(request.getServletContext().getMimeType(fileName));
//解决文件下载的中文乱码问题
//判断浏览器的类型
        String header = request.getHeader("User-Agent");
        if(header.contains("Firefox")){
//判断如果是火狐浏览器，使用base64编码
            BASE64Encoder base64Encoder = new BASE64Encoder();
            fileName = "=?utf-8?B?" + base64Encoder.encode(fileName.getBytes("utf-8")) + "?=";
        }else{
//谷歌浏览器及其他浏览器处理
            fileName = URLEncoder.encode(fileName,"utf-8");
        }
//设置要被下载的文件的文件名
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
//使用IO技术，将数据发送（使用response对象发送数据）
//获取输入流，读取文件数据
        FileInputStream in = new FileInputStream(file);
//获取输出流，写出文件数据
        ServletOutputStream out = response.getOutputStream();
//定义一个缓冲区
        byte[] buf = new byte[1024];
        while(in.read(buf) != -1){
            out.write(buf);
        }
        in.close();


    }
}

