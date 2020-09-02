package com.kn.mapper;

import com.kn.bean.AuthTbRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AuthTbRoleMapper {

    @Select("select * from auth_tb_role")
    public List<AuthTbRole> getAllAuthTbRole();

}
