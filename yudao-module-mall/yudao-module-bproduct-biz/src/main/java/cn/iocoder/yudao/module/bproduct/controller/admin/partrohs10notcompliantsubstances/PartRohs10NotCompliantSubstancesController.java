package cn.iocoder.yudao.module.bproduct.controller.admin.partrohs10notcompliantsubstances;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.framework.tenant.core.aop.TenantIgnore;
import cn.iocoder.yudao.module.bproduct.controller.admin.partrohs10notcompliantsubstances.vo.PartRohs10NotCompliantSubstancesPageReqVO;
import cn.iocoder.yudao.module.bproduct.controller.admin.partrohs10notcompliantsubstances.vo.PartRohs10NotCompliantSubstancesRespVO;
import cn.iocoder.yudao.module.bproduct.controller.admin.partrohs10notcompliantsubstances.vo.PartRohs10NotCompliantSubstancesSaveReqVO;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partrohs10notcompliantsubstances.PartRohs10NotCompliantSubstancesDO;
import cn.iocoder.yudao.module.bproduct.service.partrohs10notcompliantsubstances.PartRohs10NotCompliantSubstancesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - rohs不符合的含量")
@RestController
@RequestMapping("/bproduct/part-rohs10-not-compliant-substances")
@Validated
public class PartRohs10NotCompliantSubstancesController {

    @Resource
    private PartRohs10NotCompliantSubstancesService partRohs10NotCompliantSubstancesService;

    @PostMapping("/create")
    @Operation(summary = "创建rohs不符合的含量")
    @PermitAll
    public CommonResult<Long> createPartRohs10NotCompliantSubstances(@Valid @RequestBody PartRohs10NotCompliantSubstancesSaveReqVO createReqVO) {
        return success(partRohs10NotCompliantSubstancesService.createPartRohs10NotCompliantSubstances(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新rohs不符合的含量")
    @PreAuthorize("@ss.hasPermission('bproduct:part-rohs10-not-compliant-substances:update')")
    public CommonResult<Boolean> updatePartRohs10NotCompliantSubstances(@Valid @RequestBody PartRohs10NotCompliantSubstancesSaveReqVO updateReqVO) {
        partRohs10NotCompliantSubstancesService.updatePartRohs10NotCompliantSubstances(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除rohs不符合的含量")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bproduct:part-rohs10-not-compliant-substances:delete')")
    public CommonResult<Boolean> deletePartRohs10NotCompliantSubstances(@RequestParam("id") Long id) {
        partRohs10NotCompliantSubstancesService.deletePartRohs10NotCompliantSubstances(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得rohs不符合的含量")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bproduct:part-rohs10-not-compliant-substances:query')")
    public CommonResult<PartRohs10NotCompliantSubstancesRespVO> getPartRohs10NotCompliantSubstances(@RequestParam("id") Long id) {
        PartRohs10NotCompliantSubstancesDO partRohs10NotCompliantSubstances = partRohs10NotCompliantSubstancesService.getPartRohs10NotCompliantSubstances(id);
        return success(BeanUtils.toBean(partRohs10NotCompliantSubstances, PartRohs10NotCompliantSubstancesRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得rohs不符合的含量分页")
    @TenantIgnore
    @PermitAll
    public CommonResult<PageResult<PartRohs10NotCompliantSubstancesRespVO>> getPartRohs10NotCompliantSubstancesPage(@Valid PartRohs10NotCompliantSubstancesPageReqVO pageReqVO) {
        PageResult<PartRohs10NotCompliantSubstancesDO> pageResult = partRohs10NotCompliantSubstancesService.getPartRohs10NotCompliantSubstancesPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, PartRohs10NotCompliantSubstancesRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出rohs不符合的含量 Excel")
    @PreAuthorize("@ss.hasPermission('bproduct:part-rohs10-not-compliant-substances:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportPartRohs10NotCompliantSubstancesExcel(@Valid PartRohs10NotCompliantSubstancesPageReqVO pageReqVO,
                                                            HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<PartRohs10NotCompliantSubstancesDO> list = partRohs10NotCompliantSubstancesService.getPartRohs10NotCompliantSubstancesPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "rohs不符合的含量.xls", "数据", PartRohs10NotCompliantSubstancesRespVO.class,
                BeanUtils.toBean(list, PartRohs10NotCompliantSubstancesRespVO.class));
    }

}