package com.zmh.oaweb.controller.login;

import com.zmh.oaweb.dto.ReturnDto;
import com.zmh.oaweb.model.Member;
import com.zmh.oaweb.service.login.LoginService;
import com.zmh.oaweb.util.MD5Util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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

    @RequestMapping(value = "/login/check")
    public String login(@Param("username") String username, @Param("password") String password){
        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
            try {
                currentUser.login(token);
            }catch (AuthenticationException ae){
                logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>----------登陆失败:" + ae.getMessage());
            }
        }

        return "redirect:/member/member_list";
    }


}
