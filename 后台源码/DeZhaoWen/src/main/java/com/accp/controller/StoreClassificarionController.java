package com.accp.controller;


import com.accp.domain.StoreClassificarion;
import com.accp.service.impl.StoreClassificarionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 门店分类表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/storeClassificarion")
public class StoreClassificarionController {

    @Autowired
    StoreClassificarionServiceImpl service;

    @RequestMapping("/find")
    public List<StoreClassificarion> find(){
        return service.list();
    }
}

