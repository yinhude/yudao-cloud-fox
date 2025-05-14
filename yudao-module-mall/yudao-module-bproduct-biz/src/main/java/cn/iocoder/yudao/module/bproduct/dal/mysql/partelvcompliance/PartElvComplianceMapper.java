package cn.iocoder.yudao.module.bproduct.dal.mysql.partelvcompliance;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partelvcompliance.PartElvComplianceDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bproduct.controller.admin.partelvcompliance.vo.*;

/**
 * elv合规数据 Mapper
 *
 * @author 合适连接器
 */
@Mapper
public interface PartElvComplianceMapper extends BaseMapperX<PartElvComplianceDO> {

    default PageResult<PartElvComplianceDO> selectPage(PartElvCompliancePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PartElvComplianceDO>()
                .eqIfPresent(PartElvComplianceDO::getPartId, reqVO.getPartId())
                .eqIfPresent(PartElvComplianceDO::getComplianceCode, reqVO.getComplianceCode())
                .eqIfPresent(PartElvComplianceDO::getComplianceDescription, reqVO.getComplianceDescription())
                .eqIfPresent(PartElvComplianceDO::getSelfDescribingDesc, reqVO.getSelfDescribingDesc())
                .betweenIfPresent(PartElvComplianceDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PartElvComplianceDO::getId));
    }

}