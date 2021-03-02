package com.accp.controller;


import com.accp.domain.City;
import com.accp.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 城市表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityServiceImpl service;

    @RequestMapping("/find")
    public List<City> find(){
        return service.list();
    }

}

