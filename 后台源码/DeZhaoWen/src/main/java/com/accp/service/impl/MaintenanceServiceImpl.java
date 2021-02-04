package com.accp.service.impl;

import com.accp.domain.Maintenance;
import com.accp.mapper.MaintenanceMapper;
import com.accp.service.IMaintenanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 历史维修表 服务实现类
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Service
public class MaintenanceServiceImpl extends ServiceImpl<MaintenanceMapper, Maintenance> implements IMaintenanceService {

}
