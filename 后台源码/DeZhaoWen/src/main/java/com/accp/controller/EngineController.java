package com.accp.controller;


import com.accp.domain.Engine;
import com.accp.service.impl.EngineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 发动机表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@RestController
@RequestMapping("/engine")
public class EngineController {

    @Autowired
    EngineServiceImpl engineService;

    @GetMapping("/findall")
    public List<Engine> findall(){
        System.out.print("s");
        return  engineService.list();
    }
}

