package cn.iocoder.yudao.module.bproduct.controller.admin.genghsgoods;

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

import cn.iocoder.yudao.module.bproduct.controller.admin.genghsgoods.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.genghsgoods.GenghsGoodsDO;
import cn.iocoder.yudao.module.bproduct.service.genghsgoods.GenghsGoodsService;

@Tag(name = "管理后台 - 脚本抓取控制")
@RestController
@RequestMapping("/bproduct/genghs-goods")
@Validated
public class GenghsGoodsController {

    @Resource
    private GenghsGoodsService genghsGoodsService;

    @PostMapping("/create")
    @Operation(summary = "创建脚本抓取控制")
    @PreAuthorize("@ss.hasPermission('bproduct:genghs-goods:create')")
    public CommonResult<Long> createGenghsGoods(@Valid @RequestBody GenghsGoodsSaveReqVO createReqVO) {
        return success(genghsGoodsService.createGenghsGoods(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新脚本抓取控制")
    @PreAuthorize("@ss.hasPermission('bproduct:genghs-goods:update')")
    public CommonResult<Boolean> updateGenghsGoods(@Valid @RequestBody GenghsGoodsSaveReqVO updateReqVO) {
        genghsGoodsService.updateGenghsGoods(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除脚本抓取控制")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bproduct:genghs-goods:delete')")
    public CommonResult<Boolean> deleteGenghsGoods(@RequestParam("id") Long id) {
        genghsGoodsService.deleteGenghsGoods(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得脚本抓取控制")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bproduct:genghs-goods:query')")
    public CommonResult<GenghsGoodsRespVO> getGenghsGoods(@RequestParam("id") Long id) {
        GenghsGoodsDO genghsGoods = genghsGoodsService.getGenghsGoods(id);
        return success(BeanUtils.toBean(genghsGoods, GenghsGoodsRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得脚本抓取控制分页")
    @PreAuthorize("@ss.hasPermission('bproduct:genghs-goods:query')")
    public CommonResult<PageResult<GenghsGoodsRespVO>> getGenghsGoodsPage(@Valid GenghsGoodsPageReqVO pageReqVO) {
        PageResult<GenghsGoodsDO> pageResult = genghsGoodsService.getGenghsGoodsPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GenghsGoodsRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出脚本抓取控制 Excel")
    @PreAuthorize("@ss.hasPermission('bproduct:genghs-goods:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportGenghsGoodsExcel(@Valid GenghsGoodsPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GenghsGoodsDO> list = genghsGoodsService.getGenghsGoodsPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "脚本抓取控制.xls", "数据", GenghsGoodsRespVO.class,
                        BeanUtils.toBean(list, GenghsGoodsRespVO.class));
    }

}