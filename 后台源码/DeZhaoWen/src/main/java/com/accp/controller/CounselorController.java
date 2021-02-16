package com.accp.controller;


import com.accp.domain.Counselor;
import com.accp.service.impl.CounselorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 顾问表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/counselor")
public class CounselorController {
    @Autowired
    CounselorServiceImpl service;
    @RequestMapping("/findAll")
    public List<Counselor> findAll(){
        return service.list();
    }
    @RequestMapping("/findById/{counselorid}")
    public Counselor findById(Integer id){
        return service.getById(id);
    }
}

