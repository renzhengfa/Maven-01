package com.kn.mapper;

import com.kn.bean.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StudentMapper {

    //查询所有学生信息
    @Select("select * from student")
    List<Student> getAllStudent();

    //插入学生信息
    @Insert(value = "insert into student(student_id, name, phone, email, sex, locked, gmt_created, gmt_modified, delete) values (#{student_id}, #{name}, #{phone}, #{email}, #{sex}, #{locked}, #{gmt_created}, #{gmt_modified}, #{delete})"
    )
    Integer insertStudent(Student student);

}
    