package com.accp.service.impl;


import com.accp.config.AlipayUtil;
import com.accp.domain.AlipayBean;
import com.accp.service.PayService;
import com.alipay.api.AlipayApiException;
import org.springframework.stereotype.Service;

/* 支付服务 */
@Service(value = "alipayOrderService")
public class PayServiceImpl implements PayService {
    @Override
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        return AlipayUtil.connect(alipayBean);
    }
}
