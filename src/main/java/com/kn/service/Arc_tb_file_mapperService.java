package com.kn.service;

import com.kn.bean.Arc_tb_file_mapper;

import java.util.List;

public interface Arc_tb_file_mapperService {

    Arc_tb_file_mapper getArc_tb_file_mapperById(Integer id);

    List<Arc_tb_file_mapper> getArc_tb_file_mapperById1(String id);
}
