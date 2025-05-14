package cn.iocoder.yudao.module.bproduct.dal.mysql.selfproductcategoryrela;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.selfproductcategoryrela.SelfProductCategoryRelaDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bproduct.controller.admin.selfproductcategoryrela.vo.*;

/**
 * 产品和自有分类的关联性 Mapper
 *
 * @author 合适连接器
 */
@Mapper
public interface SelfProductCategoryRelaMapper extends BaseMapperX<SelfProductCategoryRelaDO> {

    default PageResult<SelfProductCategoryRelaDO> selectPage(SelfProductCategoryRelaPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SelfProductCategoryRelaDO>()
                .eqIfPresent(SelfProductCategoryRelaDO::getRelationId, reqVO.getRelationId())
                .eqIfPresent(SelfProductCategoryRelaDO::getProductId, reqVO.getProductId())
                .eqIfPresent(SelfProductCategoryRelaDO::getType, reqVO.getType())
                .betweenIfPresent(SelfProductCategoryRelaDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SelfProductCategoryRelaDO::getId));
    }

}