package com.accp.service;


import com.accp.domain.AlipayBean;
import com.alipay.api.AlipayApiException;

/*支付服务*/
public interface PayService {
    /*支付宝*/
    String aliPay(AlipayBean alipayBean) throws AlipayApiException;
}

