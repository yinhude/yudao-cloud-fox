package cn.iocoder.yudao.module.bproduct.service.partreachsvhcs;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.partreachsvhcs.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partreachsvhcs.PartReachSvhcsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * reach合规性 Service 接口
 *
 * @author 合适连接器
 */
public interface PartReachSvhcsService {

    /**
     * 创建reach合规性
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPartReachSvhcs(@Valid PartReachSvhcsSaveReqVO createReqVO);

    /**
     * 更新reach合规性
     *
     * @param updateReqVO 更新信息
     */
    void updatePartReachSvhcs(@Valid PartReachSvhcsSaveReqVO updateReqVO);

    /**
     * 删除reach合规性
     *
     * @param id 编号
     */
    void deletePartReachSvhcs(Long id);

    /**
     * 获得reach合规性
     *
     * @param id 编号
     * @return reach合规性
     */
    PartReachSvhcsDO getPartReachSvhcs(Long id);

    /**
     * 获得reach合规性分页
     *
     * @param pageReqVO 分页查询
     * @return reach合规性分页
     */
    PageResult<PartReachSvhcsDO> getPartReachSvhcsPage(PartReachSvhcsPageReqVO pageReqVO);

}