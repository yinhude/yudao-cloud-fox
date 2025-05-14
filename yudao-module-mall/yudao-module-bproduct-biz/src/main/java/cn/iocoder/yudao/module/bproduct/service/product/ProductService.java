package cn.iocoder.yudao.module.bproduct.service.product;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.product.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.product.ProductDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 商品系列 Service 接口
 *
 * @author 合适连接器
 */
public interface ProductService {

    /**
     * 创建商品系列
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createProduct(@Valid ProductSaveReqVO createReqVO);

    /**
     * 更新商品系列
     *
     * @param updateReqVO 更新信息
     */
    void updateProduct(@Valid ProductSaveReqVO updateReqVO);

    /**
     * 删除商品系列
     *
     * @param id 编号
     */
    void deleteProduct(Long id);

    /**
     * 获得商品系列
     *
     * @param id 编号
     * @return 商品系列
     */
    ProductDO getProduct(Long id);

    /**
     * 获得商品系列分页
     *
     * @param pageReqVO 分页查询
     * @return 商品系列分页
     */
    PageResult<ProductDO> getProductPage(ProductPageReqVO pageReqVO);

}