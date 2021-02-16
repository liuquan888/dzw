package com.accp.controller;


import com.accp.domain.Caraffiliation;
import com.accp.service.impl.CaraffiliationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 车辆归属表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/caraffiliation")
public class CaraffiliationController {
    @Autowired
    CaraffiliationServiceImpl service;
    @RequestMapping("/find")
    public List<Caraffiliation> find(){
        return service.list();
    }
}

