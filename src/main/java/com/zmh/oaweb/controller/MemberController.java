package com.zmh.oaweb.controller;

import com.zmh.oaweb.dto.ReturnDto;
import com.zmh.oaweb.service.MemberService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ChengShanyunduo
 * 2018/1/2
 */
@Controller
@RequestMapping(value = "/member")
public class MemberController {

    private Log logger = LogFactory.getLog(MemberController.class);

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/memberList")
    @ResponseBody
    public ReturnDto queryList(){
        return ReturnDto.buildSuccessReturnDto(memberService.queryMember());

    }

    @RequestMapping(value = "/member_list")
    public String memberList(){
        return "/member_list";
    }
}
