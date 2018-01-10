package com.zmh.oaweb.service;

import com.zmh.oaweb.mapper.AdminMapper;
import com.zmh.oaweb.model.Admin;
import com.zmh.oaweb.model.AdminExample;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ChengShanyunduo
 * 2018/1/10
 */
@Service
public class AdminService {

    private static final Log logger = LogFactory.getLog(AdminService.class);

    @Autowired
    AdminMapper adminMapper;

    public List<Admin> adminList (){
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andIsDelEqualTo(false);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        return admins;
    }

    public Admin queryAdminByUsername(String userName){
        Admin admin = adminMapper.queryAdminByUsername(userName);
        return admin;
    }
}
