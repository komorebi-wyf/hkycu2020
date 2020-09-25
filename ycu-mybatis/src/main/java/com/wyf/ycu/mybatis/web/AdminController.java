package com.wyf.ycu.mybatis.web;

import com.wyf.ycu.mybatis.model.UmsAdmin;
import com.wyf.ycu.mybatis.result.Result;
import com.wyf.ycu.mybatis.service.AdminService;
import com.wyf.ycu.mybatis.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "Hello, 欢迎！！！";
    }

    @PostMapping("/login")
    @ResponseBody
    public Result<UmsAdmin> login(Model model, String username, String password) {
        UmsAdmin admin = new UmsAdmin();
        admin.setUsername(username);
        admin.setPassword(password);

        Result<UmsAdmin> login = this.adminService.login(admin);

        return login;
    }

    @RequestMapping("/register")
    @ResponseBody
    public String register(String username,String password){
        ModelAndView mav = new ModelAndView();
        password = MD5Util.inputPassToDbPass(password,MD5Util.salt);
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setUsername(username);
        umsAdmin.setPassword(password);
        umsAdmin.setSalt(MD5Util.salt);

        int reg = this.adminService.register(umsAdmin);
        if(reg == 0){
            mav.addObject("msg","注册失败");
        }else {
            mav.addObject("umsAdmin","注册成功");
        }

        return mav.toString();
    }
}

