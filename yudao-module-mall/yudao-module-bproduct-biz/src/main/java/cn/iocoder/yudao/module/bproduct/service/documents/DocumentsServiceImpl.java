package cn.iocoder.yudao.module.bproduct.service.documents;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.documents.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.documents.DocumentsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.bproduct.dal.mysql.documents.DocumentsMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bproduct.enums.ErrorCodeConstants.*;

/**
 * 文档 Service 实现类
 *
 * @author 合适连接器
 */
@Service
@Validated
public class DocumentsServiceImpl implements DocumentsService {

    @Resource
    private DocumentsMapper documentsMapper;

    @Override
    public Long createDocuments(DocumentsSaveReqVO createReqVO) {
        // 插入
        DocumentsDO documents = BeanUtils.toBean(createReqVO, DocumentsDO.class);
        documentsMapper.insert(documents);
        // 返回
        return documents.getId();
    }

    @Override
    public void updateDocuments(DocumentsSaveReqVO updateReqVO) {
        // 校验存在
        validateDocumentsExists(updateReqVO.getId());
        // 更新
        DocumentsDO updateObj = BeanUtils.toBean(updateReqVO, DocumentsDO.class);
        documentsMapper.updateById(updateObj);
    }

    @Override
    public void deleteDocuments(Long id) {
        // 校验存在
        validateDocumentsExists(id);
        // 删除
        documentsMapper.deleteById(id);
    }

    private void validateDocumentsExists(Long id) {
        if (documentsMapper.selectById(id) == null) {
            throw exception(DOCUMENTS_NOT_EXISTS);
        }
    }

    @Override
    public DocumentsDO getDocuments(Long id) {
        return documentsMapper.selectById(id);
    }

    @Override
    public PageResult<DocumentsDO> getDocumentsPage(DocumentsPageReqVO pageReqVO) {
        return documentsMapper.selectPage(pageReqVO);
    }

}