package com.accp.controller;


import com.accp.domain.Customer;
import com.accp.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 客户表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerServiceImpl Service;

    @RequestMapping("/find")
    @ResponseBody
    public List<Customer> find(){
        List<Customer> list=Service.list();
        return list;
    }
}

