package com.accp.controller;


import com.accp.domain.Field;
import com.accp.service.impl.FieldServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-24
 */
@RestController
@RequestMapping("/field")
public class FieldController {

    @Autowired
    FieldServiceImpl service;

    @RequestMapping("/find")
    public List<Field> find(){
        return service.list();
    }

}

