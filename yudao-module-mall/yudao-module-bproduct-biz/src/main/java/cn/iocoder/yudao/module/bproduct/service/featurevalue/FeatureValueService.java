package cn.iocoder.yudao.module.bproduct.service.featurevalue;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.featurevalue.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.featurevalue.FeatureValueDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 特征值 Service 接口
 *
 * @author 合适连接器
 */
public interface FeatureValueService {

    /**
     * 创建特征值
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createFeatureValue(@Valid FeatureValueSaveReqVO createReqVO);

    /**
     * 更新特征值
     *
     * @param updateReqVO 更新信息
     */
    void updateFeatureValue(@Valid FeatureValueSaveReqVO updateReqVO);

    /**
     * 删除特征值
     *
     * @param id 编号
     */
    void deleteFeatureValue(Long id);

    /**
     * 获得特征值
     *
     * @param id 编号
     * @return 特征值
     */
    FeatureValueDO getFeatureValue(Long id);

    /**
     * 获得特征值分页
     *
     * @param pageReqVO 分页查询
     * @return 特征值分页
     */
    PageResult<FeatureValueDO> getFeatureValuePage(FeatureValuePageReqVO pageReqVO);

}