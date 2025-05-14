package cn.iocoder.yudao.module.bproduct.service.featuregroup;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.featuregroup.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.featuregroup.FeatureGroupDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 特征值分组 Service 接口
 *
 * @author 合适连接器
 */
public interface FeatureGroupService {

    /**
     * 创建特征值分组
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createFeatureGroup(@Valid FeatureGroupSaveReqVO createReqVO);

    /**
     * 更新特征值分组
     *
     * @param updateReqVO 更新信息
     */
    void updateFeatureGroup(@Valid FeatureGroupSaveReqVO updateReqVO);

    /**
     * 删除特征值分组
     *
     * @param id 编号
     */
    void deleteFeatureGroup(Long id);

    /**
     * 获得特征值分组
     *
     * @param id 编号
     * @return 特征值分组
     */
    FeatureGroupDO getFeatureGroup(Long id);

    /**
     * 获得特征值分组分页
     *
     * @param pageReqVO 分页查询
     * @return 特征值分组分页
     */
    PageResult<FeatureGroupDO> getFeatureGroupPage(FeatureGroupPageReqVO pageReqVO);

}