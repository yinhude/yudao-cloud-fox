package cn.iocoder.yudao.module.bproduct.dal.mysql.images;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.images.ImagesDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bproduct.controller.admin.images.vo.*;

/**
 * 图片 Mapper
 *
 * @author 合适连接器
 */
@Mapper
public interface ImagesMapper extends BaseMapperX<ImagesDO> {

    default PageResult<ImagesDO> selectPage(ImagesPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ImagesDO>()
                .eqIfPresent(ImagesDO::getProductId, reqVO.getProductId())
                .likeIfPresent(ImagesDO::getImageName, reqVO.getImageName())
                .eqIfPresent(ImagesDO::getImageUrl, reqVO.getImageUrl())
                .eqIfPresent(ImagesDO::getImageThumbnailUrl, reqVO.getImageThumbnailUrl())
                .eqIfPresent(ImagesDO::getMinioUrl, reqVO.getMinioUrl())
                .eqIfPresent(ImagesDO::getMinioThumbnailUrl, reqVO.getMinioThumbnailUrl())
                .betweenIfPresent(ImagesDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ImagesDO::getId));
    }

}