package cn.iocoder.yudao.module.bproduct.dal.mysql.featurevaluecategoryrela;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.featurevaluecategoryrela.FeatureValueCategoryRelaDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bproduct.controller.admin.featurevaluecategoryrela.vo.*;

/**
 * 特征值关联 Mapper
 *
 * @author 合适连接器
 */
@Mapper
public interface FeatureValueCategoryRelaMapper extends BaseMapperX<FeatureValueCategoryRelaDO> {

    default PageResult<FeatureValueCategoryRelaDO> selectPage(FeatureValueCategoryRelaPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FeatureValueCategoryRelaDO>()
                .eqIfPresent(FeatureValueCategoryRelaDO::getRelationId, reqVO.getRelationId())
                .eqIfPresent(FeatureValueCategoryRelaDO::getProductId, reqVO.getProductId())
                .eqIfPresent(FeatureValueCategoryRelaDO::getType, reqVO.getType())
                .betweenIfPresent(FeatureValueCategoryRelaDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(FeatureValueCategoryRelaDO::getId));
    }

}