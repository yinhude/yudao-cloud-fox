package cn.iocoder.yudao.module.bproduct.controller.admin.partreachsvhcs;

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

import cn.iocoder.yudao.module.bproduct.controller.admin.partreachsvhcs.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.partreachsvhcs.PartReachSvhcsDO;
import cn.iocoder.yudao.module.bproduct.service.partreachsvhcs.PartReachSvhcsService;

@Tag(name = "管理后台 - reach合规性")
@RestController
@RequestMapping("/bproduct/part-reach-svhcs")
@Validated
public class PartReachSvhcsController {

    @Resource
    private PartReachSvhcsService partReachSvhcsService;

    @PostMapping("/create")
    @Operation(summary = "创建reach合规性")
    @PreAuthorize("@ss.hasPermission('bproduct:part-reach-svhcs:create')")
    public CommonResult<Long> createPartReachSvhcs(@Valid @RequestBody PartReachSvhcsSaveReqVO createReqVO) {
        return success(partReachSvhcsService.createPartReachSvhcs(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新reach合规性")
    @PreAuthorize("@ss.hasPermission('bproduct:part-reach-svhcs:update')")
    public CommonResult<Boolean> updatePartReachSvhcs(@Valid @RequestBody PartReachSvhcsSaveReqVO updateReqVO) {
        partReachSvhcsService.updatePartReachSvhcs(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除reach合规性")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bproduct:part-reach-svhcs:delete')")
    public CommonResult<Boolean> deletePartReachSvhcs(@RequestParam("id") Long id) {
        partReachSvhcsService.deletePartReachSvhcs(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得reach合规性")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bproduct:part-reach-svhcs:query')")
    public CommonResult<PartReachSvhcsRespVO> getPartReachSvhcs(@RequestParam("id") Long id) {
        PartReachSvhcsDO partReachSvhcs = partReachSvhcsService.getPartReachSvhcs(id);
        return success(BeanUtils.toBean(partReachSvhcs, PartReachSvhcsRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得reach合规性分页")
    @PreAuthorize("@ss.hasPermission('bproduct:part-reach-svhcs:query')")
    public CommonResult<PageResult<PartReachSvhcsRespVO>> getPartReachSvhcsPage(@Valid PartReachSvhcsPageReqVO pageReqVO) {
        PageResult<PartReachSvhcsDO> pageResult = partReachSvhcsService.getPartReachSvhcsPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, PartReachSvhcsRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出reach合规性 Excel")
    @PreAuthorize("@ss.hasPermission('bproduct:part-reach-svhcs:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportPartReachSvhcsExcel(@Valid PartReachSvhcsPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<PartReachSvhcsDO> list = partReachSvhcsService.getPartReachSvhcsPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "reach合规性.xls", "数据", PartReachSvhcsRespVO.class,
                        BeanUtils.toBean(list, PartReachSvhcsRespVO.class));
    }

}