package cn.iocoder.yudao.module.bproduct.service.featurevaluerela;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.featurevaluerela.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.featurevaluerela.FeatureValueRelaDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.bproduct.dal.mysql.featurevaluerela.FeatureValueRelaMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bproduct.enums.ErrorCodeConstants.*;

/**
 * 特征值关联 Service 实现类
 *
 * @author 合适连接器
 */
@Service
@Validated
public class FeatureValueRelaServiceImpl implements FeatureValueRelaService {

    @Resource
    private FeatureValueRelaMapper featureValueRelaMapper;

    @Override
    public Long createFeatureValueRela(FeatureValueRelaSaveReqVO createReqVO) {
        // 插入
        FeatureValueRelaDO featureValueRela = BeanUtils.toBean(createReqVO, FeatureValueRelaDO.class);
        featureValueRelaMapper.insert(featureValueRela);
        // 返回
        return featureValueRela.getId();
    }

    @Override
    public void updateFeatureValueRela(FeatureValueRelaSaveReqVO updateReqVO) {
        // 校验存在
        validateFeatureValueRelaExists(updateReqVO.getId());
        // 更新
        FeatureValueRelaDO updateObj = BeanUtils.toBean(updateReqVO, FeatureValueRelaDO.class);
        featureValueRelaMapper.updateById(updateObj);
    }

    @Override
    public void deleteFeatureValueRela(Long id) {
        // 校验存在
        validateFeatureValueRelaExists(id);
        // 删除
        featureValueRelaMapper.deleteById(id);
    }

    private void validateFeatureValueRelaExists(Long id) {
        if (featureValueRelaMapper.selectById(id) == null) {
            throw exception(FEATURE_VALUE_RELA_NOT_EXISTS);
        }
    }

    @Override
    public FeatureValueRelaDO getFeatureValueRela(Long id) {
        return featureValueRelaMapper.selectById(id);
    }

    @Override
    public PageResult<FeatureValueRelaDO> getFeatureValueRelaPage(FeatureValueRelaPageReqVO pageReqVO) {
        return featureValueRelaMapper.selectPage(pageReqVO);
    }

}