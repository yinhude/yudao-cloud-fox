package cn.iocoder.yudao.module.bproduct.service.category;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.category.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.category.CategoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 商品系列 Service 接口
 *
 * @author 合适连接器
 */
public interface CategoryService {

    /**
     * 创建商品系列
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createCategory(@Valid CategorySaveReqVO createReqVO);

    /**
     * 更新商品系列
     *
     * @param updateReqVO 更新信息
     */
    void updateCategory(@Valid CategorySaveReqVO updateReqVO);

    /**
     * 删除商品系列
     *
     * @param id 编号
     */
    void deleteCategory(Long id);

    /**
     * 获得商品系列
     *
     * @param id 编号
     * @return 商品系列
     */
    CategoryDO getCategory(Long id);


    PageResult<CategoryDO> getCategoryPage(CategoryPageReqVO pageReqVO);

    /**
     * 获得商品系列列表
     *
     * @param listReqVO 查询条件
     * @return 商品系列列表
     */
    List<CategoryDO> getCategoryList(CategoryListReqVO listReqVO);

}