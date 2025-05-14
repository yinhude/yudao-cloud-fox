package cn.iocoder.yudao.module.bproduct.service.partreachcompliances;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.partreachcompliances.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partreachcompliances.PartReachCompliancesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.bproduct.dal.mysql.partreachcompliances.PartReachCompliancesMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bproduct.enums.ErrorCodeConstants.*;

/**
 * reach合规性 Service 实现类
 *
 * @author 合适连接器
 */
@Service
@Validated
public class PartReachCompliancesServiceImpl implements PartReachCompliancesService {

    @Resource
    private PartReachCompliancesMapper partReachCompliancesMapper;

    @Override
    public Long createPartReachCompliances(PartReachCompliancesSaveReqVO createReqVO) {
        // 插入
        PartReachCompliancesDO partReachCompliances = BeanUtils.toBean(createReqVO, PartReachCompliancesDO.class);
        partReachCompliancesMapper.insert(partReachCompliances);
        // 返回
        return partReachCompliances.getId();
    }

    @Override
    public void updatePartReachCompliances(PartReachCompliancesSaveReqVO updateReqVO) {
        // 校验存在
        validatePartReachCompliancesExists(updateReqVO.getId());
        // 更新
        PartReachCompliancesDO updateObj = BeanUtils.toBean(updateReqVO, PartReachCompliancesDO.class);
        partReachCompliancesMapper.updateById(updateObj);
    }

    @Override
    public void deletePartReachCompliances(Long id) {
        // 校验存在
        validatePartReachCompliancesExists(id);
        // 删除
        partReachCompliancesMapper.deleteById(id);
    }

    private void validatePartReachCompliancesExists(Long id) {
        if (partReachCompliancesMapper.selectById(id) == null) {
            throw exception(PART_REACH_COMPLIANCES_NOT_EXISTS);
        }
    }

    @Override
    public PartReachCompliancesDO getPartReachCompliances(Long id) {
        return partReachCompliancesMapper.selectById(id);
    }

    @Override
    public PageResult<PartReachCompliancesDO> getPartReachCompliancesPage(PartReachCompliancesPageReqVO pageReqVO) {
        return partReachCompliancesMapper.selectPage(pageReqVO);
    }

}