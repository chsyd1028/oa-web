package com.zmh.oaweb.service.personal;

import com.zmh.oaweb.mapper.AdminextMapper;
import com.zmh.oaweb.mapper.DepartmentMapper;
import com.zmh.oaweb.model.Adminext;
import com.zmh.oaweb.model.Department;
import com.zmh.oaweb.model.DepartmentExample;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ChengShanyunduo
 * 2018/1/16
 */

@Service
public class PersonalService {

    @Autowired
    AdminextMapper adminextMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    public Adminext queryAdminById(Integer adminId){
        Adminext adminext = adminextMapper.selectByPrimaryKey(adminId);
        return adminext;
    }

    public Department queryAdminDepartment(Integer departmentId, Integer jobId){
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andDepartmentIdEqualTo(departmentId).andJobIdEqualTo(jobId);
        Department department = departmentMapper.selectByExample(departmentExample).get(0);

        return department;
    }


}
