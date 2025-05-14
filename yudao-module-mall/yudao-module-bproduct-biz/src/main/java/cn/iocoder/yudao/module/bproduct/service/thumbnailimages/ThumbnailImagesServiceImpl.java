package cn.iocoder.yudao.module.bproduct.service.thumbnailimages;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.thumbnailimages.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.thumbnailimages.ThumbnailImagesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.bproduct.dal.mysql.thumbnailimages.ThumbnailImagesMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bproduct.enums.ErrorCodeConstants.*;

/**
 * 商品缩略图 Service 实现类
 *
 * @author 合适连接器
 */
@Service
@Validated
public class ThumbnailImagesServiceImpl implements ThumbnailImagesService {

    @Resource
    private ThumbnailImagesMapper thumbnailImagesMapper;

    @Override
    public Long createThumbnailImages(ThumbnailImagesSaveReqVO createReqVO) {
        // 插入
        ThumbnailImagesDO thumbnailImages = BeanUtils.toBean(createReqVO, ThumbnailImagesDO.class);
        thumbnailImagesMapper.insert(thumbnailImages);
        // 返回
        return thumbnailImages.getId();
    }

    @Override
    public void updateThumbnailImages(ThumbnailImagesSaveReqVO updateReqVO) {
        // 校验存在
        validateThumbnailImagesExists(updateReqVO.getId());
        // 更新
        ThumbnailImagesDO updateObj = BeanUtils.toBean(updateReqVO, ThumbnailImagesDO.class);
        thumbnailImagesMapper.updateById(updateObj);
    }

    @Override
    public void deleteThumbnailImages(Long id) {
        // 校验存在
        validateThumbnailImagesExists(id);
        // 删除
        thumbnailImagesMapper.deleteById(id);
    }

    private void validateThumbnailImagesExists(Long id) {
        if (thumbnailImagesMapper.selectById(id) == null) {
            throw exception(THUMBNAIL_IMAGES_NOT_EXISTS);
        }
    }

    @Override
    public ThumbnailImagesDO getThumbnailImages(Long id) {
        return thumbnailImagesMapper.selectById(id);
    }

    @Override
    public PageResult<ThumbnailImagesDO> getThumbnailImagesPage(ThumbnailImagesPageReqVO pageReqVO) {
        return thumbnailImagesMapper.selectPage(pageReqVO);
    }

}