package com.accp.controller;


import com.accp.domain.Education;
import com.accp.domain.MaritalStatus;
import com.accp.service.impl.EducationServiceImpl;
import com.accp.service.impl.MaritalStatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 学历表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/education")
public class EducationController {

    @Autowired
    EducationServiceImpl service;

    @RequestMapping("/find")
    public List<Education> find(){
        return service.list();
    }
}

