package com.accp.controller;


import com.accp.domain.*;
import com.accp.service.impl.*
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 维修单据表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@RestController
@RequestMapping("/repairBill")
public class RepairBillController {
    @Autowired
    RepairBillServiceImpl service;

    //查询适用于条件查询
    @RequestMapping("/find")
    @ResponseBody
    public List<RepairBill> find(Date date1,Date date2,String no,Integer jsType,String chepaiNo,String name,Integer ywType,String remark){
        QueryWrapper qw=new QueryWrapper<RepairBill>();

        if (date1!=null&&date2!=null){
            qw.between("completionTime",date1,date2);
        }

        if(no!=null){
            qw.lt("no",no);
        }
        if(jsType!=null){
            qw.lt("jsType",jsType);
        }
        if(chepaiNo!=null){
            qw.lt("chepaiNo",chepaiNo);
        }
        if(name!=null){
            qw.lt("name",name);
        }
        if(ywType!=null){
            qw.lt("ywType",ywType);
        }
        if(remark!=null){
            qw.lt("remark",remark);
        }

        List<RepairBill> list = service.list();
        return list;
    }

    
}

