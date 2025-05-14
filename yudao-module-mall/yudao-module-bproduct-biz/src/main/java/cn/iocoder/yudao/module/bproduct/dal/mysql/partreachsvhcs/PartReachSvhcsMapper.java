package cn.iocoder.yudao.module.bproduct.dal.mysql.partreachsvhcs;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partreachsvhcs.PartReachSvhcsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bproduct.controller.admin.partreachsvhcs.vo.*;

/**
 * reach合规性 Mapper
 *
 * @author 合适连接器
 */
@Mapper
public interface PartReachSvhcsMapper extends BaseMapperX<PartReachSvhcsDO> {

    default PageResult<PartReachSvhcsDO> selectPage(PartReachSvhcsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PartReachSvhcsDO>()
                .eqIfPresent(PartReachSvhcsDO::getReachComplianceId, reqVO.getReachComplianceId())
                .likeIfPresent(PartReachSvhcsDO::getSvhcName, reqVO.getSvhcName())
                .betweenIfPresent(PartReachSvhcsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PartReachSvhcsDO::getId));
    }

}