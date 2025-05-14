package cn.iocoder.yudao.module.bproduct.service.thumbnailimages;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.thumbnailimages.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.thumbnailimages.ThumbnailImagesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 商品缩略图 Service 接口
 *
 * @author 合适连接器
 */
public interface ThumbnailImagesService {

    /**
     * 创建商品缩略图
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createThumbnailImages(@Valid ThumbnailImagesSaveReqVO createReqVO);

    /**
     * 更新商品缩略图
     *
     * @param updateReqVO 更新信息
     */
    void updateThumbnailImages(@Valid ThumbnailImagesSaveReqVO updateReqVO);

    /**
     * 删除商品缩略图
     *
     * @param id 编号
     */
    void deleteThumbnailImages(Long id);

    /**
     * 获得商品缩略图
     *
     * @param id 编号
     * @return 商品缩略图
     */
    ThumbnailImagesDO getThumbnailImages(Long id);

    /**
     * 获得商品缩略图分页
     *
     * @param pageReqVO 分页查询
     * @return 商品缩略图分页
     */
    PageResult<ThumbnailImagesDO> getThumbnailImagesPage(ThumbnailImagesPageReqVO pageReqVO);

}