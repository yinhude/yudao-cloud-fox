package cn.iocoder.yudao.module.bproduct.controller.admin.partchinarohscompliance.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - rohs新增/修改 Request VO")
@Data
public class PartChinaRohsComplianceSaveReqVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "16552")
    private Long id;

    @Schema(description = "part_id`", requiredMode = Schema.RequiredMode.REQUIRED, example = "25363")
    @NotNull(message = "part_id`不能为空")
    private Long partId;

    @Schema(description = "epup_code受限编码")
    private String epupComplianceCode;

    @Schema(description = "描述")
    private String epupComplianceDesc;

    @Schema(description = "图片路径", example = "https://www.iocoder.cn")
    private String epupImageUrl;

}