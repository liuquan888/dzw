package com.accp.controller;


import com.accp.domain.Teamtechnician;
import com.accp.service.impl.TeamtechnicianServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

import java.io.*;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/teamtechnician")
public class TeamtechnicianController {
    @Autowired
    TeamtechnicianServiceImpl service;

    @RequestMapping("/findByTeamId/{teamid}")
    public List<Teamtechnician> findByTeamId(@PathVariable("teamid") Integer teamid){
        return service.findByTeamId(teamid);
    }

    @RequestMapping("/insertTeamtechnician")
    public boolean insertTeamtechnician(Teamtechnician teamtechnician){
        return service.save(teamtechnician);
    }

    @RequestMapping("/findByIds/{id}")
    public Teamtechnician findByIds(@PathVariable("id") Integer id){
        return service.getById(id);
    }

    @RequestMapping("/removeById/{id}")
    public boolean removeById(@PathVariable("id") Integer id){
        return service.removeById(id);
    }

    @RequestMapping("/updateTeamtechnician")
    public boolean updateTeamtechnician(@RequestBody Teamtechnician teamtechnician){
        return service.updateById(teamtechnician);
    }

    @RequestMapping("/findByAll")
    public List<Teamtechnician> findByAll(String name){
        if(name!=null && name!=" " && name.length()>0){
           return service.findByAll(name);
        }else{
            return null;
        }
    }

    @RequestMapping("/clearPwd/{id}")
    public boolean clearPwd(@PathVariable("id") Integer id){
        return service.clearPwd(id);
    }

    @RequestMapping("/downloadExcel")
    public ResponseEntity<byte []> downloadExcel(Teamtechnician teamtechnician) throws IOException {
        List<Teamtechnician> list=service.findByTeamId(teamtechnician.getTeamid());
        Workbook workbook=new XSSFWorkbook();
        Sheet sheet=workbook.createSheet();

        Row rowTitle=sheet.createRow(0);
        Cell teamidTitle = rowTitle.createCell(0);
        Cell menuNameTitle = rowTitle.createCell(1);
        Cell technicianidTitle = rowTitle.createCell(2);
        Cell technicianidnameTitle = rowTitle.createCell(3);
        Cell sexTitle = rowTitle.createCell(4);
        Cell phoneTitle = rowTitle.createCell(5);
        Cell addressTitle = rowTitle.createCell(6);
        Cell birthdayTitle = rowTitle.createCell(7);
        Cell headmanTitle = rowTitle.createCell(8);
        Cell loginnameTitle = rowTitle.createCell(9);
        Cell idnumberTitle = rowTitle.createCell(10);
        Cell residenceaddressTitle = rowTitle.createCell(11);
        Cell banknameTitle = rowTitle.createCell(12);
        Cell bankaccountTitle = rowTitle.createCell(13);
        Cell starTitle = rowTitle.createCell(14);
        Cell typeTitle = rowTitle.createCell(15);
        Cell maintenancetypeTitle = rowTitle.createCell(16);

        teamidTitle.setCellValue("班组编号");
        menuNameTitle.setCellValue("班组名称");
        technicianidTitle.setCellValue("技工编号");
        technicianidnameTitle.setCellValue("技工姓名");
        sexTitle.setCellValue("性别");
        phoneTitle.setCellValue("手机");
        addressTitle.setCellValue("地址");
        birthdayTitle.setCellValue("出生日期");
        headmanTitle.setCellValue("组长");
        loginnameTitle.setCellValue("登录名");
        idnumberTitle.setCellValue("身份证号");
        residenceaddressTitle.setCellValue("户口地址");
        banknameTitle.setCellValue("开户银行");
        bankaccountTitle.setCellValue("银行账号");
        starTitle.setCellValue("星级");
        typeTitle.setCellValue("维修工种");
        maintenancetypeTitle.setCellValue("维修品牌");

        if(list!=null){
            for (int i=0;i<list.size();i++){
                Teamtechnician teamtechnicianValue=list.get(i);
                Row rowValue = sheet.createRow(i+1);
                Cell teamidValue = rowValue.createCell(0);
                Cell menuNameValue = rowValue.createCell(1);
                Cell technicianidValue = rowValue.createCell(2);
                Cell technicianidnameValue = rowValue.createCell(3);
                Cell sexValue = rowValue.createCell(4);
                Cell phoneValue = rowValue.createCell(5);
                Cell addressValue = rowValue.createCell(6);
                Cell birthdayValue = rowValue.createCell(7);
                Cell headmanValue = rowValue.createCell(8);
                Cell loginnameValue = rowValue.createCell(9);
                Cell idnumberValue = rowValue.createCell(10);
                Cell residenceaddressValue = rowValue.createCell(11);
                Cell banknameValue = rowValue.createCell(12);
                Cell bankaccountValue = rowValue.createCell(13);
                Cell starValue = rowValue.createCell(14);
                Cell typeValue = rowValue.createCell(15);
                Cell maintenancetypeValue = rowValue.createCell(16);
                teamidValue.setCellValue(teamtechnicianValue.getTeamid());
                menuNameValue.setCellValue(teamtechnicianValue.getTeamname().getMenuname());
                technicianidValue.setCellValue(teamtechnicianValue.getTechnicianid());
                technicianidnameValue.setCellValue(teamtechnicianValue.getTechnicianidname());
                sexValue.setCellValue(teamtechnicianValue.getSex());
                phoneValue.setCellValue(teamtechnicianValue.getPhone());
                addressValue.setCellValue(teamtechnicianValue.getAddress());
                birthdayValue.setCellValue(teamtechnicianValue.getBirthday());
                headmanValue.setCellValue(teamtechnicianValue.getHeadman());
                loginnameValue.setCellValue(teamtechnicianValue.getLoginname());
                idnumberValue.setCellValue(teamtechnicianValue.getIdnumber());
                residenceaddressValue.setCellValue(teamtechnicianValue.getResidenceaddress());
                banknameValue.setCellValue(teamtechnicianValue.getBank().getBankname());
                bankaccountValue.setCellValue(teamtechnicianValue.getBankaccount());
                starValue.setCellValue(teamtechnicianValue.getMechanicstar().getStar());
                typeValue.setCellValue(teamtechnicianValue.getType());
                maintenancetypeValue.setCellValue(teamtechnicianValue.getMaintenancetype());
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String fileName = new String("技工导出数据.xlsx".getBytes("utf-8"),"iso-8859-1");
        headers.setContentDispositionFormData("attachment",fileName);
        return new ResponseEntity(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);
    }

    @RequestMapping("/findAll")
    public List<Teamtechnician> findAll(){
        return service.findAll();
    }

}

