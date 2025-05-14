package cn.iocoder.yudao.module.bproduct.controller.admin.partelvcompliance;

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

import cn.iocoder.yudao.module.bproduct.controller.admin.partelvcompliance.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partelvcompliance.PartElvComplianceDO;
import cn.iocoder.yudao.module.bproduct.service.partelvcompliance.PartElvComplianceService;

@Tag(name = "管理后台 - elv合规数据")
@RestController
@RequestMapping("/bproduct/part-elv-compliance")
@Validated
public class PartElvComplianceController {

    @Resource
    private PartElvComplianceService partElvComplianceService;

    @PostMapping("/create")
    @Operation(summary = "创建elv合规数据")
    @PreAuthorize("@ss.hasPermission('bproduct:part-elv-compliance:create')")
    public CommonResult<Long> createPartElvCompliance(@Valid @RequestBody PartElvComplianceSaveReqVO createReqVO) {
        return success(partElvComplianceService.createPartElvCompliance(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新elv合规数据")
    @PreAuthorize("@ss.hasPermission('bproduct:part-elv-compliance:update')")
    public CommonResult<Boolean> updatePartElvCompliance(@Valid @RequestBody PartElvComplianceSaveReqVO updateReqVO) {
        partElvComplianceService.updatePartElvCompliance(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除elv合规数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bproduct:part-elv-compliance:delete')")
    public CommonResult<Boolean> deletePartElvCompliance(@RequestParam("id") Long id) {
        partElvComplianceService.deletePartElvCompliance(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得elv合规数据")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bproduct:part-elv-compliance:query')")
    public CommonResult<PartElvComplianceRespVO> getPartElvCompliance(@RequestParam("id") Long id) {
        PartElvComplianceDO partElvCompliance = partElvComplianceService.getPartElvCompliance(id);
        return success(BeanUtils.toBean(partElvCompliance, PartElvComplianceRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得elv合规数据分页")
    @PreAuthorize("@ss.hasPermission('bproduct:part-elv-compliance:query')")
    public CommonResult<PageResult<PartElvComplianceRespVO>> getPartElvCompliancePage(@Valid PartElvCompliancePageReqVO pageReqVO) {
        PageResult<PartElvComplianceDO> pageResult = partElvComplianceService.getPartElvCompliancePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, PartElvComplianceRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出elv合规数据 Excel")
    @PreAuthorize("@ss.hasPermission('bproduct:part-elv-compliance:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportPartElvComplianceExcel(@Valid PartElvCompliancePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<PartElvComplianceDO> list = partElvComplianceService.getPartElvCompliancePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "elv合规数据.xls", "数据", PartElvComplianceRespVO.class,
                        BeanUtils.toBean(list, PartElvComplianceRespVO.class));
    }

}