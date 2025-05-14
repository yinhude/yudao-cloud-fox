package cn.iocoder.yudao.module.bproduct.service.feature;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.feature.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.feature.FeatureDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 特征 Service 接口
 *
 * @author 合适连接器
 */
public interface FeatureService {

    /**
     * 创建特征
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createFeature(@Valid FeatureSaveReqVO createReqVO);

    /**
     * 更新特征
     *
     * @param updateReqVO 更新信息
     */
    void updateFeature(@Valid FeatureSaveReqVO updateReqVO);

    /**
     * 删除特征
     *
     * @param id 编号
     */
    void deleteFeature(Long id);

    /**
     * 获得特征
     *
     * @param id 编号
     * @return 特征
     */
    FeatureDO getFeature(Long id);

    /**
     * 获得特征分页
     *
     * @param pageReqVO 分页查询
     * @return 特征分页
     */
    PageResult<FeatureDO> getFeaturePage(FeaturePageReqVO pageReqVO);

}