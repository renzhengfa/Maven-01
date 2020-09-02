package com.kn.mapper;

import com.kn.bean.Act_id_user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * 用户mapper文件
 */

@Mapper
@Component
public interface Act_id_userMapper {

    //根据用户名和密码查询用户信息
    @Select("select * from act_id_user where FIRST_ = #{username} and PWD_ = #{password}")
    public Act_id_user queryAct_id_userByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
