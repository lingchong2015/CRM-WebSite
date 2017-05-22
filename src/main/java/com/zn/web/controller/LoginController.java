package com.zn.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by wutingting on 2017/4/4.
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    private Logger log = Logger.getLogger(LoginController.class);
//    @Resource
//    private CustomerService customerService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request, Model model){
        log.info("跳转到首页");
        return "index";
    }
}
