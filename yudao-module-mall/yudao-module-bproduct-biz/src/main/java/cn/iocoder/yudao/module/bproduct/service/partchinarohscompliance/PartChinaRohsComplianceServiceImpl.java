package cn.iocoder.yudao.module.bproduct.service.partchinarohscompliance;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.partchinarohscompliance.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partchinarohscompliance.PartChinaRohsComplianceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.bproduct.dal.mysql.partchinarohscompliance.PartChinaRohsComplianceMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bproduct.enums.ErrorCodeConstants.*;

/**
 * rohs Service 实现类
 *
 * @author 合适连接器
 */
@Service
@Validated
public class PartChinaRohsComplianceServiceImpl implements PartChinaRohsComplianceService {

    @Resource
    private PartChinaRohsComplianceMapper partChinaRohsComplianceMapper;

    @Override
    public Long createPartChinaRohsCompliance(PartChinaRohsComplianceSaveReqVO createReqVO) {
        // 插入
        PartChinaRohsComplianceDO partChinaRohsCompliance = BeanUtils.toBean(createReqVO, PartChinaRohsComplianceDO.class);
        partChinaRohsComplianceMapper.insert(partChinaRohsCompliance);
        // 返回
        return partChinaRohsCompliance.getId();
    }

    @Override
    public void updatePartChinaRohsCompliance(PartChinaRohsComplianceSaveReqVO updateReqVO) {
        // 校验存在
        validatePartChinaRohsComplianceExists(updateReqVO.getId());
        // 更新
        PartChinaRohsComplianceDO updateObj = BeanUtils.toBean(updateReqVO, PartChinaRohsComplianceDO.class);
        partChinaRohsComplianceMapper.updateById(updateObj);
    }

    @Override
    public void deletePartChinaRohsCompliance(Long id) {
        // 校验存在
        validatePartChinaRohsComplianceExists(id);
        // 删除
        partChinaRohsComplianceMapper.deleteById(id);
    }

    private void validatePartChinaRohsComplianceExists(Long id) {
        if (partChinaRohsComplianceMapper.selectById(id) == null) {
            throw exception(PART_CHINA_ROHS_COMPLIANCE_NOT_EXISTS);
        }
    }

    @Override
    public PartChinaRohsComplianceDO getPartChinaRohsCompliance(Long id) {
        return partChinaRohsComplianceMapper.selectById(id);
    }

    @Override
    public PageResult<PartChinaRohsComplianceDO> getPartChinaRohsCompliancePage(PartChinaRohsCompliancePageReqVO pageReqVO) {
        return partChinaRohsComplianceMapper.selectPage(pageReqVO);
    }

}