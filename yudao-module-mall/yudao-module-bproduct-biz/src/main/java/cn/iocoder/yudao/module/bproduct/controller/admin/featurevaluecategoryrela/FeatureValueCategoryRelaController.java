package cn.iocoder.yudao.module.bproduct.controller.admin.featurevaluecategoryrela;

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

import cn.iocoder.yudao.module.bproduct.controller.admin.featurevaluecategoryrela.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.featurevaluecategoryrela.FeatureValueCategoryRelaDO;
import cn.iocoder.yudao.module.bproduct.service.featurevaluecategoryrela.FeatureValueCategoryRelaService;

@Tag(name = "管理后台 - 特征值关联")
@RestController
@RequestMapping("/bproduct/feature-value-category-rela")
@Validated
public class FeatureValueCategoryRelaController {

    @Resource
    private FeatureValueCategoryRelaService featureValueCategoryRelaService;

    @PostMapping("/create")
    @Operation(summary = "创建特征值关联")
    @PreAuthorize("@ss.hasPermission('bproduct:feature-value-category-rela:create')")
    public CommonResult<Long> createFeatureValueCategoryRela(@Valid @RequestBody FeatureValueCategoryRelaSaveReqVO createReqVO) {
        return success(featureValueCategoryRelaService.createFeatureValueCategoryRela(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新特征值关联")
    @PreAuthorize("@ss.hasPermission('bproduct:feature-value-category-rela:update')")
    public CommonResult<Boolean> updateFeatureValueCategoryRela(@Valid @RequestBody FeatureValueCategoryRelaSaveReqVO updateReqVO) {
        featureValueCategoryRelaService.updateFeatureValueCategoryRela(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除特征值关联")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bproduct:feature-value-category-rela:delete')")
    public CommonResult<Boolean> deleteFeatureValueCategoryRela(@RequestParam("id") Long id) {
        featureValueCategoryRelaService.deleteFeatureValueCategoryRela(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得特征值关联")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bproduct:feature-value-category-rela:query')")
    public CommonResult<FeatureValueCategoryRelaRespVO> getFeatureValueCategoryRela(@RequestParam("id") Long id) {
        FeatureValueCategoryRelaDO featureValueCategoryRela = featureValueCategoryRelaService.getFeatureValueCategoryRela(id);
        return success(BeanUtils.toBean(featureValueCategoryRela, FeatureValueCategoryRelaRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得特征值关联分页")
    @PreAuthorize("@ss.hasPermission('bproduct:feature-value-category-rela:query')")
    public CommonResult<PageResult<FeatureValueCategoryRelaRespVO>> getFeatureValueCategoryRelaPage(@Valid FeatureValueCategoryRelaPageReqVO pageReqVO) {
        PageResult<FeatureValueCategoryRelaDO> pageResult = featureValueCategoryRelaService.getFeatureValueCategoryRelaPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, FeatureValueCategoryRelaRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出特征值关联 Excel")
    @PreAuthorize("@ss.hasPermission('bproduct:feature-value-category-rela:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportFeatureValueCategoryRelaExcel(@Valid FeatureValueCategoryRelaPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<FeatureValueCategoryRelaDO> list = featureValueCategoryRelaService.getFeatureValueCategoryRelaPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "特征值关联.xls", "数据", FeatureValueCategoryRelaRespVO.class,
                        BeanUtils.toBean(list, FeatureValueCategoryRelaRespVO.class));
    }

}