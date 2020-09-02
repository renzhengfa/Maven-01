package com.kn.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class AuthTbRole implements Serializable {

    /*
    * CREATE TABLE `auth_tb_role` (
      `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
      `role_name` varchar(12) NOT NULL COMMENT '角色名称',
      `role_code` varchar(12) NOT NULL DEFAULT '0' COMMENT '角色编码',
      `is_default` tinyint(1) NOT NULL COMMENT '是否默认',
      `create_time` datetime NOT NULL COMMENT '创建时间',
      `update_time` datetime NOT NULL COMMENT '更新时间',
      `disabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT '禁用',
      PRIMARY KEY (`id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色表';
    * */

    private Integer id;
    private String role_name;
    private String role_code;
    private Integer is_default;
    private String create_time;
    private String update_time;
    private Integer disabled;

    @Override
    public String toString() {
        return "AuthTbRole{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                ", role_code='" + role_code + '\'' +
                ", is_default=" + is_default +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", disabled=" + disabled +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_code() {
        return role_code;
    }

    public void setRole_code(String role_code) {
        this.role_code = role_code;
    }

    public Integer getIs_default() {
        return is_default;
    }

    public void setIs_default(Integer is_default) {
        this.is_default = is_default;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }
}
