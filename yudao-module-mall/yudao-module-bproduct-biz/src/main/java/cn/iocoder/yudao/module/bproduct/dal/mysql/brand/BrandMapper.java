package cn.iocoder.yudao.module.bproduct.dal.mysql.brand;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.brand.BrandDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bproduct.controller.admin.brand.vo.*;

/**
 * 品牌 Mapper
 *
 * @author 合适连接器
 */
@Mapper
public interface BrandMapper extends BaseMapperX<BrandDO> {

    default PageResult<BrandDO> selectPage(BrandPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BrandDO>()
                .likeIfPresent(BrandDO::getName, reqVO.getName())
                .eqIfPresent(BrandDO::getFirstChar, reqVO.getFirstChar())
                .likeIfPresent(BrandDO::getOriginName, reqVO.getOriginName())
                .eqIfPresent(BrandDO::getOriginCode, reqVO.getOriginCode())
                .likeIfPresent(BrandDO::getShortName, reqVO.getShortName())
                .eqIfPresent(BrandDO::getUrl, reqVO.getUrl())
                .eqIfPresent(BrandDO::getPicUrl, reqVO.getPicUrl())
                .eqIfPresent(BrandDO::getSort, reqVO.getSort())
                .eqIfPresent(BrandDO::getKeywords, reqVO.getKeywords())
                .eqIfPresent(BrandDO::getDescription, reqVO.getDescription())
                .eqIfPresent(BrandDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(BrandDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BrandDO::getId));
    }

}