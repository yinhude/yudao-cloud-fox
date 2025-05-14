package cn.iocoder.yudao.module.bproduct.service.partparts;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.partparts.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partparts.PartPartsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.bproduct.dal.mysql.partparts.PartPartsMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bproduct.enums.ErrorCodeConstants.*;

/**
 * part合规性 Service 实现类
 *
 * @author 合适连接器
 */
@Service
@Validated
public class PartPartsServiceImpl implements PartPartsService {

    @Resource
    private PartPartsMapper partPartsMapper;

    @Override
    public Long createPartParts(PartPartsSaveReqVO createReqVO) {
        // 插入
        PartPartsDO partParts = BeanUtils.toBean(createReqVO, PartPartsDO.class);
        partPartsMapper.insert(partParts);
        // 返回
        return partParts.getId();
    }

    @Override
    public void updatePartParts(PartPartsSaveReqVO updateReqVO) {
        // 校验存在
        validatePartPartsExists(updateReqVO.getId());
        // 更新
        PartPartsDO updateObj = BeanUtils.toBean(updateReqVO, PartPartsDO.class);
        partPartsMapper.updateById(updateObj);
    }

    @Override
    public void deletePartParts(Long id) {
        // 校验存在
        validatePartPartsExists(id);
        // 删除
        partPartsMapper.deleteById(id);
    }

    private void validatePartPartsExists(Long id) {
        if (partPartsMapper.selectById(id) == null) {
            throw exception(PART_PARTS_NOT_EXISTS);
        }
    }

    @Override
    public PartPartsDO getPartParts(Long id) {
        return partPartsMapper.selectById(id);
    }

    @Override
    public PageResult<PartPartsDO> getPartPartsPage(PartPartsPageReqVO pageReqVO) {
        return partPartsMapper.selectPage(pageReqVO);
    }

}