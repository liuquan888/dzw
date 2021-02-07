package com.accp.controller;


import com.accp.domain.Carheet;
import com.accp.service.impl.CarheetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 车辆资料表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/carheet")
public class CarheetController {
    @Autowired
    CarheetServiceImpl service;
    public List<Carheet> findAll(){
        return service.list();
    }
    public List<Carheet> findLike(Carheet car){
        return null;
    }
}

