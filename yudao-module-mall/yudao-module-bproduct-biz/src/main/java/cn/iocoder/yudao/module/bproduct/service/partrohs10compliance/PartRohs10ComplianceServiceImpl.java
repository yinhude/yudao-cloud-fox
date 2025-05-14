package cn.iocoder.yudao.module.bproduct.service.partrohs10compliance;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.partrohs10compliance.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partrohs10compliance.PartRohs10ComplianceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.bproduct.dal.mysql.partrohs10compliance.PartRohs10ComplianceMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bproduct.enums.ErrorCodeConstants.*;

/**
 * rohs合规性 Service 实现类
 *
 * @author 合适连接器
 */
@Service
@Validated
public class PartRohs10ComplianceServiceImpl implements PartRohs10ComplianceService {

    @Resource
    private PartRohs10ComplianceMapper partRohs10ComplianceMapper;

    @Override
    public Long createPartRohs10Compliance(PartRohs10ComplianceSaveReqVO createReqVO) {
        // 插入
        PartRohs10ComplianceDO partRohs10Compliance = BeanUtils.toBean(createReqVO, PartRohs10ComplianceDO.class);
        partRohs10ComplianceMapper.insert(partRohs10Compliance);
        // 返回
        return partRohs10Compliance.getId();
    }

    @Override
    public void updatePartRohs10Compliance(PartRohs10ComplianceSaveReqVO updateReqVO) {
        // 校验存在
        validatePartRohs10ComplianceExists(updateReqVO.getId());
        // 更新
        PartRohs10ComplianceDO updateObj = BeanUtils.toBean(updateReqVO, PartRohs10ComplianceDO.class);
        partRohs10ComplianceMapper.updateById(updateObj);
    }

    @Override
    public void deletePartRohs10Compliance(Long id) {
        // 校验存在
        validatePartRohs10ComplianceExists(id);
        // 删除
        partRohs10ComplianceMapper.deleteById(id);
    }

    private void validatePartRohs10ComplianceExists(Long id) {
        if (partRohs10ComplianceMapper.selectById(id) == null) {
            throw exception(PART_ROHS10_COMPLIANCE_NOT_EXISTS);
        }
    }

    @Override
    public PartRohs10ComplianceDO getPartRohs10Compliance(Long id) {
        return partRohs10ComplianceMapper.selectById(id);
    }

    @Override
    public PageResult<PartRohs10ComplianceDO> getPartRohs10CompliancePage(PartRohs10CompliancePageReqVO pageReqVO) {
        return partRohs10ComplianceMapper.selectPage(pageReqVO);
    }

}