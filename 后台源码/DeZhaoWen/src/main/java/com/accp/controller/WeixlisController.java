package com.accp.controller;


import com.accp.domain.Businessclass;
import com.accp.domain.Weixlis;
import com.accp.service.impl.BusinessclassServiceImpl;
import com.accp.service.impl.WeixlisServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 维修历史 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/weixlis")
public class WeixlisController {

    @Autowired
    WeixlisServiceImpl weix;

    @Autowired
    BusinessclassServiceImpl bussine;

    @GetMapping("/findweix")
    public List<Weixlis> carList(){
        List<Weixlis> list=weix.list();
        for (Weixlis we:list) {
            QueryWrapper plqw=new QueryWrapper<Businessclass>();
            plqw.eq("businessid",we.getYwlx());
            Businessclass p=(Businessclass) bussine.list(plqw).get(0);
            we.setBusinessclass(p);
        }
        return list;
    }

}

