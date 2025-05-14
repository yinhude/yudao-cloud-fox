package cn.iocoder.yudao.module.bproduct.service.featurevalue;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.featurevalue.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.featurevalue.FeatureValueDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.bproduct.dal.mysql.featurevalue.FeatureValueMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bproduct.enums.ErrorCodeConstants.*;

/**
 * 特征值 Service 实现类
 *
 * @author 合适连接器
 */
@Service
@Validated
public class FeatureValueServiceImpl implements FeatureValueService {

    @Resource
    private FeatureValueMapper featureValueMapper;

    @Override
    public Long createFeatureValue(FeatureValueSaveReqVO createReqVO) {
        // 插入
        FeatureValueDO featureValue = BeanUtils.toBean(createReqVO, FeatureValueDO.class);
        featureValueMapper.insert(featureValue);
        // 返回
        return featureValue.getId();
    }

    @Override
    public void updateFeatureValue(FeatureValueSaveReqVO updateReqVO) {
        // 校验存在
        validateFeatureValueExists(updateReqVO.getId());
        // 更新
        FeatureValueDO updateObj = BeanUtils.toBean(updateReqVO, FeatureValueDO.class);
        featureValueMapper.updateById(updateObj);
    }

    @Override
    public void deleteFeatureValue(Long id) {
        // 校验存在
        validateFeatureValueExists(id);
        // 删除
        featureValueMapper.deleteById(id);
    }

    private void validateFeatureValueExists(Long id) {
        if (featureValueMapper.selectById(id) == null) {
            throw exception(FEATURE_VALUE_NOT_EXISTS);
        }
    }

    @Override
    public FeatureValueDO getFeatureValue(Long id) {
        return featureValueMapper.selectById(id);
    }

    @Override
    public PageResult<FeatureValueDO> getFeatureValuePage(FeatureValuePageReqVO pageReqVO) {
        return featureValueMapper.selectPage(pageReqVO);
    }

}