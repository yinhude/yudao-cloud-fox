package cn.iocoder.yudao.module.bproduct.dal.mysql.thumbnailimages;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.thumbnailimages.ThumbnailImagesDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bproduct.controller.admin.thumbnailimages.vo.*;

/**
 * 商品缩略图 Mapper
 *
 * @author 合适连接器
 */
@Mapper
public interface ThumbnailImagesMapper extends BaseMapperX<ThumbnailImagesDO> {

    default PageResult<ThumbnailImagesDO> selectPage(ThumbnailImagesPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ThumbnailImagesDO>()
                .eqIfPresent(ThumbnailImagesDO::getProductId, reqVO.getProductId())
                .eqIfPresent(ThumbnailImagesDO::getPath, reqVO.getPath())
                .likeIfPresent(ThumbnailImagesDO::getImageName, reqVO.getImageName())
                .eqIfPresent(ThumbnailImagesDO::getUrl, reqVO.getUrl())
                .eqIfPresent(ThumbnailImagesDO::getMinioUrl, reqVO.getMinioUrl())
                .betweenIfPresent(ThumbnailImagesDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ThumbnailImagesDO::getId));
    }

}