package cn.iocoder.yudao.module.bproduct.controller.admin.partelvnotcompliantsubstances;

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

import cn.iocoder.yudao.module.bproduct.controller.admin.partelvnotcompliantsubstances.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partelvnotcompliantsubstances.PartElvNotCompliantSubstancesDO;
import cn.iocoder.yudao.module.bproduct.service.partelvnotcompliantsubstances.PartElvNotCompliantSubstancesService;

@Tag(name = "管理后台 - elv不合规含量子")
@RestController
@RequestMapping("/bproduct/part-elv-not-compliant-substances")
@Validated
public class PartElvNotCompliantSubstancesController {

    @Resource
    private PartElvNotCompliantSubstancesService partElvNotCompliantSubstancesService;

    @PostMapping("/create")
    @Operation(summary = "创建elv不合规含量子")
    @PreAuthorize("@ss.hasPermission('bproduct:part-elv-not-compliant-substances:create')")
    public CommonResult<Long> createPartElvNotCompliantSubstances(@Valid @RequestBody PartElvNotCompliantSubstancesSaveReqVO createReqVO) {
        return success(partElvNotCompliantSubstancesService.createPartElvNotCompliantSubstances(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新elv不合规含量子")
    @PreAuthorize("@ss.hasPermission('bproduct:part-elv-not-compliant-substances:update')")
    public CommonResult<Boolean> updatePartElvNotCompliantSubstances(@Valid @RequestBody PartElvNotCompliantSubstancesSaveReqVO updateReqVO) {
        partElvNotCompliantSubstancesService.updatePartElvNotCompliantSubstances(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除elv不合规含量子")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bproduct:part-elv-not-compliant-substances:delete')")
    public CommonResult<Boolean> deletePartElvNotCompliantSubstances(@RequestParam("id") Long id) {
        partElvNotCompliantSubstancesService.deletePartElvNotCompliantSubstances(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得elv不合规含量子")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bproduct:part-elv-not-compliant-substances:query')")
    public CommonResult<PartElvNotCompliantSubstancesRespVO> getPartElvNotCompliantSubstances(@RequestParam("id") Long id) {
        PartElvNotCompliantSubstancesDO partElvNotCompliantSubstances = partElvNotCompliantSubstancesService.getPartElvNotCompliantSubstances(id);
        return success(BeanUtils.toBean(partElvNotCompliantSubstances, PartElvNotCompliantSubstancesRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得elv不合规含量子分页")
    @PreAuthorize("@ss.hasPermission('bproduct:part-elv-not-compliant-substances:query')")
    public CommonResult<PageResult<PartElvNotCompliantSubstancesRespVO>> getPartElvNotCompliantSubstancesPage(@Valid PartElvNotCompliantSubstancesPageReqVO pageReqVO) {
        PageResult<PartElvNotCompliantSubstancesDO> pageResult = partElvNotCompliantSubstancesService.getPartElvNotCompliantSubstancesPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, PartElvNotCompliantSubstancesRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出elv不合规含量子 Excel")
    @PreAuthorize("@ss.hasPermission('bproduct:part-elv-not-compliant-substances:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportPartElvNotCompliantSubstancesExcel(@Valid PartElvNotCompliantSubstancesPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<PartElvNotCompliantSubstancesDO> list = partElvNotCompliantSubstancesService.getPartElvNotCompliantSubstancesPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "elv不合规含量子.xls", "数据", PartElvNotCompliantSubstancesRespVO.class,
                        BeanUtils.toBean(list, PartElvNotCompliantSubstancesRespVO.class));
    }

}