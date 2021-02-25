package com.accp.controller;


import com.accp.domain.Businessclass;
import com.accp.domain.Sgbc;
import com.accp.service.impl.SgbcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 施工班次 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-22
 */
@RestController
@RequestMapping("/sgbc")
public class SgbcController {

    @Autowired
    SgbcServiceImpl sgbc;

    @GetMapping("/findsgbc")
    public List<Sgbc> show(){
        return sgbc.list();
    }

}

