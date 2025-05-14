package cn.iocoder.yudao.module.bproduct.controller.admin.partelvcompliance.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - elv合规数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class PartElvComplianceRespVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "25504")
    @ExcelProperty("主键id")
    private Long id;

    @Schema(description = "part_id`", requiredMode = Schema.RequiredMode.REQUIRED, example = "10582")
    @ExcelProperty("part_id`")
    private Long partId;

    @Schema(description = "ELV编码")
    @ExcelProperty("ELV编码")
    private String complianceCode;

    @Schema(description = "描述信息", example = "你说的对")
    @ExcelProperty("描述信息")
    private String complianceDescription;

    @Schema(description = "ELV详细描述")
    @ExcelProperty("ELV详细描述")
    private String selfDescribingDesc;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}