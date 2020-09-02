package com.kn.service.impl;

import com.kn.bean.Arc_tb_file_mapper;
import com.kn.mapper.Arc_tb_file_mapperMapper;
import com.kn.service.Arc_tb_file_mapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Arc_tb_file_mapperServiceImpl implements Arc_tb_file_mapperService {

    @Autowired
    private Arc_tb_file_mapperMapper arc_tb_file_mapperMapper;

    @Override
    public Arc_tb_file_mapper getArc_tb_file_mapperById(Integer id) {
        return arc_tb_file_mapperMapper.getArc_tb_file_mapperById(id);
    }

    @Override
    public List<Arc_tb_file_mapper> getArc_tb_file_mapperById1(String id) {
        return arc_tb_file_mapperMapper.getArc_tb_file_mapperById1(id);
    }

}
