package com.kn.service.impl;

import com.kn.bean.AuthTbRole;
import com.kn.mapper.AuthTbRoleMapper;
import com.kn.service.AuthTbRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthTbRoleServiceImpl implements AuthTbRoleService {

    //自动注入mapper层
    @Autowired
    private AuthTbRoleMapper authTbRoleMapper;

    //获取用户所有角色信息
    @Override
    public List<AuthTbRole> getAllAuthTbRole() {
        return authTbRoleMapper.getAllAuthTbRole();
    }

}
