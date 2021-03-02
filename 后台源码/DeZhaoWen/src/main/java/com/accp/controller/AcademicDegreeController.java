package com.accp.controller;


import com.accp.domain.AcademicDegree;
import com.accp.domain.GraduateSchool;
import com.accp.service.impl.AcademicDegreeServiceImpl;
import com.accp.service.impl.GraduateSchoolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 学位表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/academicDegree")
public class AcademicDegreeController {

    @Autowired
    AcademicDegreeServiceImpl service;

    @RequestMapping("/find")
    public List<AcademicDegree> find(){
        return service.list();
    }
}

