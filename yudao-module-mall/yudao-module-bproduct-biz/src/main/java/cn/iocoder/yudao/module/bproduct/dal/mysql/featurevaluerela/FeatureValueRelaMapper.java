package cn.iocoder.yudao.module.bproduct.dal.mysql.featurevaluerela;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.featurevaluerela.FeatureValueRelaDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bproduct.controller.admin.featurevaluerela.vo.*;

/**
 * 特征值关联 Mapper
 *
 * @author 合适连接器
 */
@Mapper
public interface FeatureValueRelaMapper extends BaseMapperX<FeatureValueRelaDO> {

    default PageResult<FeatureValueRelaDO> selectPage(FeatureValueRelaPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FeatureValueRelaDO>()
                .eqIfPresent(FeatureValueRelaDO::getRelationId, reqVO.getRelationId())
                .eqIfPresent(FeatureValueRelaDO::getProductId, reqVO.getProductId())
                .eqIfPresent(FeatureValueRelaDO::getType, reqVO.getType())
                .betweenIfPresent(FeatureValueRelaDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(FeatureValueRelaDO::getId));
    }

}