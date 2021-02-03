package com.accp.service.impl;

import com.accp.domain.History;
import com.accp.mapper.HistoryMapper;
import com.accp.service.IHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 历史回访表 服务实现类
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Service
public class HistoryServiceImpl extends ServiceImpl<HistoryMapper, History> implements IHistoryService {

}
