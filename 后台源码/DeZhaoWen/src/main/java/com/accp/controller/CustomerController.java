package com.accp.controller;


import com.accp.domain.*;
import com.accp.service.impl.CarheetServiceImpl;
import com.accp.service.impl.CounselorServiceImpl;
import com.accp.service.impl.CustomerServiceImpl;
import com.accp.service.impl.CustomertypeServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 客户表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerServiceImpl Service;

    @Autowired
    CarheetServiceImpl carservice;

    @Autowired
    CustomertypeServiceImpl typeservice;

    @Autowired
    CounselorServiceImpl counservice;
    @RequestMapping("/findcus")
    public List<Customer> findcus(){
        List<Customer> list=Service.list();
        if (list.size()>0){
            for (Customer cus:list){
                Customertype type=typeservice.getById(cus.getCustomertypeid());
                if (type!=null){
                    cus.setLeibie(type.getCustomertypeid());
                }
                Counselor con=counservice.getById(cus.getCounselorid());
                if (con!=null){
                    cus.setFw(con.getCounselorname());
                }
            }
        }
        return list;
    }
    @RequestMapping("/findX")
    public List<Customer> findX(@RequestBody Coll coll){
        QueryWrapper<Customer> queryWrapper=new QueryWrapper<>();
        QueryWrapper<Carheet>queryWrapper1=new QueryWrapper<>();
        if (coll!=null){
            if (coll.getClient()!=null){
                if (coll.getClient().getCustomernum()!=null){
                    queryWrapper.eq("customernum",coll.getClient().getCustomernum()).or();
                }
                if (coll.getClient().getCustomername()!=null){
                    queryWrapper.like("customername",coll.getClient().getCustomername()).or();
                }
                if (coll.getClient().getCustomertypeid()!=null){
                    queryWrapper.eq("customertypeid",coll.getClient().getCustomertypeid()).or();
                }
                if (coll.getClient().getLinkman()!=null){
                    queryWrapper.like("linkman",coll.getClient().getLinkman()).or();
                }
                if (coll.getClient().getPhone()!=null){
                    queryWrapper.like("phone",coll.getClient().getPhone()).or();
                }
                if (coll.getClient().getCustomeraddress()!=null){
                    queryWrapper.like("customeraddress",coll.getClient().getCustomeraddress()).or();
                }
                if (coll.getClient().getRemark()!=null){
                    queryWrapper.like("remark",coll.getClient().getRemark()).or();
                }
                if (coll.getClient().getBirthday()!=null){
                    queryWrapper.eq("birthady",coll.getClient().getBirthday()).or();
                }
                if (coll.getClient().getCounselorid()!=null){
                    queryWrapper.eq("counselorid",coll.getClient().getCounselorid()).or();
                }
                if (coll.getClient().getReserved4()!=null){
                    queryWrapper.eq("reserved4",coll.getClient().getReserved4()).or();
                }
                if (coll.getClient().getReserved1()!=null&&coll.getClient().getReserved2()!= null&&coll.getClient().getReserved3()!=null){
                    queryWrapper.eq("reserved1",coll.getClient().getReserved1()).or();
                }
            }
            if (coll.getCarInfo()!=null){
                if (coll.getCarInfo().getPlatename()!=null){

                    queryWrapper1.eq("platename",coll.getCarInfo().getPlatename());
                    List<Carheet> list=carservice.list(queryWrapper1);
                    if (list.size()>0){
                        for (Carheet car:list){
                            queryWrapper.eq("customernum",car.getCustomernum()).or().or();
                        }
                    }
                }
                if (coll.getCarInfo().getCarbrandid()!=null){
                    queryWrapper1.eq("carbrandid",coll.getCarInfo().getCarbrandid());
                    List<Carheet> list=carservice.list(queryWrapper1);
                    if (list.size()>0) {
                        for (Carheet car : list) {
                            queryWrapper.eq("customernum",car.getCustomernum()).or();
                        }
                    }
                }
                if (coll.getCarInfo().getReserved5()!=null){
                    queryWrapper1.eq("reserved5",coll.getCarInfo().getReserved5());
                    List<Carheet> list=carservice.list(queryWrapper1);
                    if (list.size()>0){
                        for (Carheet car:list){
                            queryWrapper.eq("customernum",car.getCustomernum()).or();
                        }
                    }
                }
                if (coll.getCarInfo().getFramnum()!=null){
                    queryWrapper1.eq("framnum",coll.getCarInfo().getFramnum());
                    List<Carheet> list=carservice.list(queryWrapper1);
                    if (list.size()>0){
                        for (Carheet car:list){
                            queryWrapper.eq("customernum",car.getCustomernum()).or();                    }
                    }
                }
                if (coll.getCarInfo().getEnginenum()!=null){
                    queryWrapper1.eq("enginenum",coll.getCarInfo().getEnginenum());
                    List<Carheet> list=carservice.list(queryWrapper1);
                    if (list.size()>0){
                        for (Carheet car:list){
                            queryWrapper.eq("customernum",car.getCustomernum()).or();                    }
                    }
                }
                if (coll.getCarInfo().getEngineid()!=null){
                    queryWrapper1.eq("engineid",coll.getCarInfo().getEngineid());
                    List<Carheet> list=carservice.list(queryWrapper1);
                    if (list.size()>0){
                        for (Carheet car:list){
                            queryWrapper.eq("customernum",car.getCustomernum()).or();                    }
                    }
                }
                if (coll.getCarInfo().getDriver()!=null){
                    queryWrapper1.eq("driver",coll.getCarInfo().getDriver());
                    List<Carheet> list=carservice.list(queryWrapper1);
                    if (list.size()>0){
                        for (Carheet car:list){
                            queryWrapper.eq("customernum",car.getCustomernum()).or();                    }
                    }
                }
                if (coll.getCarInfo().getDriverphone()!=null){
                    queryWrapper1.eq("driverphone",coll.getCarInfo().getDriverphone());
                    List<Carheet> list=carservice.list(queryWrapper1);
                    if (list.size()>0) {
                        for (Carheet car : list) {
                            queryWrapper.eq("customernum", car.getCustomernum()).or();
                        }
                    }
                }
                if (coll.getCarInfo().getBirthday()!=null){
                    queryWrapper1.eq("birthday",coll.getCarInfo().getBirthday());
                    List<Carheet> list=carservice.list(queryWrapper1);
                    if (list.size()>0){
                        for (Carheet car:list){
                            queryWrapper.eq("customernum",car.getCustomernum()).or();                    }
                    }
                }
            }
        }
        List<Customer> list=Service.list(queryWrapper);

            for (Customer cus:list){
                Customertype type=typeservice.getById(cus.getCustomertypeid());
                if (type!=null){
                    cus.setLeibie(type.getCustomertypeid());
                }
                Counselor con=counservice.getById(cus.getCounselorid());
                if (con!=null){
                    cus.setFw(con.getCounselorname());
                }
            }
        for(int i=0;i<list.size();i++) {
            if(i==0) {
                list.get(i).setCheck(true);
            }else {
                list.get(i).setCheck(false);
            }
        }

        return list;
    }
    @RequestMapping("/queryClientByNumber/{number}")
    public String queryClientByNumber(@PathVariable Integer number){
        QueryWrapper<Customer> queryWrappernew =new QueryWrapper<>();
        if (number!=null){
            queryWrappernew.eq("customernum",number);
        }
        List<Customer> list=Service.list(queryWrappernew);
        if (list.size()>0){
            return "1";
        }else {
            return "0";
        }
    }
    //根据ID查询
    @RequestMapping("/selectClientInformationByClientId/{customernum}")
    public Customer selectClientInformationByClientId(@PathVariable String customernum){
        QueryWrapper<Customer> queryWrappernew =new QueryWrapper<>();
        if (customernum!=null){
            queryWrappernew.eq("customernum",customernum);
        }
        List<Customer> list=Service.list(queryWrappernew);
        for (Customer cus:list){
            Customertype type=typeservice.getById(cus.getCustomertypeid());
            if (type!=null){
                cus.setLeibie(type.getCustomertypeid());
            }
            Counselor con=counservice.getById(cus.getCounselorid());
            if (con!=null){
                cus.setFw(con.getCounselorname());
            }
        }
        for(int i=0;i<list.size();i++) {
            if(i==0) {
                list.get(i).setCheck(true);
            }else {
                list.get(i).setCheck(false);
            }
        }
        System.out.println(list.size());
        return list.get(0);
    }
    @RequestMapping("/downloadExcel")
    public ResponseEntity<byte []> downloadExcel(Customer customer) throws IOException {
        QueryWrapper<Customer> query=new QueryWrapper<>();
        List<Customer> list=Service.list();
        for (Customer customer1:list) {
            if (customer1.getCustomertypeid()!=null){
                Integer id=Integer.valueOf(customer1.getCustomertypeid());
                System.out.print(id);
                Customertype type=typeservice.getById(id);
                customer1.setLeibie(type.getCustomertypeid());
            }
            if (customer1.getCounselorid()!=null) {
                Integer yid=customer1.getCounselorid();
                Counselor cou=counservice.getById(yid);
                customer1.setFw(cou.getCounselorname());
            }
        }
        Workbook book=new XSSFWorkbook();
        Sheet sheet=book.createSheet();
        Row rowTitle=sheet.createRow(0);
        Cell customerNum=rowTitle.createCell(0);
        Cell customerYname=rowTitle.createCell(1);
        Cell customerAddress=rowTitle.createCell(2);
        Cell customerLinkman=rowTitle.createCell(3);
        Cell customerPhone=rowTitle.createCell(4);
        Cell customerBirthday=rowTitle.createCell(5);
        Cell customertype=rowTitle.createCell(6);
        Cell customerNumber=rowTitle.createCell(7);
        Cell customerJointime=rowTitle.createCell(8);
        Cell customerOuttime=rowTitle.createCell(9);
        Cell customerRemark=rowTitle.createCell(10);
        Cell customerFiling=rowTitle.createCell(11);
        Cell customerCounselor=rowTitle.createCell(12);
        Cell customerYphonenumber=rowTitle.createCell(13);
        Cell customerPaytime=rowTitle.createCell(14);
        Cell customerPayment=rowTitle.createCell(15);
        Cell customerIntegral=rowTitle.createCell(16);
        Cell customerEarnest=rowTitle.createCell(17);
        Cell customerProvince=rowTitle.createCell(18);
        Cell customerCity=rowTitle.createCell(19);
        Cell customerArea=rowTitle.createCell(20);
        Cell customerPaytest=rowTitle.createCell(21);
        Cell customerRegisterphone=rowTitle.createCell(22);
        Cell customerDesportbank=rowTitle.createCell(23);
        Cell customerBankaccount=rowTitle.createCell(24);
        Cell customerRegisteraddress=rowTitle.createCell(25);
        Cell customerOtherone=rowTitle.createCell(26);
        Cell customerOthertwo=rowTitle.createCell(27);
        Cell customerOtherthree=rowTitle.createCell(28);
        Cell customerOtherfour=rowTitle.createCell(29);
        customerNum.setCellValue("客户编码");
        customerYname.setCellValue("客户名称");
        customerAddress.setCellValue("详细地址");
        customerLinkman.setCellValue("联系人");
        customerPhone.setCellValue("手机");
        customerBirthday.setCellValue("客户生日");
        customertype.setCellValue("客户类别");
        customerNumber.setCellValue("会员卡号");
        customerJointime.setCellValue("入会日期");
        customerOuttime.setCellValue("会员到期");
        customerRemark.setCellValue("备注");
        customerFiling.setCellValue("建档日期");
        customerCounselor.setCellValue("服务顾问");
        customerYphonenumber.setCellValue("业务员电话");
        customerPaytime.setCellValue("账期");
        customerPayment.setCellValue("挂账额度");
        customerIntegral.setCellValue("累计积分");
        customerEarnest.setCellValue("定金金额");
        customerProvince.setCellValue("客户省");
        customerCity.setCellValue("客户市");
        customerArea.setCellValue("客户区");
        customerPaytest.setCellValue("纳税人识别号");
        customerRegisterphone.setCellValue("注册电话");
        customerDesportbank.setCellValue("开户银行");
        customerBankaccount.setCellValue("银行账号");
        customerRegisteraddress.setCellValue("注册地址");
        customerOtherone.setCellValue("其他一");
        customerOthertwo.setCellValue("其他二");
        customerOtherthree.setCellValue("其他三");
        customerOtherfour.setCellValue("其他四");
        if(list!=null){
            for (int i=1;i<=list.size();i++){
                Customer c=list.get(i-1);
                Row rowValue=sheet.createRow(i);
                Cell customerValue=rowValue.createCell(0);
                Cell customerValueValue=rowValue.createCell(1);
                Cell customerAddressValue=rowValue.createCell(2);
                Cell customerLinkmanValue=rowValue.createCell(3);
                Cell customerPhoneValue=rowValue.createCell(4);
                Cell customerBirthdayValue=rowValue.createCell(5);
                Cell customertypeValue=rowValue.createCell(6);
                Cell customerNumberValue=rowValue.createCell(7);
                Cell customerJointimeValue=rowValue.createCell(8);
                Cell customerOuttimeValue=rowValue.createCell(9);
                Cell customerRemarkValue=rowValue.createCell(10);
                Cell customerFilingValue=rowValue.createCell(11);
                Cell customerCounselorValue=rowValue.createCell(12);
                Cell customerYphonenumberValue=rowValue.createCell(13);
                Cell customerPaytimeValue=rowValue.createCell(14);
                Cell customerPaymentValue=rowValue.createCell(15);
                Cell customerIntegralValue=rowValue.createCell(16);
                Cell customerEarnestValue=rowValue.createCell(17);
                Cell customerProvinceValue=rowValue.createCell(18);
                Cell customerCityValue=rowValue.createCell(19);
                Cell customerAreaValue=rowValue.createCell(20);
                Cell customerPaytestValue=rowValue.createCell(21);
                Cell customerRegisterphoneValue=rowValue.createCell(22);
                Cell customerDesportbankValue=rowValue.createCell(23);
                Cell customerBankaccountValue=rowValue.createCell(24);
                Cell customerRegisteraddressValue=rowValue.createCell(25);
                Cell customerOtheroneValue=rowValue.createCell(26);
                Cell customerOthertwoValue=rowValue.createCell(27);
                Cell customerOtherthreeValue=rowValue.createCell(28);
                Cell customerOtherfourValue=rowValue.createCell(29);
                customerValue.setCellValue(c.getCustomernum());
                customerProvinceValue.setCellValue(c.getReserved1());
                customerCityValue.setCellValue(c.getReserved2());
                customerAreaValue.setCellValue(c.getReserved3());
                customerValueValue.setCellValue(c.getCustomername());
                customerAddressValue.setCellValue(c.getCustomeraddress());
                customerLinkmanValue.setCellValue(c.getLinkman());
                customerPhoneValue.setCellValue(c.getPhone());
                customerBirthdayValue.setCellValue(c.getBirthday());
                if(c.getLeibie()!=null){
                    customertypeValue.setCellValue(c.getLeibie());
                }else{
                    customertypeValue.setCellValue("");
                }
                customerNumberValue.setCellValue(c.getCustomernumber());
                customerJointimeValue.setCellValue(c.getJointime());
                customerOuttimeValue.setCellValue(c.getOuttime());
                customerRemarkValue.setCellValue(c.getRemark());
                customerFilingValue.setCellValue(c.getFiling());
                if(c.getFw()!=null){
                    customerCounselorValue.setCellValue(c.getFw());
                }else{
                    customerCounselorValue.setCellValue("");
                }
                if(c.getFw()!=null){
                    customerYphonenumberValue.setCellValue(c.getReserved4());
                }else{
                    customerYphonenumberValue.setCellValue("");
                }
                if(c.getPaytime()!=null){
                    customerPaytimeValue.setCellValue(c.getPaytime());
                }else{
                    customerPaytimeValue.setCellValue("");
                }
                if(c.getPayment()!=null){
                    customerPaymentValue.setCellValue(c.getPayment());
                }else{
                    customerPaymentValue.setCellValue("");
                }
                if(c.getIntegral()!=null){
                    customerIntegralValue.setCellValue(c.getIntegral());
                }else{
                    customerIntegralValue.setCellValue("");
                }
                if(c.getEarnest()!=null){
                    customerEarnestValue.setCellValue(c.getEarnest());
                }else{
                    customerEarnestValue.setCellValue("");
                }
                customerProvinceValue.setCellValue("省");
                customerCityValue.setCellValue("市");
                customerAreaValue.setCellValue("区");
                if(c.getPaytest()!=null){
                    customerPaytestValue.setCellValue(c.getPaytest());
                }else{
                    customerPaytestValue.setCellValue("");
                }
                if(c.getRegisterphone()!=null){
                    customerRegisterphoneValue.setCellValue(c.getRegisterphone());
                }else{
                    customerRegisterphoneValue.setCellValue("");
                }
                if(c.getDesportbank()!=null){
                    customerDesportbankValue.setCellValue(c.getDesportbank());
                }else{
                    customerDesportbankValue.setCellValue("");
                }
                if(c.getBankaccount()!=null){
                    customerBankaccountValue.setCellValue(c.getBankaccount());
                }else{
                    customerBankaccountValue.setCellValue("");
                }
                if(c.getRegisteraddress()!=null){
                    customerRegisteraddressValue.setCellValue(c.getRegisteraddress());
                }else{
                    customerRegisteraddressValue.setCellValue("");
                }
                if(c.getOtherone()!=null){
                    customerOtheroneValue.setCellValue(c.getOtherone());
                }else{
                    customerOtheroneValue.setCellValue("");
                }
                if(c.getOthertwo()!=null){
                    customerOthertwoValue.setCellValue(c.getOthertwo());
                }else{
                    customerOthertwoValue.setCellValue("");
                }
                if(c.getOtherthree()!=null){
                    customerOtherthreeValue.setCellValue(c.getOtherthree());
                }else{
                    customerOtherthreeValue.setCellValue("");
                }
                if(c.getOtherfour()!=null){
                    customerOtherfourValue.setCellValue(c.getOtherfour());
                }else{
                    customerOtherfourValue.setCellValue("");
                }
            }
        }
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        book.write(byteArrayOutputStream);
        HttpHeaders headers=new HttpHeaders();
        //设置响应内容为文件流模式
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String fileName=new String("顾客导出数据".getBytes("utf-8"),"iso-8859-1");
        headers.setContentDispositionFormData("attachment",fileName);
        return new ResponseEntity(byteArrayOutputStream.toByteArray(),headers, HttpStatus.OK);
    }
    @RequestMapping("/findss")
    public Customer findss(Integer customernum){
        QueryWrapper<Customer> queryWrapper=new QueryWrapper<>();
        if (customernum!=null){
            queryWrapper.eq("customernum",customernum);
        }
        return Service.list(queryWrapper).get(0);
    }
    //根据条件查询客户信息(小)
    @RequestMapping("findTJ")
    public List<Customer> findTJ(String Tiaojian){
        QueryWrapper<Customer> queryWrapper=new QueryWrapper<>();
        if (Tiaojian!=null){
            queryWrapper.eq("customername",Tiaojian).or().eq("phone",Tiaojian).or().eq("customernumber",Tiaojian);
        }
        return Service.list(queryWrapper);
    }
    @RequestMapping("/selectClientInfo")
    public List<Customer> selectClientInfo(){
        List<Customer> list=Service.list();
        if (list.size()>0){
            for (Customer cus:list){
                Customertype type=typeservice.getById(cus.getCustomertypeid());
                if (type!=null){
                    cus.setLeibie(type.getCustomertypeid());
                }
                Counselor con=counservice.getById(cus.getCounselorid());
                if (con!=null){
                    cus.setFw(con.getCounselorname());
                }
            }
            for(int i=0;i<list.size();i++) {
                if(i==0) {
                    list.get(i).setCheck(true);
                }else {
                    list.get(i).setCheck(false);
                }
            }
        }
        return list;
    }
    @RequestMapping("/insertCustomerAndCarheet")
    public boolean insertCustomerAndCarheet(@RequestBody Coll coll){
        boolean bo=Service.save(coll.getClient());
        if (bo){
            return carservice.save(coll.getCarInfo());
        }else {
            return false;
        }
    }
    @RequestMapping("/findAll")
    public List<Customer> findAll(Customer cu) {
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        if (cu.getCustomernum() != null) {
            queryWrapper.eq("customernum", cu.getCustomernum());
        }
        if (cu.getCustomername() != null) {
            queryWrapper.like("customername", cu.getCustomername());
        }
        if (cu.getCustomeraddress() != null) {
            queryWrapper.like("customeraddress", cu.getCustomeraddress());
        }
        if (cu.getLinkman()!=null){
            queryWrapper.like("linkman",cu.getLinkman());
        }
        if(cu.getPhone()!=null){
            queryWrapper.like("linkman",cu.getPhone());
        }
        if(cu.getBirthday()!=null){
            queryWrapper.eq("birthday",cu.getBirthday());
        }
        if(cu.getCustomertypeid()!=null){
            queryWrapper.eq("customertypeid",cu.getCustomertypeid());
        }
        if (cu.getCustomernumber()!=null){
            queryWrapper.like("customernumber",cu.getCustomernumber());
        }
        if (cu.getRh1()!=null&&cu.getRh2()!=null){
            queryWrapper.between("jointime",cu.getRh1(),cu.getRh2());
        }
        if (cu.getDq1()!=null&&cu.getDq2()!=null){
            queryWrapper.between("outtime",cu.getDq1(),cu.getDq2());
        }
        if (cu.getRemark()!=null){
            queryWrapper.like("remark",cu.getRemark());
        }
        if (cu.getCounselorid()!=null){
            queryWrapper.eq("counselorid",cu.getCounselorid());
        }
        if (cu.getJe1()!=null&&cu.getJe2()!=null){
            queryWrapper.between("earnest",cu.getJe1(),cu.getJe2());
        }
        if (cu.getYe1()!=null&&cu.getYe2()!=null){
            queryWrapper.between("vipprice",cu.getYe1(),cu.getYe2());
        }
        if(cu.getJf1()!=null&&cu.getJf2()!=null){
            queryWrapper.between("integral",cu.getJf1(),cu.getJf2());
        }
        if (cu.getCar()!=null){
            if (cu.getCar().getDriver()!=null){
                QueryWrapper<Carheet> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.like("driver",cu.getCar().getDriver());
                List<Carheet> car=carservice.list(queryWrapper1);
                for (Carheet ca:car){
                    queryWrapper.eq("customernum",ca.getCustomernum());
                }
            }
            if (cu.getCar().getPlatename()!=null){
                QueryWrapper<Carheet> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.like("platename",cu.getCar().getPlatename());
                List<Carheet> car=carservice.list(queryWrapper1);
                for (Carheet ca:car){
                    queryWrapper.eq("customernum",ca.getCustomernum());
                }
            }
            if (cu.getCar().getEnginenum()!=null){
                QueryWrapper<Carheet> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.like("enginenum",cu.getCar().getEnginenum());
                List<Carheet> car=carservice.list(queryWrapper1);
                for (Carheet ca:car){
                    queryWrapper.eq("customernum",ca.getCustomernum());
                }
            }
            if (cu.getCar().getDriverphone()!=null){
                QueryWrapper<Carheet> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.like("driverphone",cu.getCar().getDriverphone());
                List<Carheet> car=carservice.list(queryWrapper1);
                for (Carheet ca:car){
                    queryWrapper.eq("customernum",ca.getCustomernum());
                }
            }
            if (cu.getCar().getJq1()!=null&&cu.getCar().getJq2()!=null){
                QueryWrapper<Carheet> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.between("mliouttime",cu.getCar().getJq1(),cu.getCar().getJq2());
                List<Carheet> car=carservice.list(queryWrapper1);
                for (Carheet ca:car){
                    queryWrapper.eq("customernum",ca.getCustomernum());
                }
            }
            if (cu.getCar().getSy1()!=null&&cu.getCar().getSy2()!=null){
                QueryWrapper<Carheet> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.between("ciouttime",cu.getCar().getSy1(),cu.getCar().getSy2());
                List<Carheet> car=carservice.list(queryWrapper1);
                for (Carheet ca:car){
                    queryWrapper.eq("customernum",ca.getCustomernum());
                }
            }
            if (cu.getCar().getSp1()!=null&&cu.getCar().getSp2()!=null){
                QueryWrapper<Carheet> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.between("uptime",cu.getCar().getSp1(),cu.getCar().getSp2());
                List<Carheet> car=carservice.list(queryWrapper1);
                for (Carheet ca:car){
                    queryWrapper.eq("customernum",ca.getCustomernum());
                }
            }
            if (cu.getCar().getGm1()!=null&&cu.getCar().getGm2()!=null){
                QueryWrapper<Carheet> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.between("buytime",cu.getCar().getGm1(),cu.getCar().getGm2());
                List<Carheet> car=carservice.list(queryWrapper1);
                for (Carheet ca:car){
                    queryWrapper.eq("customernum",ca.getCustomernum());
                }
            }
            if (cu.getCar().getCarbrandid()!=null){
                QueryWrapper<Carheet> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.eq("carbrandid",cu.getCar().getCarbrandid());
                List<Carheet> car=carservice.list(queryWrapper1);
                for (Carheet ca:car){
                    queryWrapper.eq("customernum",ca.getCustomernum());
                }
            }
            if (cu.getCar().getFramnum()!=null){
                QueryWrapper<Carheet> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.like("framnum",cu.getCar().getCarbrandid());
                List<Carheet> car=carservice.list(queryWrapper1);
                for (Carheet ca:car){
                    queryWrapper.eq("customernum",ca.getCustomernum());
                }
            }
            if (cu.getCar().getEngineid()!=null){
                QueryWrapper<Carheet> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.like("engineid",cu.getCar().getEngineid());
                List<Carheet> car=carservice.list(queryWrapper1);
                for (Carheet ca:car){
                    queryWrapper.eq("customernum",ca.getCustomernum());
                }
            }
        }
        List<Customer> list=Service.list(queryWrapper);
        for (Customer cus:list){
            if (cus.getCustomertypeid()!=null){
                Customertype type=typeservice.getById(cus.getCustomertypeid());
                cus.setLeibie(type.getCustomertypeid());
            }
            if (cus.getCounselorid()!=null) {
                Counselor cou = counservice.getById(cus.getCounselorid());
                cus.setFw(cou.getCounselorname());
            }
        }
        return list;
    }
    @RequestMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){

        QueryWrapper<Carheet> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("customernum",id);
        boolean bo=carservice.remove(queryWrapper);

        if (bo){
            boolean bool=Service.removeById(id);
            return bool;
        }else {
            return false;
        }
    }
    @RequestMapping("/findMax")
    public Customer findMax(){
        QueryWrapper<Customer> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("customernum");

        return Service.list(queryWrapper).get(0);
    }
    @RequestMapping("/insert")
    public boolean insert(@RequestBody Customer cus){
        boolean bool=Service.save(cus);
        return bool;
    }
    @RequestMapping("/finds")
    public List<Customer> finds(){
        return Service.list();
    }
    @RequestMapping("/update")
    public boolean update(@RequestBody Customer cus){
        QueryWrapper<Customer> queryWrapper=new QueryWrapper<>();
        System.out.printf(cus.getCustomernum());
        if (cus!=null){
            if (cus.getCustomernum()!=null){
                queryWrapper.eq("customernum",cus.getCustomernum());
            }
        }
        return Service.update(cus,queryWrapper);
    }
    @RequestMapping("/findById/{id}")
    public Customer findById(@PathVariable String id){
        return Service.getById(id);
    }



    //马威书写（以下）
    @RequestMapping("/find")
    public List<Customer> find(String data1,String  data2,String customernumber,String phone,String customername,String bankaccount,String remark){
        QueryWrapper qw=new QueryWrapper<Customer>();
        if(data1!=null && data2!=null){
            qw.between("jointime",data1,data2);
        }
        if(customernumber!=null){
            qw.like("customernumber",customernumber);
        }
        if(phone!=null){
            qw.like("phone",phone);
        }
        if(customername!=null){
            qw.like("customername",customername);
        }
        if(bankaccount!=null){
            qw.like("bankaccount",bankaccount);
        }
        if(remark!=null){
            qw.like("remark",remark);
        }
        List<Customer> list=Service.list(qw);
        return list;
    }
    @RequestMapping("/pay")
    public Integer pay(String id,Integer money){
        Customer c=Service.getById(id);
        Customer customer=new Customer();
        customer.setCustomernum(id);
        if(c.getVipprice()!=null){
            customer.setVipprice(c.getVipprice()+money);
        }else{
            customer.setVipprice(Float.valueOf(money));
        }
        boolean b = Service.updateById(customer);
        if(b)
            return 0000;
        else
            return 0100;
    }
}

