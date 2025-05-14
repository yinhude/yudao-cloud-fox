package cn.iocoder.yudao.module.bproduct.service.images;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.bproduct.controller.admin.images.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.images.ImagesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 图片 Service 接口
 *
 * @author 合适连接器
 */
public interface ImagesService {

    /**
     * 创建图片
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createImages(@Valid ImagesSaveReqVO createReqVO);

    /**
     * 更新图片
     *
     * @param updateReqVO 更新信息
     */
    void updateImages(@Valid ImagesSaveReqVO updateReqVO);

    /**
     * 删除图片
     *
     * @param id 编号
     */
    void deleteImages(Long id);

    /**
     * 获得图片
     *
     * @param id 编号
     * @return 图片
     */
    ImagesDO getImages(Long id);

    /**
     * 获得图片分页
     *
     * @param pageReqVO 分页查询
     * @return 图片分页
     */
    PageResult<ImagesDO> getImagesPage(ImagesPageReqVO pageReqVO);

}