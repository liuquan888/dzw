package com.accp.controller;


import com.accp.domain.Education;
import com.accp.domain.GraduateSchool;
import com.accp.service.impl.EducationServiceImpl;
import com.accp.service.impl.GraduateSchoolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 学校表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/graduateSchool")
public class GraduateSchoolController {

    @Autowired
    GraduateSchoolServiceImpl service;

    @RequestMapping("/find")
    public List<GraduateSchool> find(){
        return service.list();
    }
}

