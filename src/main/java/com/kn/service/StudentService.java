package com.kn.service;

import com.kn.bean.Student;

import java.util.List;

public interface StudentService {

    //查询所有学生信息
    List<Student> getAllStudent();

    //插入学生信息
    Integer insertStudent(Student student);

}
