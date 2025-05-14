package cn.iocoder.yudao.module.bproduct.service.similar;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.similar.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.similar.SimilarDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.bproduct.dal.mysql.similar.SimilarMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bproduct.enums.ErrorCodeConstants.*;

/**
 * 商品替代品 Service 实现类
 *
 * @author 合适连接器
 */
@Service
@Validated
public class SimilarServiceImpl implements SimilarService {

    @Resource
    private SimilarMapper similarMapper;

    @Override
    public Long createSimilar(SimilarSaveReqVO createReqVO) {
        // 插入
        SimilarDO similar = BeanUtils.toBean(createReqVO, SimilarDO.class);
        similarMapper.insert(similar);
        // 返回
        return similar.getId();
    }

    @Override
    public void updateSimilar(SimilarSaveReqVO updateReqVO) {
        // 校验存在
        validateSimilarExists(updateReqVO.getId());
        // 更新
        SimilarDO updateObj = BeanUtils.toBean(updateReqVO, SimilarDO.class);
        similarMapper.updateById(updateObj);
    }

    @Override
    public void deleteSimilar(Long id) {
        // 校验存在
        validateSimilarExists(id);
        // 删除
        similarMapper.deleteById(id);
    }

    private void validateSimilarExists(Long id) {
        if (similarMapper.selectById(id) == null) {
            throw exception(SIMILAR_NOT_EXISTS);
        }
    }

    @Override
    public SimilarDO getSimilar(Long id) {
        return similarMapper.selectById(id);
    }

    @Override
    public PageResult<SimilarDO> getSimilarPage(SimilarPageReqVO pageReqVO) {
        return similarMapper.selectPage(pageReqVO);
    }

}