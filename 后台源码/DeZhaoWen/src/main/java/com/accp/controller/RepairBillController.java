package com.accp.controller;


import com.accp.domain.*;
import com.accp.service.impl.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

/**
 * <p>
 * 维修单据表 前端控制器
 * </p>
 *。
 * @author quanl
 * @since 2021-01-29
 */
@RestController
@RequestMapping("/repairBill")
public class RepairBillController {

    //维修单据Service
    @Autowired
    RepairBillServiceImpl service;

    //单据类型Service
    @Autowired
    BillstypeServiceImpl btService;

    //结算类型Service
    @Autowired
    ClearingFormServiceImpl cfService;

    //结算状态Service
    @Autowired
    SettlementStatusServiceImpl ssService;

    //单据状态Service
    @Autowired
    DocumentStatusServiceImpl dsService;

    //车牌Service
    @Autowired
    PlatenumberServiceImpl pService;

    //服务顾问Service
    @Autowired
    CounselorServiceImpl counService;

    @Autowired
    MaintenanceItemsServiceImpl miService;

    @Autowired
    GetMaterialServiceImpl gmService;
    //结算中心-查询（条件模糊查询）

    @Autowired
    ClearingServiceImpl cleService;

    @Autowired
    CarheetServiceImpl CarService;

    @Autowired
    FactoryServiceImpl fser;

    @RequestMapping("/find")
    @ResponseBody
    public List<RepairBill> find(String chejiaoNo,Integer[] ids, Integer documentsType, Integer balanceState, String date1, String date2, String no, Integer jsType, String chepaiNo, String name, Integer ywType, String remark, String jiesuanRen, Integer documentsState){
        if(ids!=null){
            for (Integer i:ids
            ) {
                System.out.println(i);
            }
        }
        QueryWrapper qw=new QueryWrapper<RepairBill>();
        if(chejiaoNo!=null){
            qw.like("chejiao_no",chejiaoNo);
        }
        if (date1!=null&&date2!=null){
            qw.between("completion_time",date1,date2);
        }

        if(no!=null){
            qw.like("no",no);
        }
        if(documentsType!=null){
            qw.eq("documents_type",documentsType);
        }
        if(jsType!=null){
            qw.eq("balanceState",jsType);
        }
        if(chepaiNo!=null){
            qw.like("chepaiNo",chepaiNo);
        }
        if (jiesuanRen!=null){
            qw.like("jiesuan_ren",jiesuanRen);
        }
        if(name!=null){
            qw.like("keihu_name",name);
        }
        if(ywType!=null){
            qw.eq("yewulx",ywType);
        }
        if(documentsState!=null){
            qw.eq("documents_state",documentsState);
        }
        if(remark!=null){
            qw.like("remark",remark);
        }

        if(balanceState!=null){
            qw.eq("balance_state",balanceState);
        }

        List<RepairBill> list = service.list(qw);

        for (RepairBill rb:list){
            if(rb.getDocumentsType()!=null){
                Billstype billstype=btService.getById(rb.getDocumentsType());
                rb.setDType(billstype.getType());
            }

            if(rb.getBalanceType()!=null){
                ClearingForm cf= cfService.getById(rb.getBalanceType());
                rb.setBType(cf.getType());
            }

            if(rb.getDocumentsState()!=null){
                SettlementStatus ss= ssService.getById(rb.getDocumentsState());
                rb.setBState(ss.getType());
            }

            if(rb.getBalanceState()!=null){
                DocumentStatus ds=dsService.getById(rb.getBalanceState());
                rb.setDState(ds.getType());
            }

            if(rb.getChepaiNo()!=null){
                Platenumber p=pService.getById(rb.getChepaiNo());
                rb.setChepai(p.getPlatename());
            }

            if(rb.getCounsellor()!=null){
                Counselor c= counService.getById(rb.getCounsellor());
                rb.setCoun(c.getCounselorname());
            }
        }
        return list;
    }


    @RequestMapping("/givemoney")
    public int givemoney(String no,Double sum){
        RepairBill bill=new RepairBill();
        bill.setNo(no);
        bill.setDocumentsState(1);
        bill.setAmount(sum);
        service.updateById(bill);
        return 1;
    }
    @RequestMapping("/findByCustomer/{qwe}")
    public List<RepairBill> findByCustomer(@PathVariable String qwe){
        QueryWrapper<RepairBill> queryWrapper=new QueryWrapper<>();
        if (qwe!=null){
            queryWrapper.eq("reserved1",qwe);
        }
        List<RepairBill> list=service.list(queryWrapper);
        for(int i=0;i<list.size();i++) {
            if(i==0) {
                list.get(i).setCheck(true);
            }else {
                list.get(i).setCheck(false);
            }
        }
        return list;
    }
    @RequestMapping("/find2")
    public  List<Billstype> find2(){
        return btService.list();
    }

