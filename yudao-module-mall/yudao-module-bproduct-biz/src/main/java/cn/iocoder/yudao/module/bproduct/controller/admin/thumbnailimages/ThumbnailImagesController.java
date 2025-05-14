package cn.iocoder.yudao.module.bproduct.controller.admin.thumbnailimages;

import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import jakarta.validation.constraints.*;
import jakarta.validation.*;
import jakarta.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.bproduct.controller.admin.thumbnailimages.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.thumbnailimages.ThumbnailImagesDO;
import cn.iocoder.yudao.module.bproduct.service.thumbnailimages.ThumbnailImagesService;

@Tag(name = "管理后台 - 商品缩略图")
@RestController
@RequestMapping("/bproduct/thumbnail-images")
@Validated
public class ThumbnailImagesController {

    @Resource
    private ThumbnailImagesService thumbnailImagesService;

    @PostMapping("/create")
    @Operation(summary = "创建商品缩略图")
    @PreAuthorize("@ss.hasPermission('bproduct:thumbnail-images:create')")
    public CommonResult<Long> createThumbnailImages(@Valid @RequestBody ThumbnailImagesSaveReqVO createReqVO) {
        return success(thumbnailImagesService.createThumbnailImages(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新商品缩略图")
    @PreAuthorize("@ss.hasPermission('bproduct:thumbnail-images:update')")
    public CommonResult<Boolean> updateThumbnailImages(@Valid @RequestBody ThumbnailImagesSaveReqVO updateReqVO) {
        thumbnailImagesService.updateThumbnailImages(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除商品缩略图")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bproduct:thumbnail-images:delete')")
    public CommonResult<Boolean> deleteThumbnailImages(@RequestParam("id") Long id) {
        thumbnailImagesService.deleteThumbnailImages(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得商品缩略图")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bproduct:thumbnail-images:query')")
    public CommonResult<ThumbnailImagesRespVO> getThumbnailImages(@RequestParam("id") Long id) {
        ThumbnailImagesDO thumbnailImages = thumbnailImagesService.getThumbnailImages(id);
        return success(BeanUtils.toBean(thumbnailImages, ThumbnailImagesRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得商品缩略图分页")
    @PreAuthorize("@ss.hasPermission('bproduct:thumbnail-images:query')")
    public CommonResult<PageResult<ThumbnailImagesRespVO>> getThumbnailImagesPage(@Valid ThumbnailImagesPageReqVO pageReqVO) {
        PageResult<ThumbnailImagesDO> pageResult = thumbnailImagesService.getThumbnailImagesPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ThumbnailImagesRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出商品缩略图 Excel")
    @PreAuthorize("@ss.hasPermission('bproduct:thumbnail-images:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportThumbnailImagesExcel(@Valid ThumbnailImagesPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ThumbnailImagesDO> list = thumbnailImagesService.getThumbnailImagesPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "商品缩略图.xls", "数据", ThumbnailImagesRespVO.class,
                        BeanUtils.toBean(list, ThumbnailImagesRespVO.class));
    }

}