package com.kn.controller;

import com.kn.service.AuthTbRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 用户角色控制层类
 *
 */

@Controller
public class AuthTbRoleController {

    //自动注入service层
    @Autowired
    private AuthTbRoleService authTbRoleService;

    @RequestMapping("/getAllAuthTbRole")
    public String getAllAuthTbRole(Map<String, Object> map){
        map.put("AuthTbRoles",authTbRoleService.getAllAuthTbRole());
        return "role";
    }

}
