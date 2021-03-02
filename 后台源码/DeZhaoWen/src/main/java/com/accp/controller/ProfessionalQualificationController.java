package com.accp.controller;


import com.accp.domain.GraduateSchool;
import com.accp.domain.ProfessionalQualification;
import com.accp.service.impl.GraduateSchoolServiceImpl;
import com.accp.service.impl.ProfessionalQualificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 专业资格表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/professionalQualification")
public class ProfessionalQualificationController {

    @Autowired
    ProfessionalQualificationServiceImpl service;

    @RequestMapping("/find")
    public List<ProfessionalQualification> find(){
        return service.list();
    }
}

