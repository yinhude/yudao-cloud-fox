package cn.iocoder.yudao.module.bproduct.service.partreachsvhcs;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.partreachsvhcs.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partreachsvhcs.PartReachSvhcsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.bproduct.dal.mysql.partreachsvhcs.PartReachSvhcsMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bproduct.enums.ErrorCodeConstants.*;

/**
 * reach合规性 Service 实现类
 *
 * @author 合适连接器
 */
@Service
@Validated
public class PartReachSvhcsServiceImpl implements PartReachSvhcsService {

    @Resource
    private PartReachSvhcsMapper partReachSvhcsMapper;

    @Override
    public Long createPartReachSvhcs(PartReachSvhcsSaveReqVO createReqVO) {
        // 插入
        PartReachSvhcsDO partReachSvhcs = BeanUtils.toBean(createReqVO, PartReachSvhcsDO.class);
        partReachSvhcsMapper.insert(partReachSvhcs);
        // 返回
        return partReachSvhcs.getId();
    }

    @Override
    public void updatePartReachSvhcs(PartReachSvhcsSaveReqVO updateReqVO) {
        // 校验存在
        validatePartReachSvhcsExists(updateReqVO.getId());
        // 更新
        PartReachSvhcsDO updateObj = BeanUtils.toBean(updateReqVO, PartReachSvhcsDO.class);
        partReachSvhcsMapper.updateById(updateObj);
    }

    @Override
    public void deletePartReachSvhcs(Long id) {
        // 校验存在
        validatePartReachSvhcsExists(id);
        // 删除
        partReachSvhcsMapper.deleteById(id);
    }

    private void validatePartReachSvhcsExists(Long id) {
        if (partReachSvhcsMapper.selectById(id) == null) {
            throw exception(PART_REACH_SVHCS_NOT_EXISTS);
        }
    }

    @Override
    public PartReachSvhcsDO getPartReachSvhcs(Long id) {
        return partReachSvhcsMapper.selectById(id);
    }

    @Override
    public PageResult<PartReachSvhcsDO> getPartReachSvhcsPage(PartReachSvhcsPageReqVO pageReqVO) {
        return partReachSvhcsMapper.selectPage(pageReqVO);
    }

}