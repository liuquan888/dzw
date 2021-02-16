package com.accp.controller;


import com.accp.domain.Mlicompany;
import com.accp.service.impl.MlicompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 交强险保险公司表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/mlicompany")
public class MlicompanyController {
    @Autowired
    MlicompanyServiceImpl service;
    @RequestMapping("/findAll")
    public List<Mlicompany> findAll(){
        return service.list();
    }
}

