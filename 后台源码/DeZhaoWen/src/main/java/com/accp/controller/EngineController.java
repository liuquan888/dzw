package com.accp.controller;


import com.accp.domain.Car;
import com.accp.domain.Engine;
import com.accp.mapper.EngineMapper;
import com.accp.service.impl.EngineServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        QueryWrapper<Engine> engineQueryWrapper=new QueryWrapper<>();
        engineQueryWrapper.eq("e_coder",engine.getECoder());
        if(engineService.list(engineQueryWrapper).size()>0){
            return "000001";
        }
        boolean result = engineService.save(engine);
        if (result){
            return "新增成功";
        }else {
            return "新增失败";
        }
    }

    //删除发动机
    @GetMapping("/remove/{eid}")
    public String remove(@PathVariable Integer eid){
        try {
            return engineService.removeById(eid)?"000000":"-1";
        }catch (Exception exception){
            return "000002";
        }
    }


    //查询单个
    @GetMapping("/findbyid/{eid}")
    public Engine findbyid(@PathVariable Integer eid){
        return engineService.getById(eid);
    }


    //修改发动机
    @PostMapping("/update")
    public String update(Engine engine){
        QueryWrapper engineqw=new QueryWrapper<Car>();
        engineqw.eq("e_coder",engine.getECoder());
        engineqw.ne("e_id",engine.getEId());
        if(engineService.list(engineqw).size()>0){
            return "000001";
        }
        boolean result=engineService.updateById(engine);
        if (result){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }



}

