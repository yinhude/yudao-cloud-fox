package cn.iocoder.yudao.module.bproduct.controller.admin.partrohs10notcompliantsubstances.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - rohs不符合的含量 Response VO")
@Data
@ExcelIgnoreUnannotated
public class PartRohs10NotCompliantSubstancesRespVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "23138")
    @ExcelProperty("主键id")
    private Long id;

    @Schema(description = "rohs", requiredMode = Schema.RequiredMode.REQUIRED, example = "16048")
    @ExcelProperty("rohs")
    private Long rohs10ComplianceId;

    @Schema(description = "子系列名称", example = "赵六")
    @ExcelProperty("子系列名称")
    private String substanceName;

    @Schema(description = "包含的子系列")
    @ExcelProperty("包含的子系列")
    private String containsSubstance;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}