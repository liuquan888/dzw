package com.accp.controller;


import com.accp.domain.Carbrand;
import com.accp.service.impl.CarbrandServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 车辆品牌 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/carbrand")
public class CarbrandController {
    @Autowired
    CarbrandServiceImpl service;
    @RequestMapping("/findAll")
    public List<Carbrand> findAll(@PathVariable Carbrand cb){
        QueryWrapper<Carbrand> query=new QueryWrapper<>();
        if(cb.getBrandname()!=null){
            query.lambda().like(Carbrand::getBrandname,cb.getBrandname());
        }
        if(cb.getCarcoding()!=null){
            query.lambda().like(Carbrand::getCarcoding,cb.getCarcoding());
        }
        if (cb.getInitial()!=null){
            query.lambda().like(Carbrand::getInitial,cb.getInitial());
        }
        List<Carbrand> list=service.list(query);
        return list;
    }

}

