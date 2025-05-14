package cn.iocoder.yudao.module.bproduct.controller.admin.partchinarohscompliance;

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

import cn.iocoder.yudao.module.bproduct.controller.admin.partchinarohscompliance.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partchinarohscompliance.PartChinaRohsComplianceDO;
import cn.iocoder.yudao.module.bproduct.service.partchinarohscompliance.PartChinaRohsComplianceService;

@Tag(name = "管理后台 - rohs")
@RestController
@RequestMapping("/bproduct/part-china-rohs-compliance")
@Validated
public class PartChinaRohsComplianceController {

    @Resource
    private PartChinaRohsComplianceService partChinaRohsComplianceService;

    @PostMapping("/create")
    @Operation(summary = "创建rohs")
    @PreAuthorize("@ss.hasPermission('bproduct:part-china-rohs-compliance:create')")
    public CommonResult<Long> createPartChinaRohsCompliance(@Valid @RequestBody PartChinaRohsComplianceSaveReqVO createReqVO) {
        return success(partChinaRohsComplianceService.createPartChinaRohsCompliance(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新rohs")
    @PreAuthorize("@ss.hasPermission('bproduct:part-china-rohs-compliance:update')")
    public CommonResult<Boolean> updatePartChinaRohsCompliance(@Valid @RequestBody PartChinaRohsComplianceSaveReqVO updateReqVO) {
        partChinaRohsComplianceService.updatePartChinaRohsCompliance(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除rohs")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bproduct:part-china-rohs-compliance:delete')")
    public CommonResult<Boolean> deletePartChinaRohsCompliance(@RequestParam("id") Long id) {
        partChinaRohsComplianceService.deletePartChinaRohsCompliance(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得rohs")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bproduct:part-china-rohs-compliance:query')")
    public CommonResult<PartChinaRohsComplianceRespVO> getPartChinaRohsCompliance(@RequestParam("id") Long id) {
        PartChinaRohsComplianceDO partChinaRohsCompliance = partChinaRohsComplianceService.getPartChinaRohsCompliance(id);
        return success(BeanUtils.toBean(partChinaRohsCompliance, PartChinaRohsComplianceRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得rohs分页")
    @PreAuthorize("@ss.hasPermission('bproduct:part-china-rohs-compliance:query')")
    public CommonResult<PageResult<PartChinaRohsComplianceRespVO>> getPartChinaRohsCompliancePage(@Valid PartChinaRohsCompliancePageReqVO pageReqVO) {
        PageResult<PartChinaRohsComplianceDO> pageResult = partChinaRohsComplianceService.getPartChinaRohsCompliancePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, PartChinaRohsComplianceRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出rohs Excel")
    @PreAuthorize("@ss.hasPermission('bproduct:part-china-rohs-compliance:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportPartChinaRohsComplianceExcel(@Valid PartChinaRohsCompliancePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<PartChinaRohsComplianceDO> list = partChinaRohsComplianceService.getPartChinaRohsCompliancePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "rohs.xls", "数据", PartChinaRohsComplianceRespVO.class,
                        BeanUtils.toBean(list, PartChinaRohsComplianceRespVO.class));
    }

}