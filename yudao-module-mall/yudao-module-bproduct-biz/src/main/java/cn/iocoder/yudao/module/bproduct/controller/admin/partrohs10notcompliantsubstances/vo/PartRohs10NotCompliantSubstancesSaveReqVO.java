package cn.iocoder.yudao.module.bproduct.controller.admin.partrohs10notcompliantsubstances.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - rohs不符合的含量新增/修改 Request VO")
@Data
public class PartRohs10NotCompliantSubstancesSaveReqVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "23138")
    private Long id;

    @Schema(description = "rohs", requiredMode = Schema.RequiredMode.REQUIRED, example = "16048")
    @NotNull(message = "rohs不能为空")
    private Long rohs10ComplianceId;

    @Schema(description = "子系列名称", example = "赵六")
    private String substanceName;

    @Schema(description = "包含的子系列")
    private String containsSubstance;

}