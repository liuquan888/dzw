package com.accp.service.impl;

import com.accp.domain.Service;
import com.accp.mapper.ServiceMapper;
import com.accp.service.IServiceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 维修项目菜单 服务实现类
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Service
public class ServiceServiceImpl extends ServiceImpl<ServiceMapper, Service> implements IServiceService {

}
