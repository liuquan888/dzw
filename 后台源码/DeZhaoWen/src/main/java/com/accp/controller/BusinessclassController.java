package com.accp.controller;


import com.accp.domain.Businessclass;
import com.accp.domain.Jcyl;
import com.accp.service.impl.BusinessclassServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 业务类别表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/businessclass")
public class BusinessclassController {

    @Autowired
    BusinessclassServiceImpl busi;

    @GetMapping("/findshow")
    public List<Businessclass> show(){
        return busi.list();
    }

}

