package cn.iocoder.yudao.module.bproduct.service.documents;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.documents.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.documents.DocumentsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 文档 Service 接口
 *
 * @author 合适连接器
 */
public interface DocumentsService {

    /**
     * 创建文档
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createDocuments(@Valid DocumentsSaveReqVO createReqVO);

    /**
     * 更新文档
     *
     * @param updateReqVO 更新信息
     */
    void updateDocuments(@Valid DocumentsSaveReqVO updateReqVO);

    /**
     * 删除文档
     *
     * @param id 编号
     */
    void deleteDocuments(Long id);

    /**
     * 获得文档
     *
     * @param id 编号
     * @return 文档
     */
    DocumentsDO getDocuments(Long id);

    /**
     * 获得文档分页
     *
     * @param pageReqVO 分页查询
     * @return 文档分页
     */
    PageResult<DocumentsDO> getDocumentsPage(DocumentsPageReqVO pageReqVO);

}