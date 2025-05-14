package cn.iocoder.yudao.module.bproduct.controller.admin.featurevalue;

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

import cn.iocoder.yudao.module.bproduct.controller.admin.featurevalue.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.featurevalue.FeatureValueDO;
import cn.iocoder.yudao.module.bproduct.service.featurevalue.FeatureValueService;

@Tag(name = "管理后台 - 特征值")
@RestController
@RequestMapping("/bproduct/feature-value")
@Validated
public class FeatureValueController {

    @Resource
    private FeatureValueService featureValueService;

    @PostMapping("/create")
    @Operation(summary = "创建特征值")
    @PreAuthorize("@ss.hasPermission('bproduct:feature-value:create')")
    public CommonResult<Long> createFeatureValue(@Valid @RequestBody FeatureValueSaveReqVO createReqVO) {
        return success(featureValueService.createFeatureValue(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新特征值")
    @PreAuthorize("@ss.hasPermission('bproduct:feature-value:update')")
    public CommonResult<Boolean> updateFeatureValue(@Valid @RequestBody FeatureValueSaveReqVO updateReqVO) {
        featureValueService.updateFeatureValue(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除特征值")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bproduct:feature-value:delete')")
    public CommonResult<Boolean> deleteFeatureValue(@RequestParam("id") Long id) {
        featureValueService.deleteFeatureValue(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得特征值")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bproduct:feature-value:query')")
    public CommonResult<FeatureValueRespVO> getFeatureValue(@RequestParam("id") Long id) {
        FeatureValueDO featureValue = featureValueService.getFeatureValue(id);
        return success(BeanUtils.toBean(featureValue, FeatureValueRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得特征值分页")
    @PreAuthorize("@ss.hasPermission('bproduct:feature-value:query')")
    public CommonResult<PageResult<FeatureValueRespVO>> getFeatureValuePage(@Valid FeatureValuePageReqVO pageReqVO) {
        PageResult<FeatureValueDO> pageResult = featureValueService.getFeatureValuePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, FeatureValueRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出特征值 Excel")
    @PreAuthorize("@ss.hasPermission('bproduct:feature-value:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportFeatureValueExcel(@Valid FeatureValuePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<FeatureValueDO> list = featureValueService.getFeatureValuePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "特征值.xls", "数据", FeatureValueRespVO.class,
                        BeanUtils.toBean(list, FeatureValueRespVO.class));
    }

}