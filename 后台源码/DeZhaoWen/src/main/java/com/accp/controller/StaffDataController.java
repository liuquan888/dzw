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
import org.springframework.web.multipart.MultipartFile;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
        String fileName = new String("员工导出数据.xlsx".getBytes("utf-8"),"iso-8859-1");
        //设置响应的文件的名称
        headers.setContentDispositionFormData("attachment",fileName);
        return new ResponseEntity(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);
    }

    @RequestMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        //将文件流转换成excel
        Workbook book = new XSSFWorkbook(file.getInputStream());
        //获取excel中有多个少个sheet页码
        int sheetNumber = book.getNumberOfSheets();
        //根据下标获取sheet页码
        Sheet sheet = book.getSheetAt(0);
        //获取excel中有多少行
        int rowNumber = sheet.getPhysicalNumberOfRows();
        List<StaffData> list = new ArrayList<>();
        for (int i = 1; i < rowNumber; i++) {
            Row row = sheet.getRow(i);//获取指定行
            Cell h1 = row.getCell(0);//获取行中的指定列
            Cell h2 = row.getCell(1);//获取行中的指定列
            Cell h3 = row.getCell(2);//获取行中的指定列
            Cell h4 = row.getCell(3);//获取行中的指定列
            Cell h5 = row.getCell(4);//获取行中的指定列
            Cell h6 = row.getCell(5);//获取行中的指定列
            Cell h7 = row.getCell(6);//获取行中的指定列
            Cell h8 = row.getCell(7);//获取行中的指定列
            Cell h9 = row.getCell(8);//获取行中的指定列
            Cell h10 = row.getCell(9);//获取行中的指定列
            Cell h11 = row.getCell(10);//获取行中的指定列
            Cell h12 = row.getCell(11);//获取行中的指定列
            Cell h13 = row.getCell(12);//获取行中的指定列
            Cell h14 = row.getCell(13);//获取行中的指定列
            Cell h15 = row.getCell(14);//获取行中的指定列
            Cell h16 = row.getCell(15);//获取行中的指定列
            Cell h17 = row.getCell(16);//获取行中的指定列
            Cell h18 = row.getCell(17);//获取行中的指定列
            Cell h19 = row.getCell(18);//获取行中的指定列
            Cell h20 = row.getCell(19);//获取行中的指定列
            Cell h21 = row.getCell(20);//获取行中的指定列
            Cell h22 = row.getCell(21);//获取行中的指定列
            Cell h23 = row.getCell(22);//获取行中的指定列
            Cell h24 = row.getCell(23);//获取行中的指定列
            Cell h25 = row.getCell(24);//获取行中的指定列
            Cell h26 = row.getCell(25);//获取行中的指定列
            Cell h27 = row.getCell(26);//获取行中的指定列
            Cell h28 = row.getCell(27);//获取行中的指定列
            Cell h29 = row.getCell(28);//获取行中的指定列
            Cell h30 = row.getCell(29);//获取行中的指定列
            Cell h31 = row.getCell(30);//获取行中的指定列
            Cell h32 = row.getCell(31);//获取行中的指定列
            Cell h33 = row.getCell(32);//获取行中的指定列
            Cell h34 = row.getCell(33);//获取行中的指定列
            Cell h35 = row.getCell(34);//获取行中的指定列
            Cell h36 = row.getCell(35);//获取行中的指定列
            Cell h37 = row.getCell(36);//获取行中的指定列
            Cell h38 = row.getCell(37);//获取行中的指定列
            Cell h39 = row.getCell(38);//获取行中的指定列
            Cell h40 = row.getCell(39);//获取行中的指定列
            Cell h41 = row.getCell(40);//获取行中的指定列
            Cell h42 = row.getCell(41);//获取行中的指定列
            Cell h43 = row.getCell(42);//获取行中的指定列
            Cell h44 = row.getCell(43);//获取行中的指定列
            Cell h45 = row.getCell(44);//获取行中的指定列
            Cell h46 = row.getCell(45);//获取行中的指定列
            Cell h47 = row.getCell(46);//获取行中的指定列
            Cell h48 = row.getCell(47);//获取行中的指定列
            Cell h49 = row.getCell(48);//获取行中的指定列
            Cell h50 = row.getCell(49);//获取行中的指定列
            Cell h51 = row.getCell(50);//获取行中的指定列
            Cell h52 = row.getCell(51);//获取行中的指定列
            Cell h53 = row.getCell(52);//获取行中的指定列
            Double a1 = h1.getNumericCellValue();
            String a2 = h2.getStringCellValue();
            String a3 = h3.getStringCellValue();
            String a4 = h4.getStringCellValue();
            String a5 = h5.getStringCellValue();
            String a6 = h6.getStringCellValue();
            Double a7 = h7.getNumericCellValue();
            Double a8 = h8.getNumericCellValue();
            Double a9 = h9.getNumericCellValue();
            Double a10 = h10.getNumericCellValue();
            Double a11 = h11.getNumericCellValue();
            Double a12 = h12.getNumericCellValue();
            Double a13 = h13.getNumericCellValue();
            Double a14 = h14.getNumericCellValue();
            String a15 = h15.getStringCellValue();
            Double a16 = h16.getNumericCellValue();
            Double a17 = h17.getNumericCellValue();
            String a18 = h18.getStringCellValue();
            String a19 = h19.getStringCellValue();
            String a20 = h20.getStringCellValue();
            String a21 = h21.getStringCellValue();
            String a22 = h22.getStringCellValue();
            String a23 = h23.getStringCellValue();
            Double a24 = h24.getNumericCellValue();
            String a25 = h25.getStringCellValue();
            String a26 = h26.getStringCellValue();
            String a27 = h27.getStringCellValue();
            String a28 = h28.getStringCellValue();
            String a29 = h29.getStringCellValue();
            String a30 = h30.getStringCellValue();
            String a31 = h31.getStringCellValue();
            String a32 = h32.getStringCellValue();
            String a33 = h33.getStringCellValue();

            Double a34 = h34.getNumericCellValue();
            Double a35 = h35.getNumericCellValue();
            Double a36 = h36.getNumericCellValue();
            Double a37 = h37.getNumericCellValue();
            Double a38 = h38.getNumericCellValue();
            Double a39 = h39.getNumericCellValue();

            String a40 = h40.getStringCellValue();
            String a41 = h41.getStringCellValue();
            String a42 = h42.getStringCellValue();
            Double a43 = h43.getNumericCellValue();
            Double a44 = h44.getNumericCellValue();
            String a45 = h45.getStringCellValue();
            String a46 = h46.getStringCellValue();
            String a47 = h47.getStringCellValue();
            String a48 = h48.getStringCellValue();
            String a49 = h49.getStringCellValue();
            String a50 = h50.getStringCellValue();
            String a51 = h51.getStringCellValue();
            String a52 = h52.getStringCellValue();
            String a53 = h53.getStringCellValue();
            StaffData student = new StaffData(a1.intValue(),a2,a3,a4,a5,a6,a7.intValue(),a8.intValue(),a9.intValue(),a10.intValue(),a11.intValue(),a12.intValue(),a13.intValue(),a14.intValue(),a15,a16.intValue(),a17.intValue(),a18,a19,a20,a21,a22,a23,a24.intValue(),a25,a26,a27,a28,a29,a30,a31,a32,a33,a34.floatValue(),a35.floatValue(),a36.floatValue(),a37.floatValue(),a38.floatValue(),a39.floatValue(),a40,a41,a42,a43.intValue(),a44.intValue(),a45,a46,a47,a48,a49,a50,a51,a52,a53);
            list.add(student);
        }
        sdService.saveBatch(list);
        return "success";
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(String templateName) throws IOException {
        InputStream is = this.getClass().getResourceAsStream("template/execel/"+templateName);
        byte[] bytes = new byte[is.available()];
        is.read(bytes);
        HttpHeaders headers = new HttpHeaders();
        //设置响应内容为文件流模式
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String fileName = new String("员工导出数据.xlsx".getBytes("utf-8"),"iso-8859-1");
        //设置响应的文件的名称
        headers.setContentDispositionFormData("attachment",fileName);
        return new ResponseEntity(bytes, headers, HttpStatus.OK);
    }

}

