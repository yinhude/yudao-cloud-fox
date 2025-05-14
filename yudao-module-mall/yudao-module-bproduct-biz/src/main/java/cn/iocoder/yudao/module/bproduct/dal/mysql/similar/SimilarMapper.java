package cn.iocoder.yudao.module.bproduct.dal.mysql.similar;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.similar.SimilarDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bproduct.controller.admin.similar.vo.*;

/**
 * 商品替代品 Mapper
 *
 * @author 合适连接器
 */
@Mapper
public interface SimilarMapper extends BaseMapperX<SimilarDO> {

    default PageResult<SimilarDO> selectPage(SimilarPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SimilarDO>()
                .eqIfPresent(SimilarDO::getRelationPn, reqVO.getRelationPn())
                .eqIfPresent(SimilarDO::getRelationId, reqVO.getRelationId())
                .eqIfPresent(SimilarDO::getProductId, reqVO.getProductId())
                .eqIfPresent(SimilarDO::getType, reqVO.getType())
                .betweenIfPresent(SimilarDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SimilarDO::getId));
    }

}