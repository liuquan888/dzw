package com.accp.controller;


import com.accp.domain.Cicompany;
import com.accp.service.impl.CicompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 商业保险公司 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/cicompany")
public class CicompanyController {
    @Autowired
    CicompanyServiceImpl service;
    @RequestMapping("/findAll")
    public List<Cicompany> findAll(){
        return service.list();
    }
    @RequestMapping("/findById/{cicompanyid}")
    public Cicompany findById(Integer id){
        return service.getById(id);
    }
}

