package com.cheneyclient.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cheneyclient.entity.Teacher;
import com.cheneyclient.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/teacher")
class TeacherController {
    @Autowired
    private TeacherService teacherService;

    /**
     * http://localhost:10084/c1/teacher/add
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    void doAdd() {
        Teacher teacher = new Teacher()
                .setTeacherName("CHENEY-" + new Random().nextInt(100))
                .setTeacherSex("女")
                .setTeacherSalary(9876.5);
        teacherService.insert(teacher);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    void doDelete() {
        teacherService.delete(2);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    void doUpdate() {
        Teacher teacher = new Teacher()
                .setTeacherId(1)
                .setTeacherName("qwe12")
                .setTeacherSex("女")
                .setTeacherSalary(1234.5);
        teacherService.update(teacher);
    }

    @RequestMapping(value = "/selectById", method = RequestMethod.POST)
    void doSelectById() {
        teacherService.selectById(1);
    }

    @RequestMapping(value = "/getall", method = RequestMethod.POST)
    List<Teacher> getAll() {
        return teacherService.getAll();
    }

    //    查看第三页
    @RequestMapping(value = "/page3", method = RequestMethod.POST)
    List<Teacher> getAllTeacherPageTest() {
        Page<Teacher> teacherPage = teacherService.getAllTeacherPage(3);
        return teacherPage.getRecords();
    }

    //    查询男生第1页的内容
    @RequestMapping(value = "/page4", method = RequestMethod.POST)
    List<Teacher>  getAllTeacherByTeacherSexPageTest() {
        Page<Teacher> teacherPage = teacherService.getAllTeacherByTeacherSexPage(1, "男");
        return teacherPage.getRecords();
    }

}



