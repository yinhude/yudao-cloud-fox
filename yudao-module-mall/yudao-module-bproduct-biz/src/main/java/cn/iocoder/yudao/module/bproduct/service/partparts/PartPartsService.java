package cn.iocoder.yudao.module.bproduct.service.partparts;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.partparts.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partparts.PartPartsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * part合规性 Service 接口
 *
 * @author 合适连接器
 */
public interface PartPartsService {

    /**
     * 创建part合规性
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPartParts(@Valid PartPartsSaveReqVO createReqVO);

    /**
     * 更新part合规性
     *
     * @param updateReqVO 更新信息
     */
    void updatePartParts(@Valid PartPartsSaveReqVO updateReqVO);

    /**
     * 删除part合规性
     *
     * @param id 编号
     */
    void deletePartParts(Long id);

    /**
     * 获得part合规性
     *
     * @param id 编号
     * @return part合规性
     */
    PartPartsDO getPartParts(Long id);

    /**
     * 获得part合规性分页
     *
     * @param pageReqVO 分页查询
     * @return part合规性分页
     */
    PageResult<PartPartsDO> getPartPartsPage(PartPartsPageReqVO pageReqVO);

}