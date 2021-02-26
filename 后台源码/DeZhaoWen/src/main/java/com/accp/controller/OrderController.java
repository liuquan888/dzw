package com.accp.controller;


import com.accp.domain.AlipayBean;
import com.accp.service.PayService;
import com.alipay.api.AlipayApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private PayService payService;
    @PostMapping(value = "alipay")
    public String alipay(String no,String price,String shuilu,String type) throws AlipayApiException {
        System.out.println(no+"  "+price+"   "+shuilu+"    "+type);
        String AA=payService.aliPay(new AlipayBean().setBody(type).setOut_trade_no(no)
                .setSubject(shuilu)
                .setTotal_amount(new StringBuffer().append(price))
        );
        if(AA==null){
            return "1";
        }else{
            return AA;
        }

    }
}
