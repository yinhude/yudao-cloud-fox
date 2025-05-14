package cn.iocoder.yudao.module.bproduct.service.primaryimages;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.primaryimages.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.primaryimages.PrimaryImagesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 商品主图 Service 接口
 *
 * @author 合适连接器
 */
public interface PrimaryImagesService {

    /**
     * 创建商品主图
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPrimaryImages(@Valid PrimaryImagesSaveReqVO createReqVO);

    /**
     * 更新商品主图
     *
     * @param updateReqVO 更新信息
     */
    void updatePrimaryImages(@Valid PrimaryImagesSaveReqVO updateReqVO);

    /**
     * 删除商品主图
     *
     * @param id 编号
     */
    void deletePrimaryImages(Long id);

    /**
     * 获得商品主图
     *
     * @param id 编号
     * @return 商品主图
     */
    PrimaryImagesDO getPrimaryImages(Long id);

    /**
     * 获得商品主图分页
     *
     * @param pageReqVO 分页查询
     * @return 商品主图分页
     */
    PageResult<PrimaryImagesDO> getPrimaryImagesPage(PrimaryImagesPageReqVO pageReqVO);

}