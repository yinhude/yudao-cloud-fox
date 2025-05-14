package cn.iocoder.yudao.module.bproduct.controller.admin.images;

import cn.iocoder.yudao.framework.tenant.core.aop.TenantIgnore;
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

import cn.iocoder.yudao.module.bproduct.controller.admin.images.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.images.ImagesDO;
import cn.iocoder.yudao.module.bproduct.service.images.ImagesService;

@Tag(name = "管理后台 - 图片")
@RestController
@RequestMapping("/bproduct/images")
@Validated
public class ImagesController {

    @Resource
    private ImagesService imagesService;

    @PostMapping("/create")
    @Operation(summary = "创建图片")
    @PreAuthorize("@ss.hasPermission('bproduct:images:create')")
    public CommonResult<Long> createImages(@Valid @RequestBody ImagesSaveReqVO createReqVO) {
        return success(imagesService.createImages(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新图片")
    @PreAuthorize("@ss.hasPermission('bproduct:images:update')")
    public CommonResult<Boolean> updateImages(@Valid @RequestBody ImagesSaveReqVO updateReqVO) {
        imagesService.updateImages(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除图片")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bproduct:images:delete')")
    public CommonResult<Boolean> deleteImages(@RequestParam("id") Long id) {
        imagesService.deleteImages(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得图片")
    @TenantIgnore
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bproduct:images:query')")
    public CommonResult<ImagesRespVO> getImages(@RequestParam("id") Long id) {
        ImagesDO images = imagesService.getImages(id);
        return success(BeanUtils.toBean(images, ImagesRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得图片分页")
    @TenantIgnore
    @PreAuthorize("@ss.hasPermission('bproduct:images:query')")
    public CommonResult<PageResult<ImagesRespVO>> getImagesPage(@Valid ImagesPageReqVO pageReqVO) {
        PageResult<ImagesDO> pageResult = imagesService.getImagesPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ImagesRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出图片 Excel")
    @PreAuthorize("@ss.hasPermission('bproduct:images:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportImagesExcel(@Valid ImagesPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ImagesDO> list = imagesService.getImagesPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "图片.xls", "数据", ImagesRespVO.class,
                        BeanUtils.toBean(list, ImagesRespVO.class));
    }

}