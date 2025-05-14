package cn.iocoder.yudao.module.bproduct.service.genghsgoods;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.genghsgoods.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.genghsgoods.GenghsGoodsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.bproduct.dal.mysql.genghsgoods.GenghsGoodsMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bproduct.enums.ErrorCodeConstants.*;

/**
 * 脚本抓取控制 Service 实现类
 *
 * @author 合适连接器
 */
@Service
@Validated
public class GenghsGoodsServiceImpl implements GenghsGoodsService {

    @Resource
    private GenghsGoodsMapper genghsGoodsMapper;

    @Override
    public Long createGenghsGoods(GenghsGoodsSaveReqVO createReqVO) {
        // 插入
        GenghsGoodsDO genghsGoods = BeanUtils.toBean(createReqVO, GenghsGoodsDO.class);
        genghsGoodsMapper.insert(genghsGoods);
        // 返回
        return genghsGoods.getId();
    }

    @Override
    public void updateGenghsGoods(GenghsGoodsSaveReqVO updateReqVO) {
        // 校验存在
        validateGenghsGoodsExists(updateReqVO.getId());
        // 更新
        GenghsGoodsDO updateObj = BeanUtils.toBean(updateReqVO, GenghsGoodsDO.class);
        genghsGoodsMapper.updateById(updateObj);
    }

    @Override
    public void deleteGenghsGoods(Long id) {
        // 校验存在
        validateGenghsGoodsExists(id);
        // 删除
        genghsGoodsMapper.deleteById(id);
    }

    private void validateGenghsGoodsExists(Long id) {
        if (genghsGoodsMapper.selectById(id) == null) {
            throw exception(GENGHS_GOODS_NOT_EXISTS);
        }
    }

    @Override
    public GenghsGoodsDO getGenghsGoods(Long id) {
        return genghsGoodsMapper.selectById(id);
    }

    @Override
    public PageResult<GenghsGoodsDO> getGenghsGoodsPage(GenghsGoodsPageReqVO pageReqVO) {
        return genghsGoodsMapper.selectPage(pageReqVO);
    }

}