package com.accp.service.impl;

import com.accp.domain.DocumentStatus;
import com.accp.mapper.DocumentStatusMapper;
import com.accp.service.IDocumentStatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 单据状态表 服务实现类
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Service
public class DocumentStatusServiceImpl extends ServiceImpl<DocumentStatusMapper, DocumentStatus> implements IDocumentStatusService {

}
