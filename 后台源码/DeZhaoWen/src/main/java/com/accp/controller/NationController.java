package com.accp.controller;


import com.accp.domain.Nation;
import com.accp.domain.NativPlace;
import com.accp.service.impl.NationServiceImpl;
import com.accp.service.impl.NativPlaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 民族表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/nation")
public class NationController {

    @Autowired
    NationServiceImpl service;

    @RequestMapping("/find")
    public List<Nation> find(){
        return service.list();
    }
}

