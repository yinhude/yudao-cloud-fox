package cn.iocoder.yudao.module.bproduct.controller.admin.partreachcompliances.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - reach合规性 Response VO")
@Data
@ExcelIgnoreUnannotated
public class PartReachCompliancesRespVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "27251")
    @ExcelProperty("主键id")
    private Long id;

    @Schema(description = "partid", requiredMode = Schema.RequiredMode.REQUIRED, example = "24512")
    @ExcelProperty("partid")
    private Long partId;

    @Schema(description = "法规信息")
    @ExcelProperty("法规信息")
    private String reachCmpl;

    @Schema(description = "发布日期")
    @ExcelProperty("发布日期")
    private String candidateDate;

    @Schema(description = "更新日期")
    @ExcelProperty("更新日期")
    private String declarationDate;

    @Schema(description = "code")
    @ExcelProperty("code")
    private String declarationCode;

    @Schema(description = "超出限值")
    @ExcelProperty("超出限值")
    private String containsReach;

    @Schema(description = "decl_date_flag")
    @ExcelProperty("decl_date_flag")
    private Boolean declDateFlag;

    @Schema(description = "cand_date_flag")
    @ExcelProperty("cand_date_flag")
    private Boolean candDateFlag;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}