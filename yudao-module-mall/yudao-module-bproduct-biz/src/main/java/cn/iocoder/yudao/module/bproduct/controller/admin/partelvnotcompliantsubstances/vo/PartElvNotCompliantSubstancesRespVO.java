package cn.iocoder.yudao.module.bproduct.controller.admin.partelvnotcompliantsubstances.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - elv不合规含量子 Response VO")
@Data
@ExcelIgnoreUnannotated
public class PartElvNotCompliantSubstancesRespVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "25880")
    @ExcelProperty("主键id")
    private Long id;

    @Schema(description = "elvID", requiredMode = Schema.RequiredMode.REQUIRED, example = "9842")
    @ExcelProperty("elvID")
    private Long elvComplianceId;

    @Schema(description = "子名称", example = "赵六")
    @ExcelProperty("子名称")
    private String substanceName;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}