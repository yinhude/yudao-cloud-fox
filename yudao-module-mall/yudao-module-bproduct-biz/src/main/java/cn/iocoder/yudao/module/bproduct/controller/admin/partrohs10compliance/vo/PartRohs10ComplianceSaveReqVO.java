package cn.iocoder.yudao.module.bproduct.controller.admin.partrohs10compliance.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - rohs合规性新增/修改 Request VO")
@Data
public class PartRohs10ComplianceSaveReqVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "11667")
    private Long id;

    @Schema(description = "part_id", requiredMode = Schema.RequiredMode.REQUIRED, example = "28190")
    @NotNull(message = "part_id不能为空")
    private Long partId;

    @Schema(description = "code")
    private String complianceCode;

    @Schema(description = "描述", example = "你说的对")
    private String complianceDescription;

    @Schema(description = "描述")
    private String selfDescribingDesc;

    @Schema(description = "分组信息")
    private String productCategoryEn;

    @Schema(description = "分组信息")
    private String productCategoryZh;

}