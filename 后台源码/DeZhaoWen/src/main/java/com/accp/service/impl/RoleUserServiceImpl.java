package com.accp.service.impl;

import com.accp.domain.RoleUser;
import com.accp.mapper.RoleUserMapper;
import com.accp.service.IRoleUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色与用户中间表 服务实现类
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Service
public class RoleUserServiceImpl extends ServiceImpl<RoleUserMapper, RoleUser> implements IRoleUserService {

}
