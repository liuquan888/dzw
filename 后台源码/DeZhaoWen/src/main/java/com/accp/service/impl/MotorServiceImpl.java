package com.accp.service.impl;

import com.accp.domain.Motor;
import com.accp.mapper.MotorMapper;
import com.accp.service.IMotorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 发动机表 服务实现类
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Service
public class MotorServiceImpl extends ServiceImpl<MotorMapper, Motor> implements IMotorService {

}
