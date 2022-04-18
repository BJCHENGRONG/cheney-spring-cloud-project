package com.cheneyclient.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cheneyclient.dao.TeacherDao;
import com.cheneyclient.entity.Teacher;
import com.cheneyclient.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImp implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    public Integer insert(Teacher teacher) {
        return teacherDao.insert(teacher);
    }

    public Integer delete(Integer teacherId) {
        return teacherDao.deleteById(teacherId);
    }

    public Integer update(Teacher teacher) {
        return teacherDao.updateById(teacher);
    }

    public Teacher selectById(Integer teacherId) {
        return teacherDao.selectById(teacherId);
    }

    public List<Teacher> getAll() {
        return teacherDao.selectList(null);
    }

    //    对表中所有信息进行分页, 传入参数为要查询的页数
    public Page<Teacher> getAllTeacherPage(Integer pageNumber) {
        QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();

        Page<Teacher> teacherPage = new Page<>(pageNumber, 5);// 每页大小为5

        teacherDao.selectPage(teacherPage, teacherQueryWrapper);

        return teacherPage;
    }

    //    按条件(性别)进行分页
    public Page<Teacher> getAllTeacherByTeacherSexPage(Integer pageNumber, String teacherSex) {
        QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();

        teacherQueryWrapper.eq("teacher_sex", teacherSex);// 根据条件进行分页, 这里填写的是表中的列名

        Page<Teacher> teacherPage = new Page<>(pageNumber, 5);

        teacherDao.selectPage(teacherPage, teacherQueryWrapper);
        return teacherPage;
    }
}

