package com.accp.service.impl;

import com.accp.domain.PostList;
import com.accp.mapper.PostListMapper;
import com.accp.service.IPostListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 岗位表 服务实现类
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Service
public class PostListServiceImpl extends ServiceImpl<PostListMapper, PostList> implements IPostListService {

}
