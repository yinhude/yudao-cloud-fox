package cn.iocoder.yudao.module.bproduct.dal.mysql.product;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.product.ProductDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bproduct.controller.admin.product.vo.*;

/**
 * 商品系列 Mapper
 *
 * @author 合适连接器
 */
@Mapper
public interface ProductMapper extends BaseMapperX<ProductDO> {

    default PageResult<ProductDO> selectPage(ProductPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProductDO>()
                .eqIfPresent(ProductDO::getOriginId, reqVO.getOriginId())
                .eqIfPresent(ProductDO::getImg, reqVO.getImg())
                .eqIfPresent(ProductDO::getPartType, reqVO.getPartType())
                .eqIfPresent(ProductDO::getBrandId, reqVO.getBrandId())
                .eqIfPresent(ProductDO::getSelfCategoryId, reqVO.getSelfCategoryId())
                .eqIfPresent(ProductDO::getParentCategoryId, reqVO.getParentCategoryId())
                .eqIfPresent(ProductDO::getDescription, reqVO.getDescription())
                .eqIfPresent(ProductDO::getFriendlyDescription, reqVO.getFriendlyDescription())
                .eqIfPresent(ProductDO::getTcpn, reqVO.getTcpn())
                .eqIfPresent(ProductDO::getElvCompliance, reqVO.getElvCompliance())
                .eqIfPresent(ProductDO::getProductOwningProfitCenter, reqVO.getProductOwningProfitCenter())
                .eqIfPresent(ProductDO::getReplacementProductExists, reqVO.getReplacementProductExists())
                .likeIfPresent(ProductDO::getAttributeName, reqVO.getAttributeName())
                .likeIfPresent(ProductDO::getBuName, reqVO.getBuName())
                .eqIfPresent(ProductDO::getSeriesId, reqVO.getSeriesId())
                .eqIfPresent(ProductDO::getFamilyId, reqVO.getFamilyId())
                .eqIfPresent(ProductDO::getRohsCompliance, reqVO.getRohsCompliance())
                .eqIfPresent(ProductDO::getMarketingPartNumber, reqVO.getMarketingPartNumber())
                .eqIfPresent(ProductDO::getMilspecNumber, reqVO.getMilspecNumber())
                .eqIfPresent(ProductDO::getMarketingPartNumNormalized, reqVO.getMarketingPartNumNormalized())
                .eqIfPresent(ProductDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ProductDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ProductDO::getId));
    }

}