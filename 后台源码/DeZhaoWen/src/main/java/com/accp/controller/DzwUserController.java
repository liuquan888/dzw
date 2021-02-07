package com.accp.controller;


import com.accp.domain.DzwUser;
import com.accp.service.impl.DzwUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/dzwUser")
public class DzwUserController {
    @Autowired
    DzwUserServiceImpl user;

    @RequestMapping("/find")
    public String find(DzwUser user){
        System.out.println(user.getUserSex());
        return "";
    }
}

