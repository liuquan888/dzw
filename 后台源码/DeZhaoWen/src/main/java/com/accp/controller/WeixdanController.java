package com.accp.controller;


import com.accp.domain.Carheet;
import com.accp.domain.Weixdan;
import com.accp.service.impl.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-22
 */
@RestController
@RequestMapping("/weixdan")
public class WeixdanController {

    @Autowired
    WeixdanServiceImpl weixd;

    @Autowired
    MaintenanceItemsServiceImpl mainte;

    @Autowired
    PatternServiceImpl patte;

    @Autowired
    JcylServiceImpl jcy;

    @Autowired
    BusinessclassServiceImpl busine;

    @Autowired
    SgbcServiceImpl sgb;


    @GetMapping("/findweixdan/{weixdanhao}")
     public Weixdan weix(@PathVariable String weixdanhao){
         QueryWrapper q=new QueryWrapper<Weixdan>();
         if(weixdanhao!=""){
             q.eq("weixdanh",weixdanhao);
         }
         return (Weixdan) weixd.list(q).get(0);
     }

}

