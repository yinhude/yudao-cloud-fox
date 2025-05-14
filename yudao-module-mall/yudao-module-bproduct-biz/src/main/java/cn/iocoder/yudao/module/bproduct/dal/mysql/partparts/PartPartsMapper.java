package cn.iocoder.yudao.module.bproduct.dal.mysql.partparts;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partparts.PartPartsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bproduct.controller.admin.partparts.vo.*;

/**
 * part合规性 Mapper
 *
 * @author 合适连接器
 */
@Mapper
public interface PartPartsMapper extends BaseMapperX<PartPartsDO> {

    default PageResult<PartPartsDO> selectPage(PartPartsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PartPartsDO>()
                .eqIfPresent(PartPartsDO::getProductId, reqVO.getProductId())
                .eqIfPresent(PartPartsDO::getPartNum, reqVO.getPartNum())
                .eqIfPresent(PartPartsDO::getLeadFreeProcessCode, reqVO.getLeadFreeProcessCode())
                .eqIfPresent(PartPartsDO::getLeadFreeProcessDesc, reqVO.getLeadFreeProcessDesc())
                .eqIfPresent(PartPartsDO::getMaterialDeclarationIndicator, reqVO.getMaterialDeclarationIndicator())
                .betweenIfPresent(PartPartsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PartPartsDO::getId));
    }

}