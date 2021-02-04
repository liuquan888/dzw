package com.accp.service.impl;

import com.accp.domain.Rating;
import com.accp.mapper.RatingMapper;
import com.accp.service.IRatingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品等级 服务实现类
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Service
public class RatingServiceImpl extends ServiceImpl<RatingMapper, Rating> implements IRatingService {

}
