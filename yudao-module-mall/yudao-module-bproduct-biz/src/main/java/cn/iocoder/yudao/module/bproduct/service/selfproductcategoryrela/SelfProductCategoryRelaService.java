package cn.iocoder.yudao.module.bproduct.service.selfproductcategoryrela;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.selfproductcategoryrela.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.selfproductcategoryrela.SelfProductCategoryRelaDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 产品和自有分类的关联性 Service 接口
 *
 * @author 合适连接器
 */
public interface SelfProductCategoryRelaService {

    /**
     * 创建产品和自有分类的关联性
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createSelfProductCategoryRela(@Valid SelfProductCategoryRelaSaveReqVO createReqVO);

    /**
     * 更新产品和自有分类的关联性
     *
     * @param updateReqVO 更新信息
     */
    void updateSelfProductCategoryRela(@Valid SelfProductCategoryRelaSaveReqVO updateReqVO);

    /**
     * 删除产品和自有分类的关联性
     *
     * @param id 编号
     */
    void deleteSelfProductCategoryRela(Long id);

    /**
     * 获得产品和自有分类的关联性
     *
     * @param id 编号
     * @return 产品和自有分类的关联性
     */
    SelfProductCategoryRelaDO getSelfProductCategoryRela(Long id);

    /**
     * 获得产品和自有分类的关联性分页
     *
     * @param pageReqVO 分页查询
     * @return 产品和自有分类的关联性分页
     */
    PageResult<SelfProductCategoryRelaDO> getSelfProductCategoryRelaPage(SelfProductCategoryRelaPageReqVO pageReqVO);

}