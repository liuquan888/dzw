package com.accp.controller;


import com.accp.domain.Bank;
import com.accp.service.impl.BankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 银行表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    BankServiceImpl service;

    @RequestMapping("/findByBankId/{bankid}")
    public Bank findByBankId(@PathVariable("bankid") Integer bankid){
        return service.getById(bankid);
    }

}

