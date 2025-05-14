package cn.iocoder.yudao.module.bproduct.controller.admin.partrohs10compliance.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - rohs合规性 Response VO")
@Data
@ExcelIgnoreUnannotated
public class PartRohs10ComplianceRespVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "11667")
    @ExcelProperty("主键id")
    private Long id;

    @Schema(description = "part_id", requiredMode = Schema.RequiredMode.REQUIRED, example = "28190")
    @ExcelProperty("part_id")
    private Long partId;

    @Schema(description = "code")
    @ExcelProperty("code")
    private String complianceCode;

    @Schema(description = "描述", example = "你说的对")
    @ExcelProperty("描述")
    private String complianceDescription;

    @Schema(description = "描述")
    @ExcelProperty("描述")
    private String selfDescribingDesc;

    @Schema(description = "分组信息")
    @ExcelProperty("分组信息")
    private String productCategoryEn;

    @Schema(description = "分组信息")
    @ExcelProperty("分组信息")
    private String productCategoryZh;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}