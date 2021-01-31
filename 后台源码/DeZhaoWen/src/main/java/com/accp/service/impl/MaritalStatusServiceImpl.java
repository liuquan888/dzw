package com.accp.service.impl;

import com.accp.domain.MaritalStatus;
import com.accp.mapper.MaritalStatusMapper;
import com.accp.service.IMaritalStatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 婚姻状态表 服务实现类
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Service
public class MaritalStatusServiceImpl extends ServiceImpl<MaritalStatusMapper, MaritalStatus> implements IMaritalStatusService {

}
