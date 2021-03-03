package com.accp.controller;


import com.accp.domain.PostList;
import com.accp.domain.StaffData;
import com.accp.service.impl.PostListServiceImpl;
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
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 岗位表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/postList")
public class PostListController {

    @Autowired
    PostListServiceImpl plservice;

    @RequestMapping("/find")
    public List<PostList> queryAll(){
       return plservice.list();
    }

    @RequestMapping("/add")
    public boolean add(PostList post){
        return plservice.save(post);
    }

    @RequestMapping("/findById/{id}")
    public PostList queryId(@PathVariable("id") Integer id){
        return plservice.getById(id);
    }

    @RequestMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id){
        return plservice.removeById(id);
    }

    @RequestMapping("/update")
    public boolean update(PostList post){
        return plservice.updateById(post);
    }

    @RequestMapping("/daochu")
    public ResponseEntity<byte []> downloadExcel() throws IOException {
        List<PostList> list = plservice.list();
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet();
        //导出excel头部
        Row rowTitle = sheet.createRow(0);
        Cell studentCodeTitle = rowTitle.createCell(0);
        Cell studentNameTitle = rowTitle.createCell(1);
        studentCodeTitle.setCellValue("岗位编号");
        studentNameTitle.setCellValue("岗位姓名");

        //组装导出的学生数据，如果是其他业务，请根据业务情况进行编写
        if(list!=null){
            for (int i = 0; i < list.size(); i++) {
                PostList stuValue = list.get(i);
                //导出excel数据
                Row rowValue = sheet.createRow(i+1);
                Cell studentCodeValue = rowValue.createCell(0);
                Cell studentNameValue = rowValue.createCell(1);
                studentCodeValue.setCellValue(stuValue.getGid());
                studentNameValue.setCellValue(stuValue.getGname());
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        book.write(byteArrayOutputStream);

        HttpHeaders headers = new HttpHeaders();
        //设置响应内容为文件流模式
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String fileName = new String("岗位导出数据.xlsx".getBytes("utf-8"),"iso-8859-1");
        //设置响应的文件的名称
        headers.setContentDispositionFormData("attachment",fileName);
        return new ResponseEntity(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);
    }
}

