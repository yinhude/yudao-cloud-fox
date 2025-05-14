package cn.iocoder.yudao.module.bproduct.controller.admin.partparts;

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

import cn.iocoder.yudao.module.bproduct.controller.admin.partparts.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partparts.PartPartsDO;
import cn.iocoder.yudao.module.bproduct.service.partparts.PartPartsService;

@Tag(name = "管理后台 - part合规性")
@RestController
@RequestMapping("/bproduct/part-parts")
@Validated
public class PartPartsController {

    @Resource
    private PartPartsService partPartsService;

    @PostMapping("/create")
    @Operation(summary = "创建part合规性")
    @PreAuthorize("@ss.hasPermission('bproduct:part-parts:create')")
    public CommonResult<Long> createPartParts(@Valid @RequestBody PartPartsSaveReqVO createReqVO) {
        return success(partPartsService.createPartParts(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新part合规性")
    @PreAuthorize("@ss.hasPermission('bproduct:part-parts:update')")
    public CommonResult<Boolean> updatePartParts(@Valid @RequestBody PartPartsSaveReqVO updateReqVO) {
        partPartsService.updatePartParts(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除part合规性")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bproduct:part-parts:delete')")
    public CommonResult<Boolean> deletePartParts(@RequestParam("id") Long id) {
        partPartsService.deletePartParts(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得part合规性")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bproduct:part-parts:query')")
    public CommonResult<PartPartsRespVO> getPartParts(@RequestParam("id") Long id) {
        PartPartsDO partParts = partPartsService.getPartParts(id);
        return success(BeanUtils.toBean(partParts, PartPartsRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得part合规性分页")
    @PreAuthorize("@ss.hasPermission('bproduct:part-parts:query')")
    public CommonResult<PageResult<PartPartsRespVO>> getPartPartsPage(@Valid PartPartsPageReqVO pageReqVO) {
        PageResult<PartPartsDO> pageResult = partPartsService.getPartPartsPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, PartPartsRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出part合规性 Excel")
    @PreAuthorize("@ss.hasPermission('bproduct:part-parts:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportPartPartsExcel(@Valid PartPartsPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<PartPartsDO> list = partPartsService.getPartPartsPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "part合规性.xls", "数据", PartPartsRespVO.class,
                        BeanUtils.toBean(list, PartPartsRespVO.class));
    }

}