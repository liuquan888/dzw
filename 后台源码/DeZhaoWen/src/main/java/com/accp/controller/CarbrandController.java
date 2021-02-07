package com.accp.controller;


import com.accp.domain.Carbrand;
import com.accp.service.impl.CarbrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 车辆品牌 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/carbrand")
public class CarbrandController {
    @Autowired
    CarbrandServiceImpl service;
    @RequestMapping("/findAll")
    public List<Carbrand> findAll(Carbrand cb){
            return null;
    }
}

