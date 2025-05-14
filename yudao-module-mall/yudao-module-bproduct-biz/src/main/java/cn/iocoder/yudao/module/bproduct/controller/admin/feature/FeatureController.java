package cn.iocoder.yudao.module.bproduct.controller.admin.feature;

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

import cn.iocoder.yudao.module.bproduct.controller.admin.feature.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.feature.FeatureDO;
import cn.iocoder.yudao.module.bproduct.service.feature.FeatureService;

@Tag(name = "管理后台 - 特征")
@RestController
@RequestMapping("/bproduct/feature")
@Validated
public class FeatureController {

    @Resource
    private FeatureService featureService;

    @PostMapping("/create")
    @Operation(summary = "创建特征")
    @PreAuthorize("@ss.hasPermission('bproduct:feature:create')")
    public CommonResult<Long> createFeature(@Valid @RequestBody FeatureSaveReqVO createReqVO) {
        return success(featureService.createFeature(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新特征")
    @PreAuthorize("@ss.hasPermission('bproduct:feature:update')")
    public CommonResult<Boolean> updateFeature(@Valid @RequestBody FeatureSaveReqVO updateReqVO) {
        featureService.updateFeature(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除特征")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bproduct:feature:delete')")
    public CommonResult<Boolean> deleteFeature(@RequestParam("id") Long id) {
        featureService.deleteFeature(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得特征")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bproduct:feature:query')")
    public CommonResult<FeatureRespVO> getFeature(@RequestParam("id") Long id) {
        FeatureDO feature = featureService.getFeature(id);
        return success(BeanUtils.toBean(feature, FeatureRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得特征分页")
    @PreAuthorize("@ss.hasPermission('bproduct:feature:query')")
    public CommonResult<PageResult<FeatureRespVO>> getFeaturePage(@Valid FeaturePageReqVO pageReqVO) {
        PageResult<FeatureDO> pageResult = featureService.getFeaturePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, FeatureRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出特征 Excel")
    @PreAuthorize("@ss.hasPermission('bproduct:feature:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportFeatureExcel(@Valid FeaturePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<FeatureDO> list = featureService.getFeaturePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "特征.xls", "数据", FeatureRespVO.class,
                        BeanUtils.toBean(list, FeatureRespVO.class));
    }

}