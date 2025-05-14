package cn.iocoder.yudao.module.bproduct.service.partelvcompliance;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.partelvcompliance.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partelvcompliance.PartElvComplianceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * elv合规数据 Service 接口
 *
 * @author 合适连接器
 */
public interface PartElvComplianceService {

    /**
     * 创建elv合规数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPartElvCompliance(@Valid PartElvComplianceSaveReqVO createReqVO);

    /**
     * 更新elv合规数据
     *
     * @param updateReqVO 更新信息
     */
    void updatePartElvCompliance(@Valid PartElvComplianceSaveReqVO updateReqVO);

    /**
     * 删除elv合规数据
     *
     * @param id 编号
     */
    void deletePartElvCompliance(Long id);

    /**
     * 获得elv合规数据
     *
     * @param id 编号
     * @return elv合规数据
     */
    PartElvComplianceDO getPartElvCompliance(Long id);

    /**
     * 获得elv合规数据分页
     *
     * @param pageReqVO 分页查询
     * @return elv合规数据分页
     */
    PageResult<PartElvComplianceDO> getPartElvCompliancePage(PartElvCompliancePageReqVO pageReqVO);

}