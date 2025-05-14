package cn.iocoder.yudao.module.bproduct.service.partelvnotcompliantsubstances;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.partelvnotcompliantsubstances.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partelvnotcompliantsubstances.PartElvNotCompliantSubstancesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * elv不合规含量子 Service 接口
 *
 * @author 合适连接器
 */
public interface PartElvNotCompliantSubstancesService {

    /**
     * 创建elv不合规含量子
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPartElvNotCompliantSubstances(@Valid PartElvNotCompliantSubstancesSaveReqVO createReqVO);

    /**
     * 更新elv不合规含量子
     *
     * @param updateReqVO 更新信息
     */
    void updatePartElvNotCompliantSubstances(@Valid PartElvNotCompliantSubstancesSaveReqVO updateReqVO);

    /**
     * 删除elv不合规含量子
     *
     * @param id 编号
     */
    void deletePartElvNotCompliantSubstances(Long id);

    /**
     * 获得elv不合规含量子
     *
     * @param id 编号
     * @return elv不合规含量子
     */
    PartElvNotCompliantSubstancesDO getPartElvNotCompliantSubstances(Long id);

    /**
     * 获得elv不合规含量子分页
     *
     * @param pageReqVO 分页查询
     * @return elv不合规含量子分页
     */
    PageResult<PartElvNotCompliantSubstancesDO> getPartElvNotCompliantSubstancesPage(PartElvNotCompliantSubstancesPageReqVO pageReqVO);

}