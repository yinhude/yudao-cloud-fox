package cn.iocoder.yudao.module.bproduct.service.category;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.category.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.category.CategoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.bproduct.dal.mysql.category.CategoryMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bproduct.enums.ErrorCodeConstants.*;

/**
 * 商品系列 Service 实现类
 *
 * @author 合适连接器
 */
@Service
@Validated
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public Long createCategory(CategorySaveReqVO createReqVO) {
        // 校验父级id的有效性
        validateParentCategory(null, createReqVO.getParentId());
        // 校验名称的唯一性
        validateCategoryNameUnique(null, createReqVO.getParentId(), createReqVO.getName());

        // 插入
        CategoryDO category = BeanUtils.toBean(createReqVO, CategoryDO.class);
        categoryMapper.insert(category);
        // 返回
        return category.getId();
    }

    @Override
    public void updateCategory(CategorySaveReqVO updateReqVO) {
        // 校验存在
        validateCategoryExists(updateReqVO.getId());
        // 校验父级id的有效性
        validateParentCategory(updateReqVO.getId(), updateReqVO.getParentId());
        // 校验名称的唯一性
        validateCategoryNameUnique(updateReqVO.getId(), updateReqVO.getParentId(), updateReqVO.getName());

        // 更新
        CategoryDO updateObj = BeanUtils.toBean(updateReqVO, CategoryDO.class);
        categoryMapper.updateById(updateObj);
    }

    @Override
    public void deleteCategory(Long id) {
        // 校验存在
        validateCategoryExists(id);
        // 校验是否有子商品系列
        if (categoryMapper.selectCountByParentId(id) > 0) {
            throw exception(CATEGORY_EXITS_CHILDREN);
        }
        // 删除
        categoryMapper.deleteById(id);
    }

    private void validateCategoryExists(Long id) {
        if (categoryMapper.selectById(id) == null) {
            throw exception(CATEGORY_NOT_EXISTS);
        }
    }

    private void validateParentCategory(Long id, Long parentId) {
        if (parentId == null || CategoryDO.PARENT_ID_ROOT.equals(parentId)) {
            return;
        }
        // 1. 不能设置自己为父商品系列
        if (Objects.equals(id, parentId)) {
            throw exception(CATEGORY_PARENT_ERROR);
        }
        // 2. 父商品系列不存在
        CategoryDO parentCategory = categoryMapper.selectById(parentId);
        if (parentCategory == null) {
            throw exception(CATEGORY_PARENT_NOT_EXITS);
        }
        // 3. 递归校验父商品系列，如果父商品系列是自己的子商品系列，则报错，避免形成环路
        if (id == null) { // id 为空，说明新增，不需要考虑环路
            return;
        }
        for (int i = 0; i < Short.MAX_VALUE; i++) {
            // 3.1 校验环路
            parentId = parentCategory.getParentId();
            if (Objects.equals(id, parentId)) {
                throw exception(CATEGORY_PARENT_IS_CHILD);
            }
            // 3.2 继续递归下一级父商品系列
            if (parentId == null || CategoryDO.PARENT_ID_ROOT.equals(parentId)) {
                break;
            }
            parentCategory = categoryMapper.selectById(parentId);
            if (parentCategory == null) {
                break;
            }
        }
    }

    private void validateCategoryNameUnique(Long id, Long parentId, String name) {
        CategoryDO category = categoryMapper.selectByParentIdAndName(parentId, name);
        if (category == null) {
            return;
        }
        // 如果 id 为空，说明不用比较是否为相同 id 的商品系列
        if (id == null) {
            throw exception(CATEGORY_NAME_DUPLICATE);
        }
        if (!Objects.equals(category.getId(), id)) {
            throw exception(CATEGORY_NAME_DUPLICATE);
        }
    }

    @Override
    public CategoryDO getCategory(Long id) {
        return categoryMapper.selectById(id);
    }

    @Override
    public PageResult<CategoryDO> getCategoryPage(CategoryPageReqVO pageReqVO) {
        return categoryMapper.selectPage(pageReqVO);
    }

    @Override
    public List<CategoryDO> getCategoryList(CategoryListReqVO listReqVO) {
        return categoryMapper.selectList(listReqVO);
    }

}