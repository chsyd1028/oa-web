package com.zmh.oaweb.service;

import com.zmh.oaweb.mapper.MemberMapper;
import com.zmh.oaweb.model.Member;
import com.zmh.oaweb.model.MemberExample;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ChengShanyunduo
 * 2018/1/2
 */
@Service
public class MemberService {

    private Log logger = LogFactory.getLog(MemberService.class);

    @Autowired
    MemberMapper memberMapper;

    public List<Member> queryMember(){
        List<Member> members = memberMapper.selectByExample(new MemberExample());
        return members;
    }
}
