package com.kn.controller;

import com.kn.bean.Arc_tb_file_mapper;
import com.kn.service.Arc_tb_file_mapperService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/arc_tb_file_mapper")
public class Arc_tb_file_mapperController {

    @Autowired
    private Arc_tb_file_mapperService arc_tb_file_mapperService;

    @RequestMapping("/get")
    public Arc_tb_file_mapper getArc_tb_file_mapperById(@Param("id") Integer id) {
        System.out.println("id:  " + id);
        return arc_tb_file_mapperService.getArc_tb_file_mapperById(id);
    }

    @RequestMapping("/get1")
    public List<Arc_tb_file_mapper> getArc_tb_file_mapperById1() {
        String i = "22 or 1 = 1";//sql注入
        return arc_tb_file_mapperService.getArc_tb_file_mapperById1(i);
    }

}
