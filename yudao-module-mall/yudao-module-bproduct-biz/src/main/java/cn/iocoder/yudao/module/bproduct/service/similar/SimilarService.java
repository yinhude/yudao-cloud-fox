package cn.iocoder.yudao.module.bproduct.service.similar;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.similar.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.similar.SimilarDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 商品替代品 Service 接口
 *
 * @author 合适连接器
 */
public interface SimilarService {

    /**
     * 创建商品替代品
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createSimilar(@Valid SimilarSaveReqVO createReqVO);

    /**
     * 更新商品替代品
     *
     * @param updateReqVO 更新信息
     */
    void updateSimilar(@Valid SimilarSaveReqVO updateReqVO);

    /**
     * 删除商品替代品
     *
     * @param id 编号
     */
    void deleteSimilar(Long id);

    /**
     * 获得商品替代品
     *
     * @param id 编号
     * @return 商品替代品
     */
    SimilarDO getSimilar(Long id);

    /**
     * 获得商品替代品分页
     *
     * @param pageReqVO 分页查询
     * @return 商品替代品分页
     */
    PageResult<SimilarDO> getSimilarPage(SimilarPageReqVO pageReqVO);

}