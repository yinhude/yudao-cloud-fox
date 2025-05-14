package cn.iocoder.yudao.module.bproduct.service.featuregroup;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.featuregroup.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.featuregroup.FeatureGroupDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.bproduct.dal.mysql.featuregroup.FeatureGroupMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bproduct.enums.ErrorCodeConstants.*;

/**
 * 特征值分组 Service 实现类
 *
 * @author 合适连接器
 */
@Service
@Validated
public class FeatureGroupServiceImpl implements FeatureGroupService {

    @Resource
    private FeatureGroupMapper featureGroupMapper;

    @Override
    public Long createFeatureGroup(FeatureGroupSaveReqVO createReqVO) {
        // 插入
        FeatureGroupDO featureGroup = BeanUtils.toBean(createReqVO, FeatureGroupDO.class);
        featureGroupMapper.insert(featureGroup);
        // 返回
        return featureGroup.getId();
    }

    @Override
    public void updateFeatureGroup(FeatureGroupSaveReqVO updateReqVO) {
        // 校验存在
        validateFeatureGroupExists(updateReqVO.getId());
        // 更新
        FeatureGroupDO updateObj = BeanUtils.toBean(updateReqVO, FeatureGroupDO.class);
        featureGroupMapper.updateById(updateObj);
    }

    @Override
    public void deleteFeatureGroup(Long id) {
        // 校验存在
        validateFeatureGroupExists(id);
        // 删除
        featureGroupMapper.deleteById(id);
    }

    private void validateFeatureGroupExists(Long id) {
        if (featureGroupMapper.selectById(id) == null) {
            throw exception(FEATURE_GROUP_NOT_EXISTS);
        }
    }

    @Override
    public FeatureGroupDO getFeatureGroup(Long id) {
        return featureGroupMapper.selectById(id);
    }

    @Override
    public PageResult<FeatureGroupDO> getFeatureGroupPage(FeatureGroupPageReqVO pageReqVO) {
        return featureGroupMapper.selectPage(pageReqVO);
    }

}