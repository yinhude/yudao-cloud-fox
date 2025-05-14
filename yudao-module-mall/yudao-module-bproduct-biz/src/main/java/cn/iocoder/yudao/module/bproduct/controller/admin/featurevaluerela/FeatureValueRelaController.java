package cn.iocoder.yudao.module.bproduct.controller.admin.featurevaluerela;

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

import cn.iocoder.yudao.module.bproduct.controller.admin.featurevaluerela.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.featurevaluerela.FeatureValueRelaDO;
import cn.iocoder.yudao.module.bproduct.service.featurevaluerela.FeatureValueRelaService;

@Tag(name = "管理后台 - 特征值关联")
@RestController
@RequestMapping("/bproduct/feature-value-rela")
@Validated
public class FeatureValueRelaController {

    @Resource
    private FeatureValueRelaService featureValueRelaService;

    @PostMapping("/create")
    @Operation(summary = "创建特征值关联")
    @PreAuthorize("@ss.hasPermission('bproduct:feature-value-rela:create')")
    public CommonResult<Long> createFeatureValueRela(@Valid @RequestBody FeatureValueRelaSaveReqVO createReqVO) {
        return success(featureValueRelaService.createFeatureValueRela(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新特征值关联")
    @PreAuthorize("@ss.hasPermission('bproduct:feature-value-rela:update')")
    public CommonResult<Boolean> updateFeatureValueRela(@Valid @RequestBody FeatureValueRelaSaveReqVO updateReqVO) {
        featureValueRelaService.updateFeatureValueRela(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除特征值关联")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bproduct:feature-value-rela:delete')")
    public CommonResult<Boolean> deleteFeatureValueRela(@RequestParam("id") Long id) {
        featureValueRelaService.deleteFeatureValueRela(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得特征值关联")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bproduct:feature-value-rela:query')")
    public CommonResult<FeatureValueRelaRespVO> getFeatureValueRela(@RequestParam("id") Long id) {
        FeatureValueRelaDO featureValueRela = featureValueRelaService.getFeatureValueRela(id);
        return success(BeanUtils.toBean(featureValueRela, FeatureValueRelaRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得特征值关联分页")
    @PreAuthorize("@ss.hasPermission('bproduct:feature-value-rela:query')")
    public CommonResult<PageResult<FeatureValueRelaRespVO>> getFeatureValueRelaPage(@Valid FeatureValueRelaPageReqVO pageReqVO) {
        PageResult<FeatureValueRelaDO> pageResult = featureValueRelaService.getFeatureValueRelaPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, FeatureValueRelaRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出特征值关联 Excel")
    @PreAuthorize("@ss.hasPermission('bproduct:feature-value-rela:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportFeatureValueRelaExcel(@Valid FeatureValueRelaPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<FeatureValueRelaDO> list = featureValueRelaService.getFeatureValueRelaPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "特征值关联.xls", "数据", FeatureValueRelaRespVO.class,
                        BeanUtils.toBean(list, FeatureValueRelaRespVO.class));
    }

}