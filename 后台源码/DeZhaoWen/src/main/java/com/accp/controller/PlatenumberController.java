package com.accp.controller;


import com.accp.domain.Platenumber;
import com.accp.service.impl.PlatenumberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 车牌表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/platenumber")
public class PlatenumberController {
    @Autowired
    PlatenumberServiceImpl service;
    @RequestMapping("findAll")
    public List<Platenumber> findAll(){
        return service.list();
    }

}

