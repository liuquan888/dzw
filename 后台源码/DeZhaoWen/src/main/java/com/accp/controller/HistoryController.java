package com.accp.controller;


import com.accp.domain.History;
import com.accp.service.impl.HistoryServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 历史回访表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    HistoryServiceImpl service;
    public List<History> findById(String kmbm){
        QueryWrapper<History> queryWrapper=new QueryWrapper<>();
        if (kmbm!=null){
            queryWrapper.eq("kmbm",kmbm);
        }
        return service.list(queryWrapper);
    }
}

