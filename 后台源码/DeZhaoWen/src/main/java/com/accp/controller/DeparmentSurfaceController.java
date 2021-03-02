package com.accp.controller;


import com.accp.domain.DeparmentSurface;
import com.accp.service.impl.DeparmentSurfaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/deparmentSurface")
public class DeparmentSurfaceController {

    @Autowired
    DeparmentSurfaceServiceImpl  service;

    @RequestMapping("/find")
    public List<DeparmentSurface> find(){
        return service.list();
    }
}

