package com.cheneyclient.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cheneyclient.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Integer insert(Teacher teacher);

    Integer delete(Integer teacherId);

    Integer update(Teacher teacher);

    Teacher selectById(Integer teacherId);

    List<Teacher> getAll();

//    对表中所有信息进行分页, 传入参数为要查询的页数
    Page<Teacher> getAllTeacherPage(Integer pageNumber);

    //    按条件(性别)进行分页
    Page<Teacher> getAllTeacherByTeacherSexPage(Integer pageNumber, String teacherSex);
}
