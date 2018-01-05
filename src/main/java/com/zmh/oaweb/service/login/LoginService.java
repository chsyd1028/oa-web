package com.zmh.oaweb.service.login;

import com.zmh.oaweb.dto.ReturnDto;
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
 * 2018/1/3
 */
@Service
public class LoginService {

    private Log logger = LogFactory.getLog(LoginService.class);

    @Autowired
    MemberMapper memberMapper;

    public ReturnDto loginCheck(String username, String password){
        Member member = new Member();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andUsernameEqualTo(username);
        logger.info(memberExample.toString());

        List<Member> list = memberMapper.selectByExample(memberExample);

        if (list.size() == 1 && list.get(0).getPassword().equals(password)){
            return ReturnDto.buildSuccessReturnDto(list.get(0));
        }else if (list.size() == 1 && !list.get(0).getPassword().equals(password)){
            return ReturnDto.buildFailedReturnDto("登陆失败，请检查密码");
        }else if (list.size() == 0){
            return ReturnDto.buildFailedReturnDto("登陆失败，用户名不存在");
        }else {
            return ReturnDto.buildFailReturnDto("登陆失败");
        }
    }
}
