package com.kn.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Component
public class Arc_tb_file_1 implements Serializable {

    private BigInteger id;
    private String file_num;
    private String file_name;
    private String fk_secret_id;
    private String fk_secret_name;
    private Integer fonds_id;
    private String bar_code;
    private String rfid;
    private Integer fk_type_id;
    private String fk_type_name;
    /*CREATE TABLE `arc_tb_file_1` (
    `id` BIGINT ( 17 ) NOT NULL,
    `file_num` VARCHAR ( 30 ) COLLATE utf8_bin DEFAULT '0' COMMENT '档号',
    `file_name` text COLLATE utf8_bin COMMENT '题名',
    `fk_secret_id` INT ( 11 ) DEFAULT '0' COMMENT '密级编号',
    `fk_secret_name` VARCHAR ( 6 ) COLLATE utf8_bin DEFAULT '' COMMENT '密级名称',
    `fonds_id` INT ( 8 ) DEFAULT '0' COMMENT '全宗号',
    `bar_code` VARCHAR ( 16 ) COLLATE utf8_bin DEFAULT '' COMMENT '条码',
    `rfid` VARCHAR ( 24 ) COLLATE utf8_bin DEFAULT '' COMMENT 'RFID电子标签',
    `fk_type_id` INT ( 11 ) DEFAULT '0' COMMENT '类型编号',
    `fk_type_name` VARCHAR ( 50 ) COLLATE utf8_bin DEFAULT NULL COMMENT '档案类别名称',
    */
    private BigInteger box_id;
    private String state;
    private BigInteger fk_location_id;
    private Date create_time;
    private Date update_time;
    private Integer create_user_id;
    private String create_user_name;
    private String author;
    private String record_organize;
    private Integer record_organize_id;
    /*
    `box_id` BIGINT ( 17 ) DEFAULT '0' COMMENT '盒号',
    `state` VARCHAR ( 5 ) COLLATE utf8_bin DEFAULT '0' COMMENT '当前状态\r\ntbt(待取)；       lend（借出);         nots（未上架);\r\nrf（在架)；       loss(遗失)；         trans（移交);\r\ndest（销毁)；   tba（待归档);       ita(归档中)；\r\nhand(移交中)； destr(销毁中)',
    `fk_location_id` BIGINT ( 11 ) DEFAULT '0' COMMENT '位置',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `create_user_id` INT ( 11 ) DEFAULT '0' COMMENT '创建人',
    `create_user_name` VARCHAR ( 8 ) COLLATE utf8_bin DEFAULT '' COMMENT '创建人名称',
    `author` VARCHAR ( 8 ) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '著录人',
    `record_organize` VARCHAR ( 255 ) COLLATE utf8_bin DEFAULT '' COMMENT '著录机构名称',
    `record_organize_id` INT ( 11 ) DEFAULT '0' COMMENT '著录机构id',
    */
    private Integer allow_borrow;
    private Integer page_num;
    private Integer integrity;
    private Integer fk_source_id;
    private Integer is_box;
    private String fk_attachment_ids;
    private String detail;
    private String summary;
    /*
    `allow_borrow` TINYINT ( 1 ) DEFAULT '1' COMMENT '允许借阅',
    `page_num` INT ( 5 ) DEFAULT NULL COMMENT '页数',
    `integrity` INT ( 3 ) DEFAULT NULL COMMENT '完整度',
    `fk_source_id` INT ( 2 ) DEFAULT NULL COMMENT '来源，参考数据字典',
    `is_box` TINYINT ( 1 ) DEFAULT '0' COMMENT '是否为档案盒',
    `fk_attachment_ids` VARCHAR ( 255 ) COLLATE utf8_bin DEFAULT NULL COMMENT '附件表id,逗号分隔',
    `detail` json DEFAULT NULL COMMENT '详情',
    `summary` VARCHAR ( 255 ) COLLATE utf8_bin DEFAULT NULL COMMENT '摘要',
    PRIMARY KEY ( `id` ) USING BTREE
    ) ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC COMMENT = '档案信息表,该表只存储未归档的信息';*/

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getFile_num() {
        return file_num;
    }

