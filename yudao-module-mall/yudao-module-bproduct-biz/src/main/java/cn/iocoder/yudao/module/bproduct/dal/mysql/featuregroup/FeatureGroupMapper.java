package cn.iocoder.yudao.module.bproduct.dal.mysql.featuregroup;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.featuregroup.FeatureGroupDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bproduct.controller.admin.featuregroup.vo.*;

/**
 * 特征值分组 Mapper
 *
 * @author 合适连接器
 */
@Mapper
public interface FeatureGroupMapper extends BaseMapperX<FeatureGroupDO> {

    default PageResult<FeatureGroupDO> selectPage(FeatureGroupPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FeatureGroupDO>()
                .eqIfPresent(FeatureGroupDO::getFeatureSourceId, reqVO.getFeatureSourceId())
                .eqIfPresent(FeatureGroupDO::getSort, reqVO.getSort())
                .eqIfPresent(FeatureGroupDO::getLabel, reqVO.getLabel())
                .betweenIfPresent(FeatureGroupDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(FeatureGroupDO::getId));
    }

}