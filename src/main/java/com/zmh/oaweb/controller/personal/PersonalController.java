package com.zmh.oaweb.controller.personal;

import com.zmh.oaweb.dto.ReturnDto;
import com.zmh.oaweb.mapper.AdminMapper;
import com.zmh.oaweb.mapper.AdminextMapper;
import com.zmh.oaweb.model.Adminext;
import com.zmh.oaweb.model.Department;
import com.zmh.oaweb.service.personal.PersonalService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * Created by ChengShanyunduo
 * 2018/1/16
 */
@Controller
@RequestMapping(value = "/personal")
public class PersonalController {

    @Autowired
    PersonalService personalService;

    @RequestMapping("/info")
    @ResponseBody
    public ReturnDto queryAdminById(HttpServletRequest request){
        Integer adminId = (Integer) request.getSession().getAttribute("adminId");
        Adminext adminext = personalService.queryAdminById(adminId);

        return ReturnDto.buildSuccessReturnDto(adminext);
    }

    @RequestMapping(value = "/departmentInfo")
    @ResponseBody
    public ReturnDto queryAdminDepartment(HttpServletRequest request){
        Integer departmentId = (Integer) request.getSession().getAttribute("departmentId");
        Integer jobId = (Integer) request.getSession().getAttribute("jobId");

        Department department = personalService.queryAdminDepartment(departmentId, jobId);

        return ReturnDto.buildSuccessReturnDto(department);
    }
}
