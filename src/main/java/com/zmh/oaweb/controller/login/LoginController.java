package com.zmh.oaweb.controller.login;

import com.zmh.oaweb.model.Admin;
import com.zmh.oaweb.service.AdminService;
import com.zmh.oaweb.service.login.LoginService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * Created by ChengShanyunduo
 * 2018/1/2
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {

    private Log logger = LogFactory.getLog(LoginController.class);

    @Autowired
    LoginService loginService;

    @Autowired
    AdminService adminService;

    /**
     * 登陆页面
     * @return
     */
    @RequestMapping(value = "/login")
    public ModelAndView loginPage1(){
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    /**
     * 没有权限页面
     * @return
     */
    @RequestMapping(value = "/unauthorized")
    public ModelAndView unauthorizedPage(){
        ModelAndView mv = new ModelAndView("common/unauthorized");
        return mv;
    }

    @RequestMapping(value = "/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("personal_info");
        return mv;
    }

    @RequestMapping(value = "/login/check")
    public ModelAndView login(@Param("username") String username, @Param("password") String password, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("redirect:/login");

        if (Objects.equals("", username) || Objects.isNull(username)){
            request.getSession().setAttribute("message", "请输入用户名");
            return mav;
        }

        if (Objects.equals("", password) || Objects.isNull(password)){
            request.getSession().setAttribute("message", "请输入密码");
            return mav;
        }

        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
            try {
                currentUser.login(token);
            }catch (IncorrectCredentialsException ae){
                logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>----------登陆失败:密码错误" + ae.getMessage());
                request.getSession().setAttribute("message", "密码错误");
                return mav;
            }
            catch (AuthenticationException ae){
                logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>----------登陆失败:" + ae.getMessage());

                request.getSession().setAttribute("message", ae.getMessage());
                return mav;
            }
        }

        Admin admin = adminService.queryAdminByUsername(username);
        request.getSession().setAttribute("adminId", admin.getId());
        request.getSession().setAttribute("departmentId", admin.getDepartmentId());
        request.getSession().setAttribute("jobId", admin.getJobId());

        mav = new ModelAndView("redirect:/index");
        return mav;

    }




}
