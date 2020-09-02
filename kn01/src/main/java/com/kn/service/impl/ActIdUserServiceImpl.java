package com.kn.service.impl;

import com.kn.bean.Act_id_user;
import com.kn.mapper.Act_id_userMapper;
import com.kn.service.ActIdUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Act_id_userService服务层实现类
 */
@Service
public class ActIdUserServiceImpl implements ActIdUserService {

    //自动注入mapper层
    @Autowired
    private Act_id_userMapper act_id_userMapper;

    //根据用户名和密码查询用户信息
    @Override
    public Act_id_user queryAct_id_userByUsernameAndPassword(String username, String password) {
        return act_id_userMapper.queryAct_id_userByUsernameAndPassword(username, password);
    }

}
