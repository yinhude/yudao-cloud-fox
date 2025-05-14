package cn.iocoder.yudao.module.bproduct.dal.mysql.documents;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.documents.DocumentsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bproduct.controller.admin.documents.vo.*;

/**
 * 文档 Mapper
 *
 * @author 合适连接器
 */
@Mapper
public interface DocumentsMapper extends BaseMapperX<DocumentsDO> {

    default PageResult<DocumentsDO> selectPage(DocumentsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<DocumentsDO>()
                .eqIfPresent(DocumentsDO::getProductId, reqVO.getProductId())
                .eqIfPresent(DocumentsDO::getType, reqVO.getType())
                .eqIfPresent(DocumentsDO::getRevision, reqVO.getRevision())
                .eqIfPresent(DocumentsDO::getFormat, reqVO.getFormat())
                .eqIfPresent(DocumentsDO::getLanguage, reqVO.getLanguage())
                .eqIfPresent(DocumentsDO::getTitle, reqVO.getTitle())
                .likeIfPresent(DocumentsDO::getName, reqVO.getName())
                .eqIfPresent(DocumentsDO::getLocalType, reqVO.getLocalType())
                .eqIfPresent(DocumentsDO::getRawFileSize, reqVO.getRawFileSize())
                .eqIfPresent(DocumentsDO::getDocNumber, reqVO.getDocNumber())
                .eqIfPresent(DocumentsDO::getLangCode, reqVO.getLangCode())
                .eqIfPresent(DocumentsDO::getViewableSize, reqVO.getViewableSize())
                .likeIfPresent(DocumentsDO::getFilename, reqVO.getFilename())
                .eqIfPresent(DocumentsDO::getUrl, reqVO.getUrl())
                .eqIfPresent(DocumentsDO::getMinioUrl, reqVO.getMinioUrl())
                .betweenIfPresent(DocumentsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(DocumentsDO::getId));
    }

}