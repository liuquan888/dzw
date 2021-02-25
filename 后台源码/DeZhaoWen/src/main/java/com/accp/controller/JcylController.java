package com.accp.controller;


import com.accp.domain.GetMaterial;
import com.accp.domain.Jcyl;
import com.accp.service.impl.JcylServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 油量 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-22
 */
@RestController
@RequestMapping("/jcyl")
public class JcylController {

    @Autowired
    JcylServiceImpl jcyls;

    @GetMapping("/findjcyl")
    public List<Jcyl> show(){
        return jcyls.list();
    }

    @PostMapping("/insert")
    public String add(@RequestBody List<Jcyl> list){
        for(Jcyl j:list){
            if(j.getYlid()!=null){
                jcyls.removeById(j.getYlid());
            }
            jcyls.save(j);
        }
        return "ss";
    }

}

