package cn.iocoder.yudao.module.bproduct.dal.mysql.category;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.category.CategoryDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bproduct.controller.admin.category.vo.*;

/**
 * 商品系列 Mapper
 *
 * @author 合适连接器
 */
@Mapper
public interface CategoryMapper extends BaseMapperX<CategoryDO> {

    default List<CategoryDO> selectList(CategoryListReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<CategoryDO>()
                .eqIfPresent(CategoryDO::getBrandId, reqVO.getBrandId())
                .eqIfPresent(CategoryDO::getParentId, reqVO.getParentId())
                .eqIfPresent(CategoryDO::getOriginId, reqVO.getOriginId())
                .likeIfPresent(CategoryDO::getName, reqVO.getName())
                .likeIfPresent(CategoryDO::getShortName, reqVO.getShortName())
                .eqIfPresent(CategoryDO::getTitle, reqVO.getTitle())
                .eqIfPresent(CategoryDO::getFacet, reqVO.getFacet())
                .eqIfPresent(CategoryDO::getLevel, reqVO.getLevel())
                .eqIfPresent(CategoryDO::getCategoryPicUrl, reqVO.getCategoryPicUrl())
                .eqIfPresent(CategoryDO::getType, reqVO.getType())
                .eqIfPresent(CategoryDO::getSort, reqVO.getSort())
                .eqIfPresent(CategoryDO::getDescription, reqVO.getDescription())
                .eqIfPresent(CategoryDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(CategoryDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CategoryDO::getId));
    }


    default PageResult<CategoryDO> selectPage(CategoryPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CategoryDO>()
                .eqIfPresent(CategoryDO::getBrandId, reqVO.getBrandId())
                .eqIfPresent(CategoryDO::getParentId, reqVO.getParentId())
                .eqIfPresent(CategoryDO::getOriginId, reqVO.getOriginId())
                .likeIfPresent(CategoryDO::getName, reqVO.getName())
                .likeIfPresent(CategoryDO::getShortName, reqVO.getShortName())
                .eqIfPresent(CategoryDO::getTitle, reqVO.getTitle())
                .eqIfPresent(CategoryDO::getFacet, reqVO.getFacet())
                .eqIfPresent(CategoryDO::getLevel, reqVO.getLevel())
                .eqIfPresent(CategoryDO::getCategoryPicUrl, reqVO.getCategoryPicUrl())
                .eqIfPresent(CategoryDO::getType, reqVO.getType())
                .eqIfPresent(CategoryDO::getSort, reqVO.getSort())
                .eqIfPresent(CategoryDO::getDescription, reqVO.getDescription())
                .eqIfPresent(CategoryDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(CategoryDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CategoryDO::getId));
    }


    default CategoryDO selectByParentIdAndName(Long parentId, String name) {
	    return selectOne(CategoryDO::getParentId, parentId, CategoryDO::getName, name);
	}

    default Long selectCountByParentId(Long parentId) {
        return selectCount(CategoryDO::getParentId, parentId);
    }

}