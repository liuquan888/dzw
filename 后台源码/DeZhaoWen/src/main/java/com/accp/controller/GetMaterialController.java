package com.accp.controller;


import com.accp.domain.GetMaterial;
import com.accp.service.impl.GetMaterialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 领料情况表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/getMaterial")
public class GetMaterialController {

    @Autowired
    GetMaterialServiceImpl getm;

    @GetMapping("/findgetm")
    public List<GetMaterial> show(){
        return getm.list();
    }

}

