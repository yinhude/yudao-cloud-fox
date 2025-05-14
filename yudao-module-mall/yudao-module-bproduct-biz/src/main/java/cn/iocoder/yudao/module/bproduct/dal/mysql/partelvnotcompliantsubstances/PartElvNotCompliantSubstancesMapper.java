package cn.iocoder.yudao.module.bproduct.dal.mysql.partelvnotcompliantsubstances;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partelvnotcompliantsubstances.PartElvNotCompliantSubstancesDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bproduct.controller.admin.partelvnotcompliantsubstances.vo.*;

/**
 * elv不合规含量子 Mapper
 *
 * @author 合适连接器
 */
@Mapper
public interface PartElvNotCompliantSubstancesMapper extends BaseMapperX<PartElvNotCompliantSubstancesDO> {

    default PageResult<PartElvNotCompliantSubstancesDO> selectPage(PartElvNotCompliantSubstancesPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PartElvNotCompliantSubstancesDO>()
                .eqIfPresent(PartElvNotCompliantSubstancesDO::getElvComplianceId, reqVO.getElvComplianceId())
                .likeIfPresent(PartElvNotCompliantSubstancesDO::getSubstanceName, reqVO.getSubstanceName())
                .betweenIfPresent(PartElvNotCompliantSubstancesDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PartElvNotCompliantSubstancesDO::getId));
    }

}