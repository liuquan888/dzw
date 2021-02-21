package com.accp.service;

import com.accp.domain.Customer;
import com.accp.mapper.CustomerMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 客户表 服务类
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Service
@Transactional
public interface ICustomerService extends IService<Customer> {
}
