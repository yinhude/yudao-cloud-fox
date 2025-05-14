package cn.iocoder.yudao.module.bproduct.service.featurevaluecategoryrela;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.featurevaluecategoryrela.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.featurevaluecategoryrela.FeatureValueCategoryRelaDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 特征值关联 Service 接口
 *
 * @author 合适连接器
 */
public interface FeatureValueCategoryRelaService {

    /**
     * 创建特征值关联
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createFeatureValueCategoryRela(@Valid FeatureValueCategoryRelaSaveReqVO createReqVO);

    /**
     * 更新特征值关联
     *
     * @param updateReqVO 更新信息
     */
    void updateFeatureValueCategoryRela(@Valid FeatureValueCategoryRelaSaveReqVO updateReqVO);

    /**
     * 删除特征值关联
     *
     * @param id 编号
     */
    void deleteFeatureValueCategoryRela(Long id);

    /**
     * 获得特征值关联
     *
     * @param id 编号
     * @return 特征值关联
     */
    FeatureValueCategoryRelaDO getFeatureValueCategoryRela(Long id);

    /**
     * 获得特征值关联分页
     *
     * @param pageReqVO 分页查询
     * @return 特征值关联分页
     */
    PageResult<FeatureValueCategoryRelaDO> getFeatureValueCategoryRelaPage(FeatureValueCategoryRelaPageReqVO pageReqVO);

}