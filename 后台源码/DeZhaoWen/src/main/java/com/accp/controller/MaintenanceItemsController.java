package com.accp.controller;


import com.accp.domain.MaintenanceItems;
import com.accp.service.impl.MaintenanceItemsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 维修项目表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/maintenanceItems")
public class MaintenanceItemsController {

    @Autowired
    MaintenanceItemsServiceImpl mainren;

    @GetMapping("/findten")
    public List<MaintenanceItems> show(){
        return mainren.list();
    }

}

