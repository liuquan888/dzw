package com.accp.controller;


import com.accp.domain.StaffData;
import com.accp.service.IDeparmentSurfaceService;
import com.accp.service.IStaffDataService;
import com.accp.service.impl.StaffDataServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 员工资料表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-25
 */
@RestController
@RequestMapping("/staffData")
public class StaffDataController{

    @Autowired
    StaffDataServiceImpl s;
    @Autowired
    IStaffDataService sdService;
    @Autowired
    IDeparmentSurfaceService bservice;

    @RequestMapping("/insert")
    public boolean insert(StaffData s){
        return sdService.save(s);
    }

    @RequestMapping("/emptypass")
    public boolean remove(Integer id){
        return s.gai(id);
    }

    @RequestMapping("/find")
    public List<StaffData> queryAll(String name){
        QueryWrapper<StaffData> stu=new QueryWrapper<>();
        if(name!=null&&name.length()>0){
            stu.lambda().like(StaffData::getYid,name).or().like(StaffData::getYname,name);
        }
        stu.eq("reserved6",1);
        List<StaffData> s= sdService.list(stu);
        for (StaffData sd: s) {
            sd.setBu(bservice.getById(sd.getBid()));
        }
        return s;
    }

    @RequestMapping("/query")
    public List<StaffData> query(){
        return sdService.list();
    }

    @RequestMapping("/updates")
    public boolean update(@RequestBody StaffData s){
        return sdService.updateById(s);
    }

    @RequestMapping("/update")
    public boolean update(@RequestBody List<StaffData> s){
        for(StaffData ss:s) {
            sdService.updateById(ss);
        }
        return true;
    }

    @RequestMapping("/removeId")
    public boolean removeId(Integer id){
        return sdService.removeById(id);
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
        queryWrapper.eq("reserved6",1);
        List<StaffData> sdd= sdService.list(queryWrapper);
        for (StaffData c: sdd) {
            c.setBu(bservice.getById(c.getBid()));
        }
        return sdd;
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
        queryWrapper.eq("reserved6",1);
        List<StaffData> stt= sdService.list(queryWrapper);
        for (StaffData sd: stt) {
            sd.setBu(bservice.getById(sd.getBid()));
        }
        return stt;
    }

    @RequestMapping("/daochu")
    public ResponseEntity<byte []> downloadExcel() throws IOException {
        List<StaffData> list = sdService.list();
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet();
        //导出excel头部
        Row rowTitle = sheet.createRow(0);
        Cell studentCodeTitle = rowTitle.createCell(0);
        Cell studentNameTitle = rowTitle.createCell(1);
        Cell studentAgeTitle = rowTitle.createCell(2);
        Cell studentBirthdayTitle = rowTitle.createCell(3);
        studentCodeTitle.setCellValue("员工编号");
        studentNameTitle.setCellValue("员工姓名");
        studentAgeTitle.setCellValue("员工性别");
        studentBirthdayTitle.setCellValue("身体状况");

        //组装导出的学生数据，如果是其他业务，请根据业务情况进行编写
        if(list!=null){
            for (int i = 0; i < list.size(); i++) {
                StaffData stuValue = list.get(i);
                //导出excel数据
                Row rowValue = sheet.createRow(i+1);
                Cell studentCodeValue = rowValue.createCell(0);
                Cell studentNameValue = rowValue.createCell(1);
                Cell studentAgeValue = rowValue.createCell(2);
                Cell studentBirthdayValue = rowValue.createCell(3);
                studentCodeValue.setCellValue(stuValue.getYid());
                studentNameValue.setCellValue(stuValue.getYname());
                studentAgeValue.setCellValue(stuValue.getYsex());
                studentBirthdayValue.setCellValue(stuValue.getYhealth());
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        book.write(byteArrayOutputStream);

        HttpHeaders headers = new HttpHeaders();
        //设置响应内容为文件流模式
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String fileName = new String("学生导出数据.xlsx".getBytes("utf-8"),"iso-8859-1");
        //设置响应的文件的名称
        headers.setContentDispositionFormData("attachment",fileName);
        return new ResponseEntity(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);
    }
}

