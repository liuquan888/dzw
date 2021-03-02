package com.accp.controller;


import com.accp.domain.NativPlace;
import com.accp.service.impl.NativPlaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 籍贯表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/nativPlace")
public class NativPlaceController {

    @Autowired
    NativPlaceServiceImpl service;

    @RequestMapping("/find")
    public List<NativPlace> find(){
        return service.list();
    }
}

