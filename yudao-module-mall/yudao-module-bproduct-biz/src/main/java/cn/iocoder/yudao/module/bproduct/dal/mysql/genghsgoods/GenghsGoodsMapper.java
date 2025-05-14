package cn.iocoder.yudao.module.bproduct.dal.mysql.genghsgoods;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.genghsgoods.GenghsGoodsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bproduct.controller.admin.genghsgoods.vo.*;

/**
 * 脚本抓取控制 Mapper
 *
 * @author 合适连接器
 */
@Mapper
public interface GenghsGoodsMapper extends BaseMapperX<GenghsGoodsDO> {

    default PageResult<GenghsGoodsDO> selectPage(GenghsGoodsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GenghsGoodsDO>()
                .eqIfPresent(GenghsGoodsDO::getPn, reqVO.getPn())
                .eqIfPresent(GenghsGoodsDO::getStatus, reqVO.getStatus())
                .eqIfPresent(GenghsGoodsDO::getBrandId, reqVO.getBrandId())
                .betweenIfPresent(GenghsGoodsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(GenghsGoodsDO::getId));
    }

}