package com.accp.controller;


import com.accp.domain.Engine;
import com.accp.mapper.EngineMapper;
import com.accp.service.impl.EngineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    //查看所有发动机品牌
    @GetMapping("/findall")
    public List<Engine> findall(){
        return  engineService.list();
    }

    //添加发动机品牌
    @PostMapping("/add")
    public boolean add(Engine engine){
        return engineService.save(engine);
    }

}

