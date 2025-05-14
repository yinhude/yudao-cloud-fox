package cn.iocoder.yudao.module.bproduct.service.partelvcompliance;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.partelvcompliance.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partelvcompliance.PartElvComplianceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.bproduct.dal.mysql.partelvcompliance.PartElvComplianceMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bproduct.enums.ErrorCodeConstants.*;

/**
 * elv合规数据 Service 实现类
 *
 * @author 合适连接器
 */
@Service
@Validated
public class PartElvComplianceServiceImpl implements PartElvComplianceService {

    @Resource
    private PartElvComplianceMapper partElvComplianceMapper;

    @Override
    public Long createPartElvCompliance(PartElvComplianceSaveReqVO createReqVO) {
        // 插入
        PartElvComplianceDO partElvCompliance = BeanUtils.toBean(createReqVO, PartElvComplianceDO.class);
        partElvComplianceMapper.insert(partElvCompliance);
        // 返回
        return partElvCompliance.getId();
    }

    @Override
    public void updatePartElvCompliance(PartElvComplianceSaveReqVO updateReqVO) {
        // 校验存在
        validatePartElvComplianceExists(updateReqVO.getId());
        // 更新
        PartElvComplianceDO updateObj = BeanUtils.toBean(updateReqVO, PartElvComplianceDO.class);
        partElvComplianceMapper.updateById(updateObj);
    }

    @Override
    public void deletePartElvCompliance(Long id) {
        // 校验存在
        validatePartElvComplianceExists(id);
        // 删除
        partElvComplianceMapper.deleteById(id);
    }

    private void validatePartElvComplianceExists(Long id) {
        if (partElvComplianceMapper.selectById(id) == null) {
            throw exception(PART_ELV_COMPLIANCE_NOT_EXISTS);
        }
    }

    @Override
    public PartElvComplianceDO getPartElvCompliance(Long id) {
        return partElvComplianceMapper.selectById(id);
    }

    @Override
    public PageResult<PartElvComplianceDO> getPartElvCompliancePage(PartElvCompliancePageReqVO pageReqVO) {
        return partElvComplianceMapper.selectPage(pageReqVO);
    }

}