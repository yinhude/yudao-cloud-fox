package cn.iocoder.yudao.module.bproduct.service.images;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.images.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.images.ImagesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.bproduct.dal.mysql.images.ImagesMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bproduct.enums.ErrorCodeConstants.*;

/**
 * 图片 Service 实现类
 *
 * @author 合适连接器
 */
@Service
@Validated
public class ImagesServiceImpl implements ImagesService {

    @Resource
    private ImagesMapper imagesMapper;

    @Override
    public Long createImages(ImagesSaveReqVO createReqVO) {
        // 插入
        ImagesDO images = BeanUtils.toBean(createReqVO, ImagesDO.class);
        imagesMapper.insert(images);
        // 返回
        return images.getId();
    }

    @Override
    public void updateImages(ImagesSaveReqVO updateReqVO) {
        // 校验存在
        validateImagesExists(updateReqVO.getId());
        // 更新
        ImagesDO updateObj = BeanUtils.toBean(updateReqVO, ImagesDO.class);
        imagesMapper.updateById(updateObj);
    }

    @Override
    public void deleteImages(Long id) {
        // 校验存在
        validateImagesExists(id);
        // 删除
        imagesMapper.deleteById(id);
    }

    private void validateImagesExists(Long id) {
        if (imagesMapper.selectById(id) == null) {
            throw exception(IMAGES_NOT_EXISTS);
        }
    }

    @Override
    public ImagesDO getImages(Long id) {
        return imagesMapper.selectById(id);
    }

    @Override
    public PageResult<ImagesDO> getImagesPage(ImagesPageReqVO pageReqVO) {
        return imagesMapper.selectPage(pageReqVO);
    }

}