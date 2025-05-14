package cn.iocoder.yudao.module.bproduct.dal.mysql.partrohs10notcompliantsubstances;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.bproduct.controller.admin.partrohs10notcompliantsubstances.vo.PartRohs10NotCompliantSubstancesPageReqVO;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partrohs10notcompliantsubstances.PartRohs10NotCompliantSubstancesDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * rohs不符合的含量 Mapper
 *
 * @author 合适连接器
 */
@Mapper
public interface PartRohs10NotCompliantSubstancesMapper extends BaseMapperX<PartRohs10NotCompliantSubstancesDO> {

    default PageResult<PartRohs10NotCompliantSubstancesDO> selectPage(PartRohs10NotCompliantSubstancesPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PartRohs10NotCompliantSubstancesDO>()
                .eqIfPresent(PartRohs10NotCompliantSubstancesDO::getRohs10ComplianceId, reqVO.getRohs10ComplianceId())
                .likeIfPresent(PartRohs10NotCompliantSubstancesDO::getSubstanceName, reqVO.getSubstanceName())
                .eqIfPresent(PartRohs10NotCompliantSubstancesDO::getContainsSubstance, reqVO.getContainsSubstance())
                .betweenIfPresent(PartRohs10NotCompliantSubstancesDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PartRohs10NotCompliantSubstancesDO::getId));
    }

}