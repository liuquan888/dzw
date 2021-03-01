package com.accp.controller;


import com.accp.domain.Clearing;
import com.accp.service.impl.ClearingFormServiceImpl;
import com.accp.service.impl.ClearingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 结算信息表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/clearing")
public class ClearingController {

    @Autowired
    ClearingServiceImpl clear;

    @GetMapping("/findclear")
    public List<Clearing> showlist(){
        return clear.list();
    }

}

