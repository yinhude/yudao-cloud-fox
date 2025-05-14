package cn.iocoder.yudao.module.bproduct.dal.mysql.primaryimages;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.primaryimages.PrimaryImagesDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bproduct.controller.admin.primaryimages.vo.*;

/**
 * 商品主图 Mapper
 *
 * @author 合适连接器
 */
@Mapper
public interface PrimaryImagesMapper extends BaseMapperX<PrimaryImagesDO> {

    default PageResult<PrimaryImagesDO> selectPage(PrimaryImagesPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PrimaryImagesDO>()
                .eqIfPresent(PrimaryImagesDO::getProductId, reqVO.getProductId())
                .eqIfPresent(PrimaryImagesDO::getPath, reqVO.getPath())
                .likeIfPresent(PrimaryImagesDO::getImageName, reqVO.getImageName())
                .eqIfPresent(PrimaryImagesDO::getUrl, reqVO.getUrl())
                .eqIfPresent(PrimaryImagesDO::getMinioUrl, reqVO.getMinioUrl())
                .betweenIfPresent(PrimaryImagesDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PrimaryImagesDO::getId));
    }

}