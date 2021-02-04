package com.accp.service.impl;

import com.accp.domain.Platenumber;
import com.accp.mapper.PlatenumberMapper;
import com.accp.service.IPlatenumberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车牌表 服务实现类
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Service
public class PlatenumberServiceImpl extends ServiceImpl<PlatenumberMapper, Platenumber> implements IPlatenumberService {

}
