package com.kn.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class Student implements Serializable {

    /**
     * CREATE TABLE `student` (
     *   `student_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
     *   `name` varchar(20) DEFAULT NULL COMMENT '姓名',
     *   `phone` varchar(20) DEFAULT NULL COMMENT '电话',
     *   `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
     *   `sex` tinyint(4) DEFAULT NULL COMMENT '性别',
     *   `locked` tinyint(4) DEFAULT NULL COMMENT '状态(0:正常,1:锁定)',
     *   `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '存入数据库的时间',
     *   `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改的时间',
     *   `delete` int(11) DEFAULT NULL,
     *   PRIMARY KEY (`student_id`)
     * ) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='学生表';
     */

    private Integer student_id;
    private String name;
    private String phone;
    private String email;
    private Integer sex;
    private Integer locked;
    private Date gmt_created;
    private Date gmt_modified;
    private Integer delete;

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", locked=" + locked +
                ", gmt_created=" + gmt_created +
                ", gmt_modified=" + gmt_modified +
                ", delete=" + delete +
                '}';
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public Date getGmt_created() {
        return gmt_created;
    }

    public void setGmt_created(Date gmt_created) {
        this.gmt_created = gmt_created;
    }

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }
}
