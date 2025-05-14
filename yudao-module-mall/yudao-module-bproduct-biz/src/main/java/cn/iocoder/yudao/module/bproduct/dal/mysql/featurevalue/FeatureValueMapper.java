package cn.iocoder.yudao.module.bproduct.dal.mysql.featurevalue;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.featurevalue.FeatureValueDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bproduct.controller.admin.featurevalue.vo.*;

/**
 * 特征值 Mapper
 *
 * @author 合适连接器
 */
@Mapper
public interface FeatureValueMapper extends BaseMapperX<FeatureValueDO> {

    default PageResult<FeatureValueDO> selectPage(FeatureValuePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FeatureValueDO>()
                .likeIfPresent(FeatureValueDO::getName, reqVO.getName())
                .eqIfPresent(FeatureValueDO::getDimValId, reqVO.getDimValId())
                .eqIfPresent(FeatureValueDO::getDisplayValue, reqVO.getDisplayValue())
                .eqIfPresent(FeatureValueDO::getPrimarySourceId, reqVO.getPrimarySourceId())
                .eqIfPresent(FeatureValueDO::getKeywords, reqVO.getKeywords())
                .eqIfPresent(FeatureValueDO::getValue, reqVO.getValue())
                .eqIfPresent(FeatureValueDO::getSystem, reqVO.getSystem())
                .eqIfPresent(FeatureValueDO::getUnit, reqVO.getUnit())
                .eqIfPresent(FeatureValueDO::getSort, reqVO.getSort())
                .betweenIfPresent(FeatureValueDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(FeatureValueDO::getId));
    }

}