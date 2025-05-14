package cn.iocoder.yudao.module.bproduct.service.partrohs10compliance;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.partrohs10compliance.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partrohs10compliance.PartRohs10ComplianceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * rohs合规性 Service 接口
 *
 * @author 合适连接器
 */
public interface PartRohs10ComplianceService {

    /**
     * 创建rohs合规性
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPartRohs10Compliance(@Valid PartRohs10ComplianceSaveReqVO createReqVO);

    /**
     * 更新rohs合规性
     *
     * @param updateReqVO 更新信息
     */
    void updatePartRohs10Compliance(@Valid PartRohs10ComplianceSaveReqVO updateReqVO);

    /**
     * 删除rohs合规性
     *
     * @param id 编号
     */
    void deletePartRohs10Compliance(Long id);

    /**
     * 获得rohs合规性
     *
     * @param id 编号
     * @return rohs合规性
     */
    PartRohs10ComplianceDO getPartRohs10Compliance(Long id);

    /**
     * 获得rohs合规性分页
     *
     * @param pageReqVO 分页查询
     * @return rohs合规性分页
     */
    PageResult<PartRohs10ComplianceDO> getPartRohs10CompliancePage(PartRohs10CompliancePageReqVO pageReqVO);

}