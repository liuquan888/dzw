package com.accp.controller;


import com.accp.domain.Customer;
import com.accp.service.impl.CustomerServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
    public List<Customer> find(String customernumber,String phone,String customername,String bankaccount,String remark){
        QueryWrapper qw=new QueryWrapper<Customer>();
        if(customernumber!=null){
            qw.like("customernumber",customernumber);
        }
        if(phone!=null){
            qw.like("phone",phone);
        }
        if(customername!=null){
            qw.like("customername",customername);
        }
        if(bankaccount!=null){
            qw.like("bankaccount",bankaccount);
        }
        if(remark!=null){
            qw.like("remark",remark);
        }
        List<Customer> list=Service.list(qw);
        return list;
    }

    @RequestMapping("/pay")
    public Integer pay(String id,Integer money){
        Customer c=Service.getById(id);
        Customer customer=new Customer();
        customer.setCustomernum(id);
        customer.setVipprice(c.getVipprice()+money);
        boolean b = Service.updateById(customer);
        if(b)
            return 0000;
        else
            return 0100;
    }
}

