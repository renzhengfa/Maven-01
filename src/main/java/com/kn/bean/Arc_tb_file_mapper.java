package com.kn.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Component
public class Arc_tb_file_mapper implements Serializable {
    private Integer id;
    private BigInteger fk_file_id;
    private String rfid;
    private String bar_code;
    private Integer fk_file_type_id;
    private String fk_file_name;
    private Integer is_box;
    private Integer deleted;
    private String state;
    private BigInteger fk_location_id;
    private String file_num;
    private Date create_time;

    @Override
    public String toString() {
        return "Arc_tb_file_mapper{" +
                "id=" + id +
                ", fk_file_id=" + fk_file_id +
                ", rfid='" + rfid + '\'' +
                ", bar_code='" + bar_code + '\'' +
                ", fk_file_type_id=" + fk_file_type_id +
                ", fk_file_name='" + fk_file_name + '\'' +
                ", is_box=" + is_box +
                ", deleted=" + deleted +
                ", state='" + state + '\'' +
                ", fk_location_id=" + fk_location_id +
                ", file_num='" + file_num + '\'' +
                ", create_time=" + create_time +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getFk_file_id() {
        return fk_file_id;
    }

    public void setFk_file_id(BigInteger fk_file_id) {
        this.fk_file_id = fk_file_id;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getBar_code() {
        return bar_code;
    }

    public void setBar_code(String bar_code) {
        this.bar_code = bar_code;
    }

    public Integer getFk_file_type_id() {
        return fk_file_type_id;
    }

    public void setFk_file_type_id(Integer fk_file_type_id) {
        this.fk_file_type_id = fk_file_type_id;
    }

    public String getFk_file_name() {
        return fk_file_name;
    }

    public void setFk_file_name(String fk_file_name) {
        this.fk_file_name = fk_file_name;
    }

    public Integer getIs_box() {
        return is_box;
    }

    public void setIs_box(Integer is_box) {
        this.is_box = is_box;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigInteger getFk_location_id() {
        return fk_location_id;
    }

    public void setFk_location_id(BigInteger fk_location_id) {
        this.fk_location_id = fk_location_id;
    }

    public String getFile_num() {
        return file_num;
    }

    public void setFile_num(String file_num) {
        this.file_num = file_num;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
/*CREATE TABLE `arc_tb_file_mapper` (
            `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
            `fk_file_id` bigint(17) NOT NULL COMMENT '档案id',
            `rfid` varchar(24) COLLATE utf8_bin DEFAULT NULL COMMENT '电子标签',
            `bar_code` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '条码',
            `fk_file_type_id` int(11) DEFAULT NULL COMMENT '档案类别id',
            `fk_file_name` text COLLATE utf8_bin COMMENT '题名',
            `is_box` tinyint(1) DEFAULT NULL COMMENT '是否是档案盒',
            `deleted` tinyint(1) DEFAULT '0' COMMENT '删除标志',
            `state` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '档案状态',
            `fk_location_id` bigint(11) DEFAULT NULL COMMENT '位置id',
            `file_num` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '档号',
            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `唯一` (`fk_file_id`) USING BTREE COMMENT '档案ID唯一'
            ) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='档案映射表';*/

}
