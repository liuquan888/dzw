package com.accp.controller;


<<<<<<< HEAD
=======
import com.accp.domain.Engine;
import com.accp.mapper.EngineMapper;
import com.accp.service.impl.EngineServiceImpl;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> 1602f9564542f755e444c629a7c1495a983617a3
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 发动机表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/engine")
public class EngineController {

<<<<<<< HEAD
=======
    @Autowired
    EngineServiceImpl engineService;

    //查看所有发动机品牌
    @GetMapping("/findall")
    public List<Engine> findall(){
        return  engineService.list();
    }

    //添加发动机品牌
    @PostMapping("/add")
    public String add(Engine engine){
        boolean result = engineService.save(engine);
        if (result){
            return "新增成功";
        }else {
            return "新增失败";
        }

    }

>>>>>>> 1602f9564542f755e444c629a7c1495a983617a3
}

