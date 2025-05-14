package cn.iocoder.yudao.module.bproduct.service.selfproductcategoryrela;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.selfproductcategoryrela.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.selfproductcategoryrela.SelfProductCategoryRelaDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.bproduct.dal.mysql.selfproductcategoryrela.SelfProductCategoryRelaMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bproduct.enums.ErrorCodeConstants.*;

/**
 * 产品和自有分类的关联性 Service 实现类
 *
 * @author 合适连接器
 */
@Service
@Validated
public class SelfProductCategoryRelaServiceImpl implements SelfProductCategoryRelaService {

    @Resource
    private SelfProductCategoryRelaMapper selfProductCategoryRelaMapper;

    @Override
    public Long createSelfProductCategoryRela(SelfProductCategoryRelaSaveReqVO createReqVO) {
        // 插入
        SelfProductCategoryRelaDO selfProductCategoryRela = BeanUtils.toBean(createReqVO, SelfProductCategoryRelaDO.class);
        selfProductCategoryRelaMapper.insert(selfProductCategoryRela);
        // 返回
        return selfProductCategoryRela.getId();
    }

    @Override
    public void updateSelfProductCategoryRela(SelfProductCategoryRelaSaveReqVO updateReqVO) {
        // 校验存在
        validateSelfProductCategoryRelaExists(updateReqVO.getId());
        // 更新
        SelfProductCategoryRelaDO updateObj = BeanUtils.toBean(updateReqVO, SelfProductCategoryRelaDO.class);
        selfProductCategoryRelaMapper.updateById(updateObj);
    }

    @Override
    public void deleteSelfProductCategoryRela(Long id) {
        // 校验存在
        validateSelfProductCategoryRelaExists(id);
        // 删除
        selfProductCategoryRelaMapper.deleteById(id);
    }

    private void validateSelfProductCategoryRelaExists(Long id) {
        if (selfProductCategoryRelaMapper.selectById(id) == null) {
            throw exception(SELF_PRODUCT_CATEGORY_RELA_NOT_EXISTS);
        }
    }

    @Override
    public SelfProductCategoryRelaDO getSelfProductCategoryRela(Long id) {
        return selfProductCategoryRelaMapper.selectById(id);
    }

    @Override
    public PageResult<SelfProductCategoryRelaDO> getSelfProductCategoryRelaPage(SelfProductCategoryRelaPageReqVO pageReqVO) {
        return selfProductCategoryRelaMapper.selectPage(pageReqVO);
    }

}