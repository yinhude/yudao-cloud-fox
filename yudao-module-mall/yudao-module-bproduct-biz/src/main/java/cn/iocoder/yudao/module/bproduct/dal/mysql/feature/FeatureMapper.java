package cn.iocoder.yudao.module.bproduct.dal.mysql.feature;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.feature.FeatureDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bproduct.controller.admin.feature.vo.*;

/**
 * 特征 Mapper
 *
 * @author 合适连接器
 */
@Mapper
public interface FeatureMapper extends BaseMapperX<FeatureDO> {

    default PageResult<FeatureDO> selectPage(FeaturePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FeatureDO>()
                .eqIfPresent(FeatureDO::getOriginId, reqVO.getOriginId())
                .eqIfPresent(FeatureDO::getCode, reqVO.getCode())
                .eqIfPresent(FeatureDO::getDisplayValue, reqVO.getDisplayValue())
                .eqIfPresent(FeatureDO::getNumeric, reqVO.getNumeric())
                .eqIfPresent(FeatureDO::getFilterOnly, reqVO.getFilterOnly())
                .eqIfPresent(FeatureDO::getSort, reqVO.getSort())
                .eqIfPresent(FeatureDO::getAttributeType, reqVO.getAttributeType())
                .eqIfPresent(FeatureDO::getPrimaryFlag, reqVO.getPrimaryFlag())
                .eqIfPresent(FeatureDO::getPrimarySourceId, reqVO.getPrimarySourceId())
                .eqIfPresent(FeatureDO::getHelpInfoVailable, reqVO.getHelpInfoVailable())
                .eqIfPresent(FeatureDO::getUom, reqVO.getUom())
                .eqIfPresent(FeatureDO::getUiWidget, reqVO.getUiWidget())
                .eqIfPresent(FeatureDO::getShowInCompareView, reqVO.getShowInCompareView())
                .eqIfPresent(FeatureDO::getLabel, reqVO.getLabel())
                .eqIfPresent(FeatureDO::getType, reqVO.getType())
                .betweenIfPresent(FeatureDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(FeatureDO::getId));
    }

}