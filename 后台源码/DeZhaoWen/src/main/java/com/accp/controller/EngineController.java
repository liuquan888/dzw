package com.accp.controller;


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
        List<Engine> list=engineService.list();

        return  list;
    }
    @RequestMapping("/findA")
    public List<Engine> findA(){
        List<Engine> list=engineService.list();
        for(int i=0;i<list.size();i++) {
            if(i==0) {
                list.get(i).setCheck(true);
            }else {
                list.get(i).setCheck(false);
            }
        }
        return list;
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
        boolean result = engineService.removeById(eid);
        if(result){
            return "删除成功";
        }else{
            return  "删除失败";
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
        boolean result=engineService.updateById(engine);
        if (result){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }



}