    @RequestMapping("/find3")
    public  List<MaintenanceItems> find3(){
        return miService.list();
    }

    @RequestMapping("/find4")
    public  List<GetMaterial> find4(){
        return gmService.list();
    }

    @RequestMapping("/find5")
    public  List<Clearing> find5(){
        return cleService.list();
    }

    @RequestMapping("/findDay")
    public  List<GetMaterial> findday(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式

        QueryWrapper qw=new QueryWrapper<GetMaterial>();

        qw.eq("lingliaodate",df.format(new Date()));

        return gmService.list(qw);
    }

    @RequestMapping("/findCar")
    public  List<Carheet> findcar(){
        return CarService.list();
    }

    @RequestMapping("/findF")
    public List<Factory> findF(){ return fser.list(); }

    @RequestMapping("/findcarnum")
    public List<RepairBill> findcarnum(String number){
        QueryWrapper<RepairBill> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("chepai_no",number);
        return service.list(queryWrapper);
    }
    @RequestMapping("/findxx")
    @ResponseBody
    public List<RepairBill> findxx(@RequestBody Integer[] ids){
        QueryWrapper qw=new QueryWrapper<RepairBill>();
        qw.in("reserved1",ids);
        return service.list(qw);
    }
    //导出Excel
    @RequestMapping("/downloadExcel")
    public ResponseEntity<byte []> downloadExcel(Integer[] ids, Integer documentsType, Integer balanceState, String date1, String date2, String no, Integer jsType, String chepaiNo, String name, Integer ywType, String remark, String jiesuanRen, Integer documentsState) throws IOException {
        List<RepairBill> list=find(null,ids,documentsType,balanceState,date1,date2,no,jsType,chepaiNo,name,ywType,remark,jiesuanRen,documentsState);
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

        head1.setCellValue("销售单号");
        head2.setCellValue("单据类型");
        head3.setCellValue("支付方式");
        head4.setCellValue("结算时间");
        head5.setCellValue("客户名称");
        head6.setCellValue("车牌号");
        head7.setCellValue("联系电话");
        head8.setCellValue("赔款公司");
        head9.setCellValue("保险公司");

        //组装导出的学生数据，如果是其他业务，请根据业务情况进行编写
        if(list!=null){
            for (int i = 0; i < list.size(); i++) {
                RepairBill Value = list.get(i);
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
                data1.setCellValue(Value.getNo());
                data2.setCellValue(Value.getDType());
                data3.setCellValue(Value.getBType());
                data4.setCellValue(Value.getJiesuanTime());
                data5.setCellValue(Value.getKeihuName());
                data6.setCellValue(Value.getChepai());
                data7.setCellValue(Value.getPhone());
                data8.setCellValue(Value.getPkCompany());
                data9.setCellValue(Value.getBxCompany());

            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        book.write(byteArrayOutputStream);
        HttpHeaders headers = new HttpHeaders();
        //设置响应内容为文件流模式
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String fileName = new String("导出单据数据.xlsx".getBytes("utf-8"),"iso-8859-1");
        //设置响应的文件的名称
        headers.setContentDispositionFormData("attachment",fileName);
        return new ResponseEntity(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);
    }

    @RequestMapping("/qiantai")
    public Integer qiantai(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        QueryWrapper qw=new QueryWrapper<RepairBill>();
        qw.eq("reserved2",df.format(new Date()).toString());
        List<RepairBill> list=service.list(qw);
        Integer sum=0;
        for (RepairBill bill:list){
            sum=sum+ bill.getYugujine().intValue();
        }
        return sum;
    }

    @RequestMapping("/jiesuan")
    public Integer jiesuan(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        QueryWrapper qw=new QueryWrapper<RepairBill>();
        qw.eq("reserved2",df.format(new Date()).toString());
        List<RepairBill> list=service.list(qw);
        Integer sum=0;
        for (RepairBill bill:list){
            sum=sum+ bill.getAmount().intValue();
        }
        return sum;
    }

    @RequestMapping("/jieche")
    public Integer jieche(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        QueryWrapper qw=new QueryWrapper<RepairBill>();
        qw.eq("reserved2",df.format(new Date()).toString());
        List<RepairBill> list=service.list(qw);
        Integer sum=0;
        for (RepairBill bill:list){
            sum=sum+ 1;
        }
        return sum;
    }

    @RequestMapping("/jieTai")
    public Integer jieTai(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        QueryWrapper qw=new QueryWrapper<RepairBill>();
        qw.eq("reserved2",df.format(new Date()).toString());
        qw.eq("documents_state",1);
        List<RepairBill> list=service.list(qw);
        Integer sum=0;
        for (RepairBill bill:list){
            sum=sum+ 1;
        }
        return sum;
    }
}



