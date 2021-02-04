package com.accp.service.impl;

import com.accp.domain.Brand;
import com.accp.mapper.BrandMapper;
import com.accp.service.IBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车型品牌 服务实现类
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

}
