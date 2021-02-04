package com.accp.service.impl;

import com.accp.domain.UserCompany;
import com.accp.mapper.UserCompanyMapper;
import com.accp.service.IUserCompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户公司定义表 服务实现类
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Service
public class UserCompanyServiceImpl extends ServiceImpl<UserCompanyMapper, UserCompany> implements IUserCompanyService {

}
