package cn.iocoder.yudao.module.bproduct.controller.admin.partparts.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - part合规性新增/修改 Request VO")
@Data
public class PartPartsSaveReqVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "18918")
    private Long id;

    @Schema(description = "产品ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "16614")
    @NotNull(message = "产品ID不能为空")
    private Long productId;

    @Schema(description = "part_num", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "part_num不能为空")
    private String partNum;

    @Schema(description = "leaf code")
    private String leadFreeProcessCode;

    @Schema(description = "描述")
    private String leadFreeProcessDesc;

    @Schema(description = "material_declaration_indicator")
    private String materialDeclarationIndicator;

}