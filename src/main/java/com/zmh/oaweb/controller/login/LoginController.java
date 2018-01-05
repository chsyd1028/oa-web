package com.zmh.oaweb.controller.login;

import com.zmh.oaweb.dto.ReturnDto;
import com.zmh.oaweb.model.Member;
import com.zmh.oaweb.service.login.LoginService;
import com.zmh.oaweb.util.MD5Util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

/**
 * Created by ChengShanyunduo
 * 2018/1/2
 */
@Controller
@RequestMapping(value = "/zmh")
public class LoginController {

    private Log logger = LogFactory.getLog(LoginController.class);

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login")
    public ModelAndView loginPage(){
        ModelAndView mv = new ModelAndView("/view/login/index");
        return mv;
    }

    @RequestMapping(value = "/check")
    public ReturnDto loginCheck(@Param("username") String username, @Param("password") String password){
        String pwd = MD5Util.string2MD5(MD5Util.string2MD5(password));

        return loginService.loginCheck(username, password);
    }


}
