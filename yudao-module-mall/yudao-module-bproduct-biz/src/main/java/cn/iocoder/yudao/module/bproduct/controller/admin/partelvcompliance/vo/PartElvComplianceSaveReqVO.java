package cn.iocoder.yudao.module.bproduct.controller.admin.partelvcompliance.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - elv合规数据新增/修改 Request VO")
@Data
public class PartElvComplianceSaveReqVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "25504")
    private Long id;

    @Schema(description = "part_id`", requiredMode = Schema.RequiredMode.REQUIRED, example = "10582")
    @NotNull(message = "part_id`不能为空")
    private Long partId;

    @Schema(description = "ELV编码")
    private String complianceCode;

    @Schema(description = "描述信息", example = "你说的对")
    private String complianceDescription;

    @Schema(description = "ELV详细描述")
    private String selfDescribingDesc;

}