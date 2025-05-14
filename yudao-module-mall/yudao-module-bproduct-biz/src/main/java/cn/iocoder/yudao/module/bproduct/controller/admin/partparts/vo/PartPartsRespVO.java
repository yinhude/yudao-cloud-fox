package cn.iocoder.yudao.module.bproduct.controller.admin.partparts.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - part合规性 Response VO")
@Data
@ExcelIgnoreUnannotated
public class PartPartsRespVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "18918")
    @ExcelProperty("主键id")
    private Long id;

    @Schema(description = "产品ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "16614")
    @ExcelProperty("产品ID")
    private Long productId;

    @Schema(description = "part_num", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("part_num")
    private String partNum;

    @Schema(description = "leaf code")
    @ExcelProperty("leaf code")
    private String leadFreeProcessCode;

    @Schema(description = "描述")
    @ExcelProperty("描述")
    private String leadFreeProcessDesc;

    @Schema(description = "material_declaration_indicator")
    @ExcelProperty("material_declaration_indicator")
    private String materialDeclarationIndicator;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}