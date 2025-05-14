package cn.iocoder.yudao.module.bproduct.controller.admin.featuregroup;

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

import cn.iocoder.yudao.module.bproduct.controller.admin.featuregroup.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.featuregroup.FeatureGroupDO;
import cn.iocoder.yudao.module.bproduct.service.featuregroup.FeatureGroupService;

@Tag(name = "管理后台 - 特征值分组")
@RestController
@RequestMapping("/bproduct/feature-group")
@Validated
public class FeatureGroupController {

    @Resource
    private FeatureGroupService featureGroupService;

    @PostMapping("/create")
    @Operation(summary = "创建特征值分组")
    @PreAuthorize("@ss.hasPermission('bproduct:feature-group:create')")
    public CommonResult<Long> createFeatureGroup(@Valid @RequestBody FeatureGroupSaveReqVO createReqVO) {
        return success(featureGroupService.createFeatureGroup(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新特征值分组")
    @PreAuthorize("@ss.hasPermission('bproduct:feature-group:update')")
    public CommonResult<Boolean> updateFeatureGroup(@Valid @RequestBody FeatureGroupSaveReqVO updateReqVO) {
        featureGroupService.updateFeatureGroup(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除特征值分组")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bproduct:feature-group:delete')")
    public CommonResult<Boolean> deleteFeatureGroup(@RequestParam("id") Long id) {
        featureGroupService.deleteFeatureGroup(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得特征值分组")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bproduct:feature-group:query')")
    public CommonResult<FeatureGroupRespVO> getFeatureGroup(@RequestParam("id") Long id) {
        FeatureGroupDO featureGroup = featureGroupService.getFeatureGroup(id);
        return success(BeanUtils.toBean(featureGroup, FeatureGroupRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得特征值分组分页")
    @PreAuthorize("@ss.hasPermission('bproduct:feature-group:query')")
    public CommonResult<PageResult<FeatureGroupRespVO>> getFeatureGroupPage(@Valid FeatureGroupPageReqVO pageReqVO) {
        PageResult<FeatureGroupDO> pageResult = featureGroupService.getFeatureGroupPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, FeatureGroupRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出特征值分组 Excel")
    @PreAuthorize("@ss.hasPermission('bproduct:feature-group:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportFeatureGroupExcel(@Valid FeatureGroupPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<FeatureGroupDO> list = featureGroupService.getFeatureGroupPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "特征值分组.xls", "数据", FeatureGroupRespVO.class,
                        BeanUtils.toBean(list, FeatureGroupRespVO.class));
    }

}