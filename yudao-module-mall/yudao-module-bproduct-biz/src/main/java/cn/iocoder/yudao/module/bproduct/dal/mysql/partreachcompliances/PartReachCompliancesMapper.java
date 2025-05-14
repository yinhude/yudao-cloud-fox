package cn.iocoder.yudao.module.bproduct.dal.mysql.partreachcompliances;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partreachcompliances.PartReachCompliancesDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bproduct.controller.admin.partreachcompliances.vo.*;

/**
 * reach合规性 Mapper
 *
 * @author 合适连接器
 */
@Mapper
public interface PartReachCompliancesMapper extends BaseMapperX<PartReachCompliancesDO> {

    default PageResult<PartReachCompliancesDO> selectPage(PartReachCompliancesPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PartReachCompliancesDO>()
                .eqIfPresent(PartReachCompliancesDO::getPartId, reqVO.getPartId())
                .eqIfPresent(PartReachCompliancesDO::getReachCmpl, reqVO.getReachCmpl())
                .betweenIfPresent(PartReachCompliancesDO::getCandidateDate, reqVO.getCandidateDate())
                .betweenIfPresent(PartReachCompliancesDO::getDeclarationDate, reqVO.getDeclarationDate())
                .eqIfPresent(PartReachCompliancesDO::getDeclarationCode, reqVO.getDeclarationCode())
                .eqIfPresent(PartReachCompliancesDO::getContainsReach, reqVO.getContainsReach())
                .eqIfPresent(PartReachCompliancesDO::getDeclDateFlag, reqVO.getDeclDateFlag())
                .eqIfPresent(PartReachCompliancesDO::getCandDateFlag, reqVO.getCandDateFlag())
                .betweenIfPresent(PartReachCompliancesDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PartReachCompliancesDO::getId));
    }

}