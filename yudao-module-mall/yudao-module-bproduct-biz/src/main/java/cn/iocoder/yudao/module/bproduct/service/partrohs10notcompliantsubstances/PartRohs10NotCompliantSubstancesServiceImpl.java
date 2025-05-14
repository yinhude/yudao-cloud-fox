package cn.iocoder.yudao.module.bproduct.service.partrohs10notcompliantsubstances;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.partrohs10notcompliantsubstances.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partrohs10notcompliantsubstances.PartRohs10NotCompliantSubstancesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.bproduct.dal.mysql.partrohs10notcompliantsubstances.PartRohs10NotCompliantSubstancesMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bproduct.enums.ErrorCodeConstants.*;

/**
 * rohs不符合的含量 Service 实现类
 *
 * @author 合适连接器
 */
@Service
@Validated
public class PartRohs10NotCompliantSubstancesServiceImpl implements PartRohs10NotCompliantSubstancesService {

    @Resource
    private PartRohs10NotCompliantSubstancesMapper partRohs10NotCompliantSubstancesMapper;

    @Override
    public Long createPartRohs10NotCompliantSubstances(PartRohs10NotCompliantSubstancesSaveReqVO createReqVO) {
        // 插入
        PartRohs10NotCompliantSubstancesDO partRohs10NotCompliantSubstances = BeanUtils.toBean(createReqVO, PartRohs10NotCompliantSubstancesDO.class);
        partRohs10NotCompliantSubstancesMapper.insert(partRohs10NotCompliantSubstances);
        // 返回
        return partRohs10NotCompliantSubstances.getId();
    }

    @Override
    public void updatePartRohs10NotCompliantSubstances(PartRohs10NotCompliantSubstancesSaveReqVO updateReqVO) {
        // 校验存在
        validatePartRohs10NotCompliantSubstancesExists(updateReqVO.getId());
        // 更新
        PartRohs10NotCompliantSubstancesDO updateObj = BeanUtils.toBean(updateReqVO, PartRohs10NotCompliantSubstancesDO.class);
        partRohs10NotCompliantSubstancesMapper.updateById(updateObj);
    }

    @Override
    public void deletePartRohs10NotCompliantSubstances(Long id) {
        // 校验存在
        validatePartRohs10NotCompliantSubstancesExists(id);
        // 删除
        partRohs10NotCompliantSubstancesMapper.deleteById(id);
    }

    private void validatePartRohs10NotCompliantSubstancesExists(Long id) {
        if (partRohs10NotCompliantSubstancesMapper.selectById(id) == null) {
            throw exception(PART_ROHS10_NOT_COMPLIANT_SUBSTANCES_NOT_EXISTS);
        }
    }

    @Override
    public PartRohs10NotCompliantSubstancesDO getPartRohs10NotCompliantSubstances(Long id) {
        return partRohs10NotCompliantSubstancesMapper.selectById(id);
    }

    @Override
    public PageResult<PartRohs10NotCompliantSubstancesDO> getPartRohs10NotCompliantSubstancesPage(PartRohs10NotCompliantSubstancesPageReqVO pageReqVO) {
        return partRohs10NotCompliantSubstancesMapper.selectPage(pageReqVO);
    }

}