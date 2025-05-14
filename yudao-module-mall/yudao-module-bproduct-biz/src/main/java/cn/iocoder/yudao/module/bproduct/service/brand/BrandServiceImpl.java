package cn.iocoder.yudao.module.bproduct.service.brand;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.brand.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.brand.BrandDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.bproduct.dal.mysql.brand.BrandMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bproduct.enums.ErrorCodeConstants.*;

/**
 * 品牌 Service 实现类
 *
 * @author 合适连接器
 */
@Service
@Validated
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;

    @Override
    public Long createBrand(BrandSaveReqVO createReqVO) {
        // 插入
        BrandDO brand = BeanUtils.toBean(createReqVO, BrandDO.class);
        brandMapper.insert(brand);
        // 返回
        return brand.getId();
    }

    @Override
    public void updateBrand(BrandSaveReqVO updateReqVO) {
        // 校验存在
        validateBrandExists(updateReqVO.getId());
        // 更新
        BrandDO updateObj = BeanUtils.toBean(updateReqVO, BrandDO.class);
        brandMapper.updateById(updateObj);
    }

    @Override
    public void deleteBrand(Long id) {
        // 校验存在
        validateBrandExists(id);
        // 删除
        brandMapper.deleteById(id);
    }

    private void validateBrandExists(Long id) {
        if (brandMapper.selectById(id) == null) {
            throw exception(BRAND_NOT_EXISTS);
        }
    }

    @Override
    public BrandDO getBrand(Long id) {
        return brandMapper.selectById(id);
    }

    @Override
    public PageResult<BrandDO> getBrandPage(BrandPageReqVO pageReqVO) {
        return brandMapper.selectPage(pageReqVO);
    }

}