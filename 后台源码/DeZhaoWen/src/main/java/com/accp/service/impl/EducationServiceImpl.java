package com.accp.service.impl;

import com.accp.domain.Education;
import com.accp.mapper.EducationMapper;
import com.accp.service.IEducationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学历表 服务实现类
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Service
public class EducationServiceImpl extends ServiceImpl<EducationMapper, Education> implements IEducationService {

}
