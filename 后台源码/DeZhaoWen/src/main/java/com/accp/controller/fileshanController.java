package com.accp.controller;

import com.accp.domain.*;
import com.accp.mapper.MenuMerchandiseMapper;
import com.accp.service.impl.MenuMerchandiseServiceImpl;
import com.accp.service.impl.MerchandiseServiceImpl;
import com.accp.service.impl.SuppilerServiceImpl;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/fileshan")
public class fileshanController {

    @Autowired
    MerchandiseServiceImpl merchandiseService;
    @Resource
    MenuMerchandiseMapper menuMerchandiseMapper;
    @Autowired
    SuppilerServiceImpl suppilerService;
    @Autowired
    MenuMerchandiseServiceImpl menuMerchandiseService;

    @Autowired
    MerchandiseController merchandiseController;

    @Autowired
    EngineController engineController;

    @Autowired
    SuppilerController suppilerController;

    @Autowired
    MaintenanceController maintenanceController;

    //商品资料导出Excel
    @RequestMapping("/downloadExcel")
    public ResponseEntity<byte []> downloadExcel(Integer menuid,String con1,String con2) throws IOException {

        List<Merchandise> list=merchandiseController.findmer(menuid,con1,con2);

        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet();

        //导出excel头部
        Row rowTitle = sheet.createRow(0);
        Cell head1 = rowTitle.createCell(0);
        Cell head2 = rowTitle.createCell(1);
        Cell head3 = rowTitle.createCell(2);
        Cell head4 = rowTitle.createCell(3);
        Cell head5 = rowTitle.createCell(4);
        Cell head6 = rowTitle.createCell(5);
        Cell head7 = rowTitle.createCell(6);
        Cell head8 = rowTitle.createCell(7);
        Cell head9 = rowTitle.createCell(8);

        head1.setCellValue("编号");
        head2.setCellValue("商品品牌");
        head3.setCellValue("商品适用车型");
        head4.setCellValue("原厂副厂");
        head5.setCellValue("商品等级");
        head6.setCellValue("条形码");
        head7.setCellValue("包装规格");
        head8.setCellValue("商品大类");
        head9.setCellValue("商品厂商");

        if(list!=null){
            for (int i = 0; i < list.size(); i++) {
                Merchandise Value = list.get(i);
                //导出excel数据
                Row rowValue = sheet.createRow(i+1);
                Cell data1 = rowValue.createCell(0);
                Cell data2 = rowValue.createCell(1);
                Cell data3 = rowValue.createCell(2);
                Cell data4 = rowValue.createCell(3);
                Cell data5 = rowValue.createCell(4);
                Cell data6 = rowValue.createCell(5);
                Cell data7 = rowValue.createCell(6);
                Cell data8 = rowValue.createCell(7);
                Cell data9 = rowValue.createCell(8);
                data1.setCellValue(Value.getMeId());
                data2.setCellValue(Value.getMeBrand());
                data3.setCellValue(Value.getMeAdaptable());
                data4.setCellValue(Value.getMeMill());
                data5.setCellValue(Value.getMeGrade());
                data6.setCellValue(Value.getMeCode());
                data7.setCellValue(Value.getMeBack());
                if(Value.getMenuMerchandise()!=null){
                    data8.setCellValue(Value.getMenuMerchandise().getMenuName());
                }
                if (Value.getSuppiler()!=null){
                    data9.setCellValue(Value.getSuppiler().getPName());
                }


            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        book.write(byteArrayOutputStream);
        HttpHeaders headers = new HttpHeaders();
        //设置响应内容为文件流模式
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String fileName = new String("导出商品信息数据.xlsx".getBytes("utf-8"),"iso-8859-1");
        //设置响应的文件的名称
        headers.setContentDispositionFormData("attachment",fileName);
        return new ResponseEntity(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);
    }


    //发动机品牌导出Excel
    @RequestMapping("/EngineExcel")
    public ResponseEntity<byte []> EngineExcel() throws IOException {

        List<Engine> list=engineController.findall();

        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet();

        //导出excel头部
        Row rowTitle = sheet.createRow(0);
        Cell head1 = rowTitle.createCell(0);
        Cell head2 = rowTitle.createCell(1);

        head1.setCellValue("发动机品牌编码");
        head2.setCellValue("发动机品牌名称");

        if(list!=null){
            for (int i = 0; i < list.size(); i++) {
                Engine Value = list.get(i);
                //导出excel数据
                Row rowValue = sheet.createRow(i+1);
                Cell data1 = rowValue.createCell(0);
                Cell data2 = rowValue.createCell(1);
                data1.setCellValue(Value.getECoder());
                data2.setCellValue(Value.getEName());
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        book.write(byteArrayOutputStream);
        HttpHeaders headers = new HttpHeaders();
        //设置响应内容为文件流模式
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String fileName = new String("导出发动机品牌数据.xlsx".getBytes("utf-8"),"iso-8859-1");
        //设置响应的文件的名称
        headers.setContentDispositionFormData("attachment",fileName);
        return new ResponseEntity(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);
    }


    //供货商导出Excel
    @RequestMapping("/suppilerExcel")
    public ResponseEntity<byte []> suppilerExcel(Integer sid,String suppdimtext) throws IOException {

        List<Suppiler> list=suppilerController.findsupp(sid,suppdimtext);

        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet();

        //导出excel头部
        Row rowTitle = sheet.createRow(0);
        Cell head1 = rowTitle.createCell(0);
        Cell head2 = rowTitle.createCell(1);
        Cell head3 = rowTitle.createCell(2);
        Cell head4 = rowTitle.createCell(3);
        Cell head5 = rowTitle.createCell(4);
        Cell head6 = rowTitle.createCell(5);
        Cell head7 = rowTitle.createCell(6);
        Cell head8 = rowTitle.createCell(7);

        head1.setCellValue("编号");
        head2.setCellValue("供货商名称");
        head3.setCellValue("供货商地址");
        head4.setCellValue("供货商开户行");
        head5.setCellValue("供货商网址");
        head6.setCellValue("供货商联系人");
        head7.setCellValue("电话");
        head8.setCellValue("厂商类别");

        if(list!=null){
            for (int i = 0; i < list.size(); i++) {
                Suppiler Value = list.get(i);
                //导出excel数据
                Row rowValue = sheet.createRow(i+1);
                Cell data1 = rowValue.createCell(0);
                Cell data2 = rowValue.createCell(1);
                Cell data3 = rowValue.createCell(2);
                Cell data4 = rowValue.createCell(3);
                Cell data5 = rowValue.createCell(4);
                Cell data6 = rowValue.createCell(5);
                Cell data7 = rowValue.createCell(6);
                Cell data8 = rowValue.createCell(7);
                data1.setCellValue(Value.getPId());
                data2.setCellValue(Value.getPName());
                data3.setCellValue(Value.getPAddress());
                data4.setCellValue(Value.getPBank());
                data5.setCellValue(Value.getPUrl());
                data6.setCellValue(Value.getPLinkman());
                data7.setCellValue(Value.getPPhone());
                if(Value.getSuppilermenu()!=null){
                    data8.setCellValue(Value.getSuppilermenu().getSName());
                }
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        book.write(byteArrayOutputStream);
        HttpHeaders headers = new HttpHeaders();
        //设置响应内容为文件流模式
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String fileName = new String("导出供货商数据.xlsx".getBytes("utf-8"),"iso-8859-1");
        //设置响应的文件的名称
        headers.setContentDispositionFormData("attachment",fileName);
        return new ResponseEntity(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);
    }


    //维修项目导出Excel
    @RequestMapping("/mainExcel")
    public ResponseEntity<byte []> mainExcel(String params) throws IOException {
        List<Integer> intlist2=new ArrayList<>();
        if(params!=null&&params!=""){
            List<String> Stringlist= Arrays.asList(params.split(","));
            Stringlist.forEach(item->{
                intlist2.add(Integer.valueOf(item));
            });
        }
        List<Maintenance> list=maintenanceController.findmain(intlist2);
       // List<Maintenance> list=maintenanceController.findmain(params)
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet();

        //导出excel头部
        Row rowTitle = sheet.createRow(0);
        Cell head1 = rowTitle.createCell(0);
        Cell head2 = rowTitle.createCell(1);
        Cell head3 = rowTitle.createCell(2);
        Cell head4 = rowTitle.createCell(4);
        Cell head5 = rowTitle.createCell(5);
        Cell head6 = rowTitle.createCell(6);
        Cell head7 = rowTitle.createCell(7);

        head1.setCellValue("项目编码");
        head2.setCellValue("项目类别");
        head3.setCellValue("项目名称");
        head4.setCellValue("收入种类");
        head5.setCellValue("标准价");
        head6.setCellValue("协议价");
        head7.setCellValue("备注");

        if(list!=null){
            for (int i = 0; i < list.size(); i++) {
                Maintenance Value = list.get(i);
                //导出excel数据
                Row rowValue = sheet.createRow(i+1);
                Cell data1 = rowValue.createCell(0);
                Cell data2 = rowValue.createCell(1);
                Cell data3 = rowValue.createCell(2);
                Cell data4 = rowValue.createCell(4);
                Cell data5 = rowValue.createCell(5);
                Cell data6 = rowValue.createCell(6);
                Cell data7 = rowValue.createCell(7);
                data1.setCellValue(Value.getMId());
                if (Value.getService()!=null){
                    data2.setCellValue(Value.getService().getSerName());
                }
                data3.setCellValue(Value.getMName());
                if(Value.getIncome()!=null){
                    data4.setCellValue(Value.getIncome().getInName());
                }
                data5.setCellValue(Value.getMNormalprice());
                data6.setCellValue(Value.getMDetaprice());
                data7.setCellValue(Value.getMNote());
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        book.write(byteArrayOutputStream);
        HttpHeaders headers = new HttpHeaders();
        //设置响应内容为文件流模式
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String fileName = new String("导出维修项目数据.xlsx".getBytes("utf-8"),"iso-8859-1");
        //设置响应的文件的名称
        headers.setContentDispositionFormData("attachment",fileName);
        return new ResponseEntity(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);
    }

}
