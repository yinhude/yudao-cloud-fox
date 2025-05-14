package cn.iocoder.yudao.module.bproduct.controller.admin.partreachsvhcs.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - reach合规性 Response VO")
@Data
@ExcelIgnoreUnannotated
public class PartReachSvhcsRespVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "14113")
    @ExcelProperty("主键id")
    private Long id;

    @Schema(description = "reach合规性表id", requiredMode = Schema.RequiredMode.REQUIRED, example = "27053")
    @ExcelProperty("reach合规性表id")
    private Long reachComplianceId;

    @Schema(description = "具体信息", example = "张三")
    @ExcelProperty("具体信息")
    private String svhcName;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}