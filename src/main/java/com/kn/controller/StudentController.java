package com.kn.controller;

import com.kn.bean.Student;
import com.kn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {

    //引入service层
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/getAllStudent")
    @ResponseBody
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @RequestMapping(value = "/insertStudent")
    public Integer insertStudent(Student student){
//        Student student1 = new Student();
        student.setStudent_id(11);
//        student1.setName("abcd");
//        student1.setEmail("abcd@163.com");
        student.setLocked(0);
        student.setDelete(0);
        student.setSex(1);
        return studentService.insertStudent(student);
    }

}
