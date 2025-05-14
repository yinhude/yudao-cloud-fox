package cn.iocoder.yudao.module.bproduct.controller.admin.product;

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

import cn.iocoder.yudao.module.bproduct.controller.admin.product.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.product.ProductDO;
import cn.iocoder.yudao.module.bproduct.service.product.ProductService;

@Tag(name = "管理后台 - 商品系列")
@RestController
@RequestMapping("/bproduct/product")
@Validated
public class ProductController {

    @Resource
    private ProductService productService;

    @PostMapping("/create")
    @Operation(summary = "创建商品系列")
    @PreAuthorize("@ss.hasPermission('bproduct:product:create')")
    public CommonResult<Long> createProduct(@Valid @RequestBody ProductSaveReqVO createReqVO) {
        return success(productService.createProduct(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新商品系列")
    @PreAuthorize("@ss.hasPermission('bproduct:product:update')")
    public CommonResult<Boolean> updateProduct(@Valid @RequestBody ProductSaveReqVO updateReqVO) {
        productService.updateProduct(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除商品系列")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bproduct:product:delete')")
    public CommonResult<Boolean> deleteProduct(@RequestParam("id") Long id) {
        productService.deleteProduct(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得商品系列")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bproduct:product:query')")
    public CommonResult<ProductRespVO> getProduct(@RequestParam("id") Long id) {
        ProductDO product = productService.getProduct(id);
        return success(BeanUtils.toBean(product, ProductRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得商品系列分页")
    @PreAuthorize("@ss.hasPermission('bproduct:product:query')")
    public CommonResult<PageResult<ProductRespVO>> getProductPage(@Valid ProductPageReqVO pageReqVO) {
        PageResult<ProductDO> pageResult = productService.getProductPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ProductRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出商品系列 Excel")
    @PreAuthorize("@ss.hasPermission('bproduct:product:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportProductExcel(@Valid ProductPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ProductDO> list = productService.getProductPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "商品系列.xls", "数据", ProductRespVO.class,
                        BeanUtils.toBean(list, ProductRespVO.class));
    }

}