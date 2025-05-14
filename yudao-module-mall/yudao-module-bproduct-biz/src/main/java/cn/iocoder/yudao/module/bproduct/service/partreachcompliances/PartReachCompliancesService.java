package cn.iocoder.yudao.module.bproduct.service.partreachcompliances;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.partreachcompliances.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partreachcompliances.PartReachCompliancesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * reach合规性 Service 接口
 *
 * @author 合适连接器
 */
public interface PartReachCompliancesService {

    /**
     * 创建reach合规性
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPartReachCompliances(@Valid PartReachCompliancesSaveReqVO createReqVO);

    /**
     * 更新reach合规性
     *
     * @param updateReqVO 更新信息
     */
    void updatePartReachCompliances(@Valid PartReachCompliancesSaveReqVO updateReqVO);

    /**
     * 删除reach合规性
     *
     * @param id 编号
     */
    void deletePartReachCompliances(Long id);

    /**
     * 获得reach合规性
     *
     * @param id 编号
     * @return reach合规性
     */
    PartReachCompliancesDO getPartReachCompliances(Long id);

    /**
     * 获得reach合规性分页
     *
     * @param pageReqVO 分页查询
     * @return reach合规性分页
     */
    PageResult<PartReachCompliancesDO> getPartReachCompliancesPage(PartReachCompliancesPageReqVO pageReqVO);

}