package com.accp.service.impl;

import com.accp.domain.MaintenanceItems;
import com.accp.mapper.MaintenanceItemsMapper;
import com.accp.service.IMaintenanceItemsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 维修项目表 服务实现类
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Service
public class MaintenanceItemsServiceImpl extends ServiceImpl<MaintenanceItemsMapper, MaintenanceItems> implements IMaintenanceItemsService {

}
