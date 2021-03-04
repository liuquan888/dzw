package com.accp.controller;


import com.accp.domain.MaritalStatus;
import com.accp.domain.Nation;
import com.accp.service.impl.MaritalStatusServiceImpl;
import com.accp.service.impl.NationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 婚姻状态表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/maritalStatus")
public class MaritalStatusController {

    @Autowired
    MaritalStatusServiceImpl service;

    @RequestMapping("/find")
    public List<MaritalStatus> find(){
        return service.list();
    }
}

