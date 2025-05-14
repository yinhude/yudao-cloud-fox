package cn.iocoder.yudao.module.bproduct.controller.admin.selfproductcategoryrela;

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

import cn.iocoder.yudao.module.bproduct.controller.admin.selfproductcategoryrela.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.selfproductcategoryrela.SelfProductCategoryRelaDO;
import cn.iocoder.yudao.module.bproduct.service.selfproductcategoryrela.SelfProductCategoryRelaService;

@Tag(name = "管理后台 - 产品和自有分类的关联性")
@RestController
@RequestMapping("/bproduct/self-product-category-rela")
@Validated
public class SelfProductCategoryRelaController {

    @Resource
    private SelfProductCategoryRelaService selfProductCategoryRelaService;

    @PostMapping("/create")
    @Operation(summary = "创建产品和自有分类的关联性")
    @PreAuthorize("@ss.hasPermission('bproduct:self-product-category-rela:create')")
    public CommonResult<Long> createSelfProductCategoryRela(@Valid @RequestBody SelfProductCategoryRelaSaveReqVO createReqVO) {
        return success(selfProductCategoryRelaService.createSelfProductCategoryRela(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新产品和自有分类的关联性")
    @PreAuthorize("@ss.hasPermission('bproduct:self-product-category-rela:update')")
    public CommonResult<Boolean> updateSelfProductCategoryRela(@Valid @RequestBody SelfProductCategoryRelaSaveReqVO updateReqVO) {
        selfProductCategoryRelaService.updateSelfProductCategoryRela(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除产品和自有分类的关联性")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bproduct:self-product-category-rela:delete')")
    public CommonResult<Boolean> deleteSelfProductCategoryRela(@RequestParam("id") Long id) {
        selfProductCategoryRelaService.deleteSelfProductCategoryRela(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得产品和自有分类的关联性")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bproduct:self-product-category-rela:query')")
    public CommonResult<SelfProductCategoryRelaRespVO> getSelfProductCategoryRela(@RequestParam("id") Long id) {
        SelfProductCategoryRelaDO selfProductCategoryRela = selfProductCategoryRelaService.getSelfProductCategoryRela(id);
        return success(BeanUtils.toBean(selfProductCategoryRela, SelfProductCategoryRelaRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得产品和自有分类的关联性分页")
    @PreAuthorize("@ss.hasPermission('bproduct:self-product-category-rela:query')")
    public CommonResult<PageResult<SelfProductCategoryRelaRespVO>> getSelfProductCategoryRelaPage(@Valid SelfProductCategoryRelaPageReqVO pageReqVO) {
        PageResult<SelfProductCategoryRelaDO> pageResult = selfProductCategoryRelaService.getSelfProductCategoryRelaPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, SelfProductCategoryRelaRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出产品和自有分类的关联性 Excel")
    @PreAuthorize("@ss.hasPermission('bproduct:self-product-category-rela:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportSelfProductCategoryRelaExcel(@Valid SelfProductCategoryRelaPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<SelfProductCategoryRelaDO> list = selfProductCategoryRelaService.getSelfProductCategoryRelaPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "产品和自有分类的关联性.xls", "数据", SelfProductCategoryRelaRespVO.class,
                        BeanUtils.toBean(list, SelfProductCategoryRelaRespVO.class));
    }

}