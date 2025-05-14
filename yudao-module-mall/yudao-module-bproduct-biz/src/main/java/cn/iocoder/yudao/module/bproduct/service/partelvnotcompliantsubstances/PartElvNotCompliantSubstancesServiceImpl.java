package cn.iocoder.yudao.module.bproduct.service.partelvnotcompliantsubstances;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.partelvnotcompliantsubstances.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partelvnotcompliantsubstances.PartElvNotCompliantSubstancesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.bproduct.dal.mysql.partelvnotcompliantsubstances.PartElvNotCompliantSubstancesMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bproduct.enums.ErrorCodeConstants.*;

/**
 * elv不合规含量子 Service 实现类
 *
 * @author 合适连接器
 */
@Service
@Validated
public class PartElvNotCompliantSubstancesServiceImpl implements PartElvNotCompliantSubstancesService {

    @Resource
    private PartElvNotCompliantSubstancesMapper partElvNotCompliantSubstancesMapper;

    @Override
    public Long createPartElvNotCompliantSubstances(PartElvNotCompliantSubstancesSaveReqVO createReqVO) {
        // 插入
        PartElvNotCompliantSubstancesDO partElvNotCompliantSubstances = BeanUtils.toBean(createReqVO, PartElvNotCompliantSubstancesDO.class);
        partElvNotCompliantSubstancesMapper.insert(partElvNotCompliantSubstances);
        // 返回
        return partElvNotCompliantSubstances.getId();
    }

    @Override
    public void updatePartElvNotCompliantSubstances(PartElvNotCompliantSubstancesSaveReqVO updateReqVO) {
        // 校验存在
        validatePartElvNotCompliantSubstancesExists(updateReqVO.getId());
        // 更新
        PartElvNotCompliantSubstancesDO updateObj = BeanUtils.toBean(updateReqVO, PartElvNotCompliantSubstancesDO.class);
        partElvNotCompliantSubstancesMapper.updateById(updateObj);
    }

    @Override
    public void deletePartElvNotCompliantSubstances(Long id) {
        // 校验存在
        validatePartElvNotCompliantSubstancesExists(id);
        // 删除
        partElvNotCompliantSubstancesMapper.deleteById(id);
    }

    private void validatePartElvNotCompliantSubstancesExists(Long id) {
        if (partElvNotCompliantSubstancesMapper.selectById(id) == null) {
            throw exception(PART_ELV_NOT_COMPLIANT_SUBSTANCES_NOT_EXISTS);
        }
    }

    @Override
    public PartElvNotCompliantSubstancesDO getPartElvNotCompliantSubstances(Long id) {
        return partElvNotCompliantSubstancesMapper.selectById(id);
    }

    @Override
    public PageResult<PartElvNotCompliantSubstancesDO> getPartElvNotCompliantSubstancesPage(PartElvNotCompliantSubstancesPageReqVO pageReqVO) {
        return partElvNotCompliantSubstancesMapper.selectPage(pageReqVO);
    }

}