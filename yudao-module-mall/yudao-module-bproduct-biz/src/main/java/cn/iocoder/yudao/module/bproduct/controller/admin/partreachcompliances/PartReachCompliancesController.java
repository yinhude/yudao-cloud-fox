package cn.iocoder.yudao.module.bproduct.controller.admin.partreachcompliances;

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

import cn.iocoder.yudao.module.bproduct.controller.admin.partreachcompliances.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partreachcompliances.PartReachCompliancesDO;
import cn.iocoder.yudao.module.bproduct.service.partreachcompliances.PartReachCompliancesService;

@Tag(name = "管理后台 - reach合规性")
@RestController
@RequestMapping("/bproduct/part-reach-compliances")
@Validated
public class PartReachCompliancesController {

    @Resource
    private PartReachCompliancesService partReachCompliancesService;

    @PostMapping("/create")
    @Operation(summary = "创建reach合规性")
    @PreAuthorize("@ss.hasPermission('bproduct:part-reach-compliances:create')")
    public CommonResult<Long> createPartReachCompliances(@Valid @RequestBody PartReachCompliancesSaveReqVO createReqVO) {
        return success(partReachCompliancesService.createPartReachCompliances(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新reach合规性")
    @PreAuthorize("@ss.hasPermission('bproduct:part-reach-compliances:update')")
    public CommonResult<Boolean> updatePartReachCompliances(@Valid @RequestBody PartReachCompliancesSaveReqVO updateReqVO) {
        partReachCompliancesService.updatePartReachCompliances(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除reach合规性")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bproduct:part-reach-compliances:delete')")
    public CommonResult<Boolean> deletePartReachCompliances(@RequestParam("id") Long id) {
        partReachCompliancesService.deletePartReachCompliances(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得reach合规性")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bproduct:part-reach-compliances:query')")
    public CommonResult<PartReachCompliancesRespVO> getPartReachCompliances(@RequestParam("id") Long id) {
        PartReachCompliancesDO partReachCompliances = partReachCompliancesService.getPartReachCompliances(id);
        return success(BeanUtils.toBean(partReachCompliances, PartReachCompliancesRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得reach合规性分页")
    @PreAuthorize("@ss.hasPermission('bproduct:part-reach-compliances:query')")
    public CommonResult<PageResult<PartReachCompliancesRespVO>> getPartReachCompliancesPage(@Valid PartReachCompliancesPageReqVO pageReqVO) {
        PageResult<PartReachCompliancesDO> pageResult = partReachCompliancesService.getPartReachCompliancesPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, PartReachCompliancesRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出reach合规性 Excel")
    @PreAuthorize("@ss.hasPermission('bproduct:part-reach-compliances:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportPartReachCompliancesExcel(@Valid PartReachCompliancesPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<PartReachCompliancesDO> list = partReachCompliancesService.getPartReachCompliancesPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "reach合规性.xls", "数据", PartReachCompliancesRespVO.class,
                        BeanUtils.toBean(list, PartReachCompliancesRespVO.class));
    }

}