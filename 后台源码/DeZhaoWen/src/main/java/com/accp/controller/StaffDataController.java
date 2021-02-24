package com.accp.controller;


import com.accp.domain.PostList;
import com.accp.domain.StaffData;
import com.accp.service.impl.StaffDataServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 员工资料表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/staffData")
public class StaffDataController {

    @Autowired
    StaffDataServiceImpl sdService;

    @RequestMapping("/find")
    public List<StaffData> queryAll(){
        return sdService.list();
    }

    @RequestMapping("/update")
    public boolean update(@RequestBody List<StaffData> s){
        for(StaffData ss:s) {
            sdService.updateById(ss);
        }
        return true;
    }

    @RequestMapping("/findByIds/{id}")
    public List<StaffData> findByIds(@PathVariable("id") Integer id){
        QueryWrapper<StaffData> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("reserved5",id);
        return sdService.list(queryWrapper);
    }

    @RequestMapping("/findById")
    public List<StaffData> findById(@RequestBody List<Integer> s){
        QueryWrapper<StaffData> queryWrapper=new QueryWrapper<>();
        for(Integer i:s){
            queryWrapper.or().eq("reserved3",i);
        }
        return sdService.list(queryWrapper);
    }

    @RequestMapping("/findId")
    public List<StaffData> findId(StaffData s){
        QueryWrapper<StaffData> queryWrapper=new QueryWrapper<>();
        if (s.getYname()!=null) {
            queryWrapper.like("yname",s.getYname());
        }
        if (s.getYid()!=null) {
            queryWrapper.like("yid",s.getYid());
        }
        if (s.getYsex()!=null) {
            queryWrapper.like("ysex",s.getYsex());
        }
        if (s.getGid()!=null) {
            queryWrapper.like("gid",s.getGid());
        }
        if (s.getBid()!=null) {
            queryWrapper.like("bid",s.getBid());
        }
        if (s.getYheigth()!=null) {
            queryWrapper.like("yheigth",s.getYheigth());
        }
        if (s.getYnativplaceid()!=null) {
            queryWrapper.like("ynativplaceid",s.getYnativplaceid());
        }
        if (s.getYnationid()!=null) {
            queryWrapper.like("ynationid",s.getYnationid());
        }
        if (s.getYmarriageid()!=null) {
            queryWrapper.like("ymarriageid",s.getYmarriageid());
        }
        if (s.getYeducationid()!=null) {
            queryWrapper.like("yeducationid",s.getYeducationid());
        }
        if (s.getYschoolid()!=null) {
            queryWrapper.like("yschoolid",s.getYschoolid());
        }
        if (s.getYspecialtyid()!=null) {
            queryWrapper.like("yspecialtyid",s.getYspecialtyid());
        }
        if (s.getYspecialtynid()!=null) {
            queryWrapper.like("yspecialtynid",s.getYspecialtynid());
        }
        if (s.getYdatetime()!=null) {
            queryWrapper.like("ydatetime",s.getYdatetime());
        }
        if (s.getYorganizationid()!=null) {
            queryWrapper.like("yorganizationid",s.getYorganizationid());
        }
        if (s.getYschoolid()!=null) {
            queryWrapper.like("yschoolid",s.getYschoolid());
        }
        if (s.getYnumber()!=null) {
            queryWrapper.like("ynumber",s.getYnumber());
        }
        if (s.getYattribute()!=null) {
            queryWrapper.like("yattribute",s.getYattribute());
        }
        if (s.getYheigth()!=null) {
            queryWrapper.like("yheigth",s.getYheigth());
        }
        return sdService.list(queryWrapper);
    }
}

