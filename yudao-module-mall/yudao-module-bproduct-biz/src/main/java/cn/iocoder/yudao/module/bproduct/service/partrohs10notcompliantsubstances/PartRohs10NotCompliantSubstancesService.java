package cn.iocoder.yudao.module.bproduct.service.partrohs10notcompliantsubstances;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.partrohs10notcompliantsubstances.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partrohs10notcompliantsubstances.PartRohs10NotCompliantSubstancesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * rohs不符合的含量 Service 接口
 *
 * @author 合适连接器
 */
public interface PartRohs10NotCompliantSubstancesService {

    /**
     * 创建rohs不符合的含量
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPartRohs10NotCompliantSubstances(@Valid PartRohs10NotCompliantSubstancesSaveReqVO createReqVO);

    /**
     * 更新rohs不符合的含量
     *
     * @param updateReqVO 更新信息
     */
    void updatePartRohs10NotCompliantSubstances(@Valid PartRohs10NotCompliantSubstancesSaveReqVO updateReqVO);

    /**
     * 删除rohs不符合的含量
     *
     * @param id 编号
     */
    void deletePartRohs10NotCompliantSubstances(Long id);

    /**
     * 获得rohs不符合的含量
     *
     * @param id 编号
     * @return rohs不符合的含量
     */
    PartRohs10NotCompliantSubstancesDO getPartRohs10NotCompliantSubstances(Long id);

    /**
     * 获得rohs不符合的含量分页
     *
     * @param pageReqVO 分页查询
     * @return rohs不符合的含量分页
     */
    PageResult<PartRohs10NotCompliantSubstancesDO> getPartRohs10NotCompliantSubstancesPage(PartRohs10NotCompliantSubstancesPageReqVO pageReqVO);

}