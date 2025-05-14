package cn.iocoder.yudao.module.bproduct.controller.admin.similar;

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

import cn.iocoder.yudao.module.bproduct.controller.admin.similar.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.similar.SimilarDO;
import cn.iocoder.yudao.module.bproduct.service.similar.SimilarService;

@Tag(name = "管理后台 - 商品替代品")
@RestController
@RequestMapping("/bproduct/similar")
@Validated
public class SimilarController {

    @Resource
    private SimilarService similarService;

    @PostMapping("/create")
    @Operation(summary = "创建商品替代品")
    @PreAuthorize("@ss.hasPermission('bproduct:similar:create')")
    public CommonResult<Long> createSimilar(@Valid @RequestBody SimilarSaveReqVO createReqVO) {
        return success(similarService.createSimilar(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新商品替代品")
    @PreAuthorize("@ss.hasPermission('bproduct:similar:update')")
    public CommonResult<Boolean> updateSimilar(@Valid @RequestBody SimilarSaveReqVO updateReqVO) {
        similarService.updateSimilar(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除商品替代品")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bproduct:similar:delete')")
    public CommonResult<Boolean> deleteSimilar(@RequestParam("id") Long id) {
        similarService.deleteSimilar(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得商品替代品")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bproduct:similar:query')")
    public CommonResult<SimilarRespVO> getSimilar(@RequestParam("id") Long id) {
        SimilarDO similar = similarService.getSimilar(id);
        return success(BeanUtils.toBean(similar, SimilarRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得商品替代品分页")
    @PreAuthorize("@ss.hasPermission('bproduct:similar:query')")
    public CommonResult<PageResult<SimilarRespVO>> getSimilarPage(@Valid SimilarPageReqVO pageReqVO) {
        PageResult<SimilarDO> pageResult = similarService.getSimilarPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, SimilarRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出商品替代品 Excel")
    @PreAuthorize("@ss.hasPermission('bproduct:similar:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportSimilarExcel(@Valid SimilarPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<SimilarDO> list = similarService.getSimilarPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "商品替代品.xls", "数据", SimilarRespVO.class,
                        BeanUtils.toBean(list, SimilarRespVO.class));
    }

}