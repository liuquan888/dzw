package com.accp.service.impl;

import com.accp.domain.Workcar;
import com.accp.mapper.WorkcarMapper;
import com.accp.service.IWorkcarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 工作中的车辆 服务实现类
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Service
public class WorkcarServiceImpl extends ServiceImpl<WorkcarMapper, Workcar> implements IWorkcarService {

}
