package cn.iocoder.yudao.module.bproduct.service.featurevaluecategoryrela;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.featurevaluecategoryrela.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.featurevaluecategoryrela.FeatureValueCategoryRelaDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.bproduct.dal.mysql.featurevaluecategoryrela.FeatureValueCategoryRelaMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bproduct.enums.ErrorCodeConstants.*;

/**
 * 特征值关联 Service 实现类
 *
 * @author 合适连接器
 */
@Service
@Validated
public class FeatureValueCategoryRelaServiceImpl implements FeatureValueCategoryRelaService {

    @Resource
    private FeatureValueCategoryRelaMapper featureValueCategoryRelaMapper;

    @Override
    public Long createFeatureValueCategoryRela(FeatureValueCategoryRelaSaveReqVO createReqVO) {
        // 插入
        FeatureValueCategoryRelaDO featureValueCategoryRela = BeanUtils.toBean(createReqVO, FeatureValueCategoryRelaDO.class);
        featureValueCategoryRelaMapper.insert(featureValueCategoryRela);
        // 返回
        return featureValueCategoryRela.getId();
    }

    @Override
    public void updateFeatureValueCategoryRela(FeatureValueCategoryRelaSaveReqVO updateReqVO) {
        // 校验存在
        validateFeatureValueCategoryRelaExists(updateReqVO.getId());
        // 更新
        FeatureValueCategoryRelaDO updateObj = BeanUtils.toBean(updateReqVO, FeatureValueCategoryRelaDO.class);
        featureValueCategoryRelaMapper.updateById(updateObj);
    }

    @Override
    public void deleteFeatureValueCategoryRela(Long id) {
        // 校验存在
        validateFeatureValueCategoryRelaExists(id);
        // 删除
        featureValueCategoryRelaMapper.deleteById(id);
    }

    private void validateFeatureValueCategoryRelaExists(Long id) {
        if (featureValueCategoryRelaMapper.selectById(id) == null) {
            throw exception(FEATURE_VALUE_CATEGORY_RELA_NOT_EXISTS);
        }
    }

    @Override
    public FeatureValueCategoryRelaDO getFeatureValueCategoryRela(Long id) {
        return featureValueCategoryRelaMapper.selectById(id);
    }

    @Override
    public PageResult<FeatureValueCategoryRelaDO> getFeatureValueCategoryRelaPage(FeatureValueCategoryRelaPageReqVO pageReqVO) {
        return featureValueCategoryRelaMapper.selectPage(pageReqVO);
    }

}