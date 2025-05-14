package cn.iocoder.yudao.module.bproduct.controller.admin.primaryimages;

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

import cn.iocoder.yudao.module.bproduct.controller.admin.primaryimages.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.primaryimages.PrimaryImagesDO;
import cn.iocoder.yudao.module.bproduct.service.primaryimages.PrimaryImagesService;

@Tag(name = "管理后台 - 商品主图")
@RestController
@RequestMapping("/bproduct/primary-images")
@Validated
public class PrimaryImagesController {

    @Resource
    private PrimaryImagesService primaryImagesService;

    @PostMapping("/create")
    @Operation(summary = "创建商品主图")
    @PreAuthorize("@ss.hasPermission('bproduct:primary-images:create')")
    public CommonResult<Long> createPrimaryImages(@Valid @RequestBody PrimaryImagesSaveReqVO createReqVO) {
        return success(primaryImagesService.createPrimaryImages(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新商品主图")
    @PreAuthorize("@ss.hasPermission('bproduct:primary-images:update')")
    public CommonResult<Boolean> updatePrimaryImages(@Valid @RequestBody PrimaryImagesSaveReqVO updateReqVO) {
        primaryImagesService.updatePrimaryImages(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除商品主图")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bproduct:primary-images:delete')")
    public CommonResult<Boolean> deletePrimaryImages(@RequestParam("id") Long id) {
        primaryImagesService.deletePrimaryImages(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得商品主图")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bproduct:primary-images:query')")
    public CommonResult<PrimaryImagesRespVO> getPrimaryImages(@RequestParam("id") Long id) {
        PrimaryImagesDO primaryImages = primaryImagesService.getPrimaryImages(id);
        return success(BeanUtils.toBean(primaryImages, PrimaryImagesRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得商品主图分页")
    @PreAuthorize("@ss.hasPermission('bproduct:primary-images:query')")
    public CommonResult<PageResult<PrimaryImagesRespVO>> getPrimaryImagesPage(@Valid PrimaryImagesPageReqVO pageReqVO) {
        PageResult<PrimaryImagesDO> pageResult = primaryImagesService.getPrimaryImagesPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, PrimaryImagesRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出商品主图 Excel")
    @PreAuthorize("@ss.hasPermission('bproduct:primary-images:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportPrimaryImagesExcel(@Valid PrimaryImagesPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<PrimaryImagesDO> list = primaryImagesService.getPrimaryImagesPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "商品主图.xls", "数据", PrimaryImagesRespVO.class,
                        BeanUtils.toBean(list, PrimaryImagesRespVO.class));
    }

}