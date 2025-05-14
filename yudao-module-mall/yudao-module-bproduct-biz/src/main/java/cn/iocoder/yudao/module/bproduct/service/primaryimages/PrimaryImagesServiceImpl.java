package cn.iocoder.yudao.module.bproduct.service.primaryimages;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.primaryimages.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.primaryimages.PrimaryImagesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.bproduct.dal.mysql.primaryimages.PrimaryImagesMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bproduct.enums.ErrorCodeConstants.*;

/**
 * 商品主图 Service 实现类
 *
 * @author 合适连接器
 */
@Service
@Validated
public class PrimaryImagesServiceImpl implements PrimaryImagesService {

    @Resource
    private PrimaryImagesMapper primaryImagesMapper;

    @Override
    public Long createPrimaryImages(PrimaryImagesSaveReqVO createReqVO) {
        // 插入
        PrimaryImagesDO primaryImages = BeanUtils.toBean(createReqVO, PrimaryImagesDO.class);
        primaryImagesMapper.insert(primaryImages);
        // 返回
        return primaryImages.getId();
    }

    @Override
    public void updatePrimaryImages(PrimaryImagesSaveReqVO updateReqVO) {
        // 校验存在
        validatePrimaryImagesExists(updateReqVO.getId());
        // 更新
        PrimaryImagesDO updateObj = BeanUtils.toBean(updateReqVO, PrimaryImagesDO.class);
        primaryImagesMapper.updateById(updateObj);
    }

    @Override
    public void deletePrimaryImages(Long id) {
        // 校验存在
        validatePrimaryImagesExists(id);
        // 删除
        primaryImagesMapper.deleteById(id);
    }

    private void validatePrimaryImagesExists(Long id) {
        if (primaryImagesMapper.selectById(id) == null) {
            throw exception(PRIMARY_IMAGES_NOT_EXISTS);
        }
    }

    @Override
    public PrimaryImagesDO getPrimaryImages(Long id) {
        return primaryImagesMapper.selectById(id);
    }

    @Override
    public PageResult<PrimaryImagesDO> getPrimaryImagesPage(PrimaryImagesPageReqVO pageReqVO) {
        return primaryImagesMapper.selectPage(pageReqVO);
    }

}