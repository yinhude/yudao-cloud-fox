package cn.iocoder.yudao.module.bproduct.service.partchinarohscompliance;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.partchinarohscompliance.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partchinarohscompliance.PartChinaRohsComplianceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * rohs Service 接口
 *
 * @author 合适连接器
 */
public interface PartChinaRohsComplianceService {

    /**
     * 创建rohs
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPartChinaRohsCompliance(@Valid PartChinaRohsComplianceSaveReqVO createReqVO);

    /**
     * 更新rohs
     *
     * @param updateReqVO 更新信息
     */
    void updatePartChinaRohsCompliance(@Valid PartChinaRohsComplianceSaveReqVO updateReqVO);

    /**
     * 删除rohs
     *
     * @param id 编号
     */
    void deletePartChinaRohsCompliance(Long id);

    /**
     * 获得rohs
     *
     * @param id 编号
     * @return rohs
     */
    PartChinaRohsComplianceDO getPartChinaRohsCompliance(Long id);

    /**
     * 获得rohs分页
     *
     * @param pageReqVO 分页查询
     * @return rohs分页
     */
    PageResult<PartChinaRohsComplianceDO> getPartChinaRohsCompliancePage(PartChinaRohsCompliancePageReqVO pageReqVO);

}