    public void setFile_num(String file_num) {
        this.file_num = file_num;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFk_secret_id() {
        return fk_secret_id;
    }

    public void setFk_secret_id(String fk_secret_id) {
        this.fk_secret_id = fk_secret_id;
    }

    public String getFk_secret_name() {
        return fk_secret_name;
    }

    public void setFk_secret_name(String fk_secret_name) {
        this.fk_secret_name = fk_secret_name;
    }

    public Integer getFonds_id() {
        return fonds_id;
    }

    public void setFonds_id(Integer fonds_id) {
        this.fonds_id = fonds_id;
    }

    public String getBar_code() {
        return bar_code;
    }

    public void setBar_code(String bar_code) {
        this.bar_code = bar_code;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public Integer getFk_type_id() {
        return fk_type_id;
    }

    public void setFk_type_id(Integer fk_type_id) {
        this.fk_type_id = fk_type_id;
    }

    public String getFk_type_name() {
        return fk_type_name;
    }

    public void setFk_type_name(String fk_type_name) {
        this.fk_type_name = fk_type_name;
    }

    public BigInteger getBox_id() {
        return box_id;
    }

    public void setBox_id(BigInteger box_id) {
        this.box_id = box_id;
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

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Integer getCreate_user_id() {
        return create_user_id;
    }

    public void setCreate_user_id(Integer create_user_id) {
        this.create_user_id = create_user_id;
    }

    public String getCreate_user_name() {
        return create_user_name;
    }

    public void setCreate_user_name(String create_user_name) {
        this.create_user_name = create_user_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRecord_organize() {
        return record_organize;
    }

    public void setRecord_organize(String record_organize) {
        this.record_organize = record_organize;
    }

    public Integer getRecord_organize_id() {
        return record_organize_id;
    }

    public void setRecord_organize_id(Integer record_organize_id) {
        this.record_organize_id = record_organize_id;
    }

    public Integer getAllow_borrow() {
        return allow_borrow;
    }

    public void setAllow_borrow(Integer allow_borrow) {
        this.allow_borrow = allow_borrow;
    }

    public Integer getPage_num() {
        return page_num;
    }

    public void setPage_num(Integer page_num) {
        this.page_num = page_num;
    }

    public Integer getIntegrity() {
        return integrity;
    }

    public void setIntegrity(Integer integrity) {
        this.integrity = integrity;
    }

    public Integer getFk_source_id() {
        return fk_source_id;
    }

    public void setFk_source_id(Integer fk_source_id) {
        this.fk_source_id = fk_source_id;
    }

    public Integer getIs_box() {
        return is_box;
    }

    public void setIs_box(Integer is_box) {
        this.is_box = is_box;
    }

    public String getFk_attachment_ids() {
        return fk_attachment_ids;
    }

    public void setFk_attachment_ids(String fk_attachment_ids) {
        this.fk_attachment_ids = fk_attachment_ids;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Arc_tb_file_1{" +
                "id=" + id +
                ", file_num='" + file_num + '\'' +
                ", file_name='" + file_name + '\'' +
                ", fk_secret_id='" + fk_secret_id + '\'' +
                ", fk_secret_name='" + fk_secret_name + '\'' +
                ", fonds_id=" + fonds_id +
                ", bar_code='" + bar_code + '\'' +
                ", rfid='" + rfid + '\'' +
                ", fk_type_id=" + fk_type_id +
                ", fk_type_name='" + fk_type_name + '\'' +
                ", box_id=" + box_id +
                ", state='" + state + '\'' +
                ", fk_location_id=" + fk_location_id +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", create_user_id=" + create_user_id +
                ", create_user_name='" + create_user_name + '\'' +
                ", author='" + author + '\'' +
                ", record_organize='" + record_organize + '\'' +
                ", record_organize_id=" + record_organize_id +
                ", allow_borrow=" + allow_borrow +
                ", page_num=" + page_num +
                ", integrity=" + integrity +
                ", fk_source_id=" + fk_source_id +
                ", is_box=" + is_box +
                ", fk_attachment_ids='" + fk_attachment_ids + '\'' +
                ", detail='" + detail + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
