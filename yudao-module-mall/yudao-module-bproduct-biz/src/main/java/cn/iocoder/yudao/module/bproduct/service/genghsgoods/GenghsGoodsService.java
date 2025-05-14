package cn.iocoder.yudao.module.bproduct.service.genghsgoods;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.genghsgoods.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.genghsgoods.GenghsGoodsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 脚本抓取控制 Service 接口
 *
 * @author 合适连接器
 */
public interface GenghsGoodsService {

    /**
     * 创建脚本抓取控制
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createGenghsGoods(@Valid GenghsGoodsSaveReqVO createReqVO);

    /**
     * 更新脚本抓取控制
     *
     * @param updateReqVO 更新信息
     */
    void updateGenghsGoods(@Valid GenghsGoodsSaveReqVO updateReqVO);

    /**
     * 删除脚本抓取控制
     *
     * @param id 编号
     */
    void deleteGenghsGoods(Long id);

    /**
     * 获得脚本抓取控制
     *
     * @param id 编号
     * @return 脚本抓取控制
     */
    GenghsGoodsDO getGenghsGoods(Long id);

    /**
     * 获得脚本抓取控制分页
     *
     * @param pageReqVO 分页查询
     * @return 脚本抓取控制分页
     */
    PageResult<GenghsGoodsDO> getGenghsGoodsPage(GenghsGoodsPageReqVO pageReqVO);

}