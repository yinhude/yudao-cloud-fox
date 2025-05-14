package cn.iocoder.yudao.module.bproduct.controller.admin.partrohs10compliance;

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

import cn.iocoder.yudao.module.bproduct.controller.admin.partrohs10compliance.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partrohs10compliance.PartRohs10ComplianceDO;
import cn.iocoder.yudao.module.bproduct.service.partrohs10compliance.PartRohs10ComplianceService;

@Tag(name = "管理后台 - rohs合规性")
@RestController
@RequestMapping("/bproduct/part-rohs10-compliance")
@Validated
public class PartRohs10ComplianceController {

    @Resource
    private PartRohs10ComplianceService partRohs10ComplianceService;

    @PostMapping("/create")
    @Operation(summary = "创建rohs合规性")
    @PreAuthorize("@ss.hasPermission('bproduct:part-rohs10-compliance:create')")
    public CommonResult<Long> createPartRohs10Compliance(@Valid @RequestBody PartRohs10ComplianceSaveReqVO createReqVO) {
        return success(partRohs10ComplianceService.createPartRohs10Compliance(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新rohs合规性")
    @PreAuthorize("@ss.hasPermission('bproduct:part-rohs10-compliance:update')")
    public CommonResult<Boolean> updatePartRohs10Compliance(@Valid @RequestBody PartRohs10ComplianceSaveReqVO updateReqVO) {
        partRohs10ComplianceService.updatePartRohs10Compliance(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除rohs合规性")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bproduct:part-rohs10-compliance:delete')")
    public CommonResult<Boolean> deletePartRohs10Compliance(@RequestParam("id") Long id) {
        partRohs10ComplianceService.deletePartRohs10Compliance(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得rohs合规性")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bproduct:part-rohs10-compliance:query')")
    public CommonResult<PartRohs10ComplianceRespVO> getPartRohs10Compliance(@RequestParam("id") Long id) {
        PartRohs10ComplianceDO partRohs10Compliance = partRohs10ComplianceService.getPartRohs10Compliance(id);
        return success(BeanUtils.toBean(partRohs10Compliance, PartRohs10ComplianceRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得rohs合规性分页")
    @PreAuthorize("@ss.hasPermission('bproduct:part-rohs10-compliance:query')")
    public CommonResult<PageResult<PartRohs10ComplianceRespVO>> getPartRohs10CompliancePage(@Valid PartRohs10CompliancePageReqVO pageReqVO) {
        PageResult<PartRohs10ComplianceDO> pageResult = partRohs10ComplianceService.getPartRohs10CompliancePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, PartRohs10ComplianceRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出rohs合规性 Excel")
    @PreAuthorize("@ss.hasPermission('bproduct:part-rohs10-compliance:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportPartRohs10ComplianceExcel(@Valid PartRohs10CompliancePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<PartRohs10ComplianceDO> list = partRohs10ComplianceService.getPartRohs10CompliancePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "rohs合规性.xls", "数据", PartRohs10ComplianceRespVO.class,
                        BeanUtils.toBean(list, PartRohs10ComplianceRespVO.class));
    }

}