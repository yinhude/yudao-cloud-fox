package cn.iocoder.yudao.module.bproduct.controller.admin.partreachsvhcs.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - reach合规性新增/修改 Request VO")
@Data
public class PartReachSvhcsSaveReqVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "14113")
    private Long id;

    @Schema(description = "reach合规性表id", requiredMode = Schema.RequiredMode.REQUIRED, example = "27053")
    @NotNull(message = "reach合规性表id不能为空")
    private Long reachComplianceId;

    @Schema(description = "具体信息", example = "张三")
    private String svhcName;

}