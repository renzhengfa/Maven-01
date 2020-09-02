package com.kn.service.impl;

import com.kn.bean.Student;
import com.kn.mapper.StudentMapper;
import com.kn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    //引入mapper层
    @Autowired
    private StudentMapper studentMapper;

    //查询所有学生信息
    @Override
    public List<Student> getAllStudent() {
        return studentMapper.getAllStudent();
    }

    //插入学生信息
    @Override
    public Integer insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }
}
