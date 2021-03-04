package com.accp.controller;


import com.accp.domain.*;
import com.accp.mapper.DeparmentSurfaceMapper;
import com.accp.mapper.StaffDataMapper;
import com.accp.service.IDeparmentSurfaceService;
import com.accp.service.IStaffDataService;
import com.accp.service.impl.OrganizationSurfaceServiceImpl;
import com.accp.service.impl.StaffDataServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ytang
 * @since 2021-01-27
 */
@RestController
@RequestMapping("/lizhiyuanyingbiao")
public class QuitReasonSurfaceController {
    @Autowired
    StaffDataMapper ymapper;
    @Autowired
    DeparmentSurfaceMapper bmapper;
    @Autowired
    IStaffDataService service;
    @Autowired
    IDeparmentSurfaceService bservice;
    @Autowired
    OrganizationSurfaceServiceImpl o;

    @RequestMapping("/lizhifind")
    public List<StaffData> LizhiFind(String name){
        QueryWrapper<StaffData> stu=new QueryWrapper<>();
        if(name!=null&&name.length()>0){
            stu.lambda().like(StaffData::getYid,name).or().like(StaffData::getYname,name);
        }
        stu.eq("reserved6",2);
        List<StaffData> s= service.list(stu);
        for (StaffData sd: s) {
            sd.setBu(bservice.getById(sd.getBid()));
        }
        return s;
    }

    @RequestMapping("/findsd")
    public List<OrganizationSurface> findByAlls(String name){
        QueryWrapper<OrganizationSurface> stu=new QueryWrapper<>();
        if(name!=null&&name.length()>0){
            stu.lambda().like(OrganizationSurface::getZid,name).or().like(OrganizationSurface::getZname,name);
        }
        return o.list(stu);
    }

    @RequestMapping("/lizhih/{id}")
    public boolean LizhiH(@PathVariable("id") Integer id){
        boolean su=ymapper.lizhih(id);
        return su;
    }

    @RequestMapping("/lizhib")
    public List<DeparmentSurface> LizhiB1(){
        List<DeparmentSurface> s=bmapper.bu();
        return s;
    }

    @RequestMapping("/lizhibu")
    public List<DeparmentSurface> LizhiB2(){
        List<DeparmentSurface> s=bmapper.bu1();
        return s;
    }

    @RequestMapping("/lizhibuxuan/{id}")
    public List<DeparmentSurface> LizhibuXuan(@PathVariable Integer id){
        List<DeparmentSurface> s=bmapper.bu2(id);
        return s;
    }

    @RequestMapping("/lizhiid/{id}")
    public StaffData LizhiId(@PathVariable("id") Integer id){
        StaffData s=service.getById(id);
        return s;
    }

    @RequestMapping("/lizhixiu")
    public boolean LizhiXiu(StaffData stu){
        boolean s=service.updateById(stu);
        return s;
    }

    @RequestMapping("/find")
    public List<OrganizationSurface> findByAll(String name){
        QueryWrapper<OrganizationSurface> stu=new QueryWrapper<>();
        if(name!=null&&name.length()>0){
            stu.lambda().like(OrganizationSurface::getZid,name).or().like(OrganizationSurface::getZname,name);
        }
        return o.list(stu);
    }

    @RequestMapping("/findById")
    public List<StaffData> findById(@RequestBody List<Integer> s){
        QueryWrapper<StaffData> queryWrapper=new QueryWrapper<>();
        for(Integer i:s){
            queryWrapper.or().eq("reserved3",i);
        }
        queryWrapper.eq("reserved6",2);
        List<StaffData> sdd= service.list(queryWrapper);
        for (StaffData c: sdd) {
            c.setBu(bservice.getById(c.getBid()));
        }
        return sdd;
    }

    @RequestMapping("/lizhib1/{id}")
    public DeparmentSurface lizhib1(@PathVariable("id") Integer id){
        return bservice.getById(id);
    }

    @RequestMapping("/lizhiyuans")
    public List<StaffData> LizhiYuans(){
        QueryWrapper<StaffData> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("reserved6",1);
        List<StaffData> sdd= service.list(queryWrapper);
        for (StaffData c: sdd) {
            c.setBu(bservice.getById(c.getBid()));
        }
        return sdd;
    }

    @RequestMapping("/lizhixz")
    public boolean LizhiXz(StaffData stu){
        boolean s=ymapper.lizhixz(stu);
        return s;
    }

    @RequestMapping("/allc")
    public List<StaffData> AllSelect(StaffData s){
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
        queryWrapper.eq("reserved6",2);
        List<StaffData> stt= service.list(queryWrapper);
        for (StaffData sd: stt) {
            sd.setBu(bservice.getById(sd.getBid()));
        }
        return stt;
    }

    @RequestMapping("/lizhid/{id}")
    public boolean LizhiDelete(@PathVariable("id") Integer id){
        return service.removeById(id);
    }
}

