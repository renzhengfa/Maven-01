package com.kn.mapper;

import com.kn.bean.Arc_tb_file_mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface Arc_tb_file_mapperMapper {

    // 根据id查询  #{id}防止sql注入,最后将会把#{}里面的东西用双引号括起来
    // 例: select * from user where uid = #{1 or 1 = 1} ==>> select * from user where uid = "1 or 1 = 1";
    // 例: select * from user where uid = ${1 or 1 = 1} ==>> select * from user where uid = 1 or 1 = 1;
    @Select("select * from arc_tb_file_mapper where id = #{id}")
    public Arc_tb_file_mapper getArc_tb_file_mapperById(@Param("id") Integer id);

    // $不能防止sql注入,最后将会解析成为sql语句执行
    //       select * from arc_tb_file_mapper where id = 1
    @Select("select * from arc_tb_file_mapper where id = ${id}")
    public List<Arc_tb_file_mapper> getArc_tb_file_mapperById1(String id);

}
