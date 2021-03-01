package com.accp.controller;


import com.accp.domain.GraduateSchool;
import com.accp.domain.Organization;
import com.accp.service.impl.GraduateSchoolServiceImpl;
import com.accp.service.impl.OrganizationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 编制表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    OrganizationServiceImpl service;

    @RequestMapping("/find")
    public List<Organization> find(){
        return service.list();
    }
}

