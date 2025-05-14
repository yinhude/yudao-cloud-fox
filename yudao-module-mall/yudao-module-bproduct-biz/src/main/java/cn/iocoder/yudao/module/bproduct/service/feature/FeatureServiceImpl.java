package cn.iocoder.yudao.module.bproduct.service.feature;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.feature.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.feature.FeatureDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.bproduct.dal.mysql.feature.FeatureMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bproduct.enums.ErrorCodeConstants.*;

/**
 * 特征 Service 实现类
 *
 * @author 合适连接器
 */
@Service
@Validated
public class FeatureServiceImpl implements FeatureService {

    @Resource
    private FeatureMapper featureMapper;

    @Override
    public Long createFeature(FeatureSaveReqVO createReqVO) {
        // 插入
        FeatureDO feature = BeanUtils.toBean(createReqVO, FeatureDO.class);
        featureMapper.insert(feature);
        // 返回
        return feature.getId();
    }

    @Override
    public void updateFeature(FeatureSaveReqVO updateReqVO) {
        // 校验存在
        validateFeatureExists(updateReqVO.getId());
        // 更新
        FeatureDO updateObj = BeanUtils.toBean(updateReqVO, FeatureDO.class);
        featureMapper.updateById(updateObj);
    }

    @Override
    public void deleteFeature(Long id) {
        // 校验存在
        validateFeatureExists(id);
        // 删除
        featureMapper.deleteById(id);
    }

    private void validateFeatureExists(Long id) {
        if (featureMapper.selectById(id) == null) {
            throw exception(FEATURE_NOT_EXISTS);
        }
    }

    @Override
    public FeatureDO getFeature(Long id) {
        return featureMapper.selectById(id);
    }

    @Override
    public PageResult<FeatureDO> getFeaturePage(FeaturePageReqVO pageReqVO) {
        return featureMapper.selectPage(pageReqVO);
    }

}