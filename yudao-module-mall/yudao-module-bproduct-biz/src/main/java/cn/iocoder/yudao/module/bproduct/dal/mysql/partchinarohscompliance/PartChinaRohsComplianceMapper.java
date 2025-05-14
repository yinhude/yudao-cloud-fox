package cn.iocoder.yudao.module.bproduct.dal.mysql.partchinarohscompliance;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partchinarohscompliance.PartChinaRohsComplianceDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bproduct.controller.admin.partchinarohscompliance.vo.*;

/**
 * rohs Mapper
 *
 * @author 合适连接器
 */
@Mapper
public interface PartChinaRohsComplianceMapper extends BaseMapperX<PartChinaRohsComplianceDO> {

    default PageResult<PartChinaRohsComplianceDO> selectPage(PartChinaRohsCompliancePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PartChinaRohsComplianceDO>()
                .eqIfPresent(PartChinaRohsComplianceDO::getPartId, reqVO.getPartId())
                .eqIfPresent(PartChinaRohsComplianceDO::getEpupComplianceCode, reqVO.getEpupComplianceCode())
                .eqIfPresent(PartChinaRohsComplianceDO::getEpupComplianceDesc, reqVO.getEpupComplianceDesc())
                .eqIfPresent(PartChinaRohsComplianceDO::getEpupImageUrl, reqVO.getEpupImageUrl())
                .betweenIfPresent(PartChinaRohsComplianceDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PartChinaRohsComplianceDO::getId));
    }

}