package cn.iocoder.yudao.module.bproduct.controller.admin.documents;

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

import cn.iocoder.yudao.module.bproduct.controller.admin.documents.vo.*;
import cn.iocoder.yudao.module.bproduct.dal.dataobject.documents.DocumentsDO;
import cn.iocoder.yudao.module.bproduct.service.documents.DocumentsService;

@Tag(name = "管理后台 - 文档")
@RestController
@RequestMapping("/bproduct/documents")
@Validated
public class DocumentsController {

    @Resource
    private DocumentsService documentsService;

    @PostMapping("/create")
    @Operation(summary = "创建文档")
    @PreAuthorize("@ss.hasPermission('bproduct:documents:create')")
    public CommonResult<Long> createDocuments(@Valid @RequestBody DocumentsSaveReqVO createReqVO) {
        return success(documentsService.createDocuments(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新文档")
    @PreAuthorize("@ss.hasPermission('bproduct:documents:update')")
    public CommonResult<Boolean> updateDocuments(@Valid @RequestBody DocumentsSaveReqVO updateReqVO) {
        documentsService.updateDocuments(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除文档")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bproduct:documents:delete')")
    public CommonResult<Boolean> deleteDocuments(@RequestParam("id") Long id) {
        documentsService.deleteDocuments(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得文档")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bproduct:documents:query')")
    public CommonResult<DocumentsRespVO> getDocuments(@RequestParam("id") Long id) {
        DocumentsDO documents = documentsService.getDocuments(id);
        return success(BeanUtils.toBean(documents, DocumentsRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得文档分页")
    @PreAuthorize("@ss.hasPermission('bproduct:documents:query')")
    public CommonResult<PageResult<DocumentsRespVO>> getDocumentsPage(@Valid DocumentsPageReqVO pageReqVO) {
        PageResult<DocumentsDO> pageResult = documentsService.getDocumentsPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, DocumentsRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出文档 Excel")
    @PreAuthorize("@ss.hasPermission('bproduct:documents:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportDocumentsExcel(@Valid DocumentsPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<DocumentsDO> list = documentsService.getDocumentsPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "文档.xls", "数据", DocumentsRespVO.class,
                        BeanUtils.toBean(list, DocumentsRespVO.class));
    }

}