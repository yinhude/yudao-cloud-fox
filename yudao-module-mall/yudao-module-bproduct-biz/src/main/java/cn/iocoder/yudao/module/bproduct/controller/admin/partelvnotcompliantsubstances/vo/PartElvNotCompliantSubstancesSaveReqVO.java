package cn.iocoder.yudao.module.bproduct.controller.admin.partelvnotcompliantsubstances.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - elv不合规含量子新增/修改 Request VO")
@Data
public class PartElvNotCompliantSubstancesSaveReqVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "25880")
    private Long id;

    @Schema(description = "elvID", requiredMode = Schema.RequiredMode.REQUIRED, example = "9842")
    @NotNull(message = "elvID不能为空")
    private Long elvComplianceId;

    @Schema(description = "子名称", example = "赵六")
    private String substanceName;

}