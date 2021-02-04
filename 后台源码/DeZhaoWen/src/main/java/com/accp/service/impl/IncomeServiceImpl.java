package com.accp.service.impl;

import com.accp.domain.Income;
import com.accp.mapper.IncomeMapper;
import com.accp.service.IIncomeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 收入种类 服务实现类
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Service
public class IncomeServiceImpl extends ServiceImpl<IncomeMapper, Income> implements IIncomeService {

}
