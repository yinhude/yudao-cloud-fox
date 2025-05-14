package cn.iocoder.yudao.module.bproduct.controller.admin.partchinarohscompliance.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - rohs Response VO")
@Data
@ExcelIgnoreUnannotated
public class PartChinaRohsComplianceRespVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "16552")
    @ExcelProperty("主键id")
    private Long id;

    @Schema(description = "part_id`", requiredMode = Schema.RequiredMode.REQUIRED, example = "25363")
    @ExcelProperty("part_id`")
    private Long partId;

    @Schema(description = "epup_code受限编码")
    @ExcelProperty("epup_code受限编码")
    private String epupComplianceCode;

    @Schema(description = "描述")
    @ExcelProperty("描述")
    private String epupComplianceDesc;

    @Schema(description = "图片路径", example = "https://www.iocoder.cn")
    @ExcelProperty("图片路径")
    private String epupImageUrl;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}