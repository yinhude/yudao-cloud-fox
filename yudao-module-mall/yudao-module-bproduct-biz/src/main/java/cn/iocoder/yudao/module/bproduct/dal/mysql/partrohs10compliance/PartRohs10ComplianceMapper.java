package cn.iocoder.yudao.module.bproduct.dal.mysql.partrohs10compliance;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partrohs10compliance.PartRohs10ComplianceDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bproduct.controller.admin.partrohs10compliance.vo.*;

/**
 * rohs合规性 Mapper
 *
 * @author 合适连接器
 */
@Mapper
public interface PartRohs10ComplianceMapper extends BaseMapperX<PartRohs10ComplianceDO> {

    default PageResult<PartRohs10ComplianceDO> selectPage(PartRohs10CompliancePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PartRohs10ComplianceDO>()
                .eqIfPresent(PartRohs10ComplianceDO::getPartId, reqVO.getPartId())
                .eqIfPresent(PartRohs10ComplianceDO::getComplianceCode, reqVO.getComplianceCode())
                .eqIfPresent(PartRohs10ComplianceDO::getComplianceDescription, reqVO.getComplianceDescription())
                .eqIfPresent(PartRohs10ComplianceDO::getSelfDescribingDesc, reqVO.getSelfDescribingDesc())
                .eqIfPresent(PartRohs10ComplianceDO::getProductCategoryEn, reqVO.getProductCategoryEn())
                .eqIfPresent(PartRohs10ComplianceDO::getProductCategoryZh, reqVO.getProductCategoryZh())
                .betweenIfPresent(PartRohs10ComplianceDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PartRohs10ComplianceDO::getId));
    }

}