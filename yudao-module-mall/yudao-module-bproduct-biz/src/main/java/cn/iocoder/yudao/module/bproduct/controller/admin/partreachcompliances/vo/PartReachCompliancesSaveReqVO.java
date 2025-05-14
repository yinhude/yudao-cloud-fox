package cn.iocoder.yudao.module.bproduct.controller.admin.partreachcompliances.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - reach合规性新增/修改 Request VO")
@Data
public class PartReachCompliancesSaveReqVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "27251")
    private Long id;

    @Schema(description = "partid", requiredMode = Schema.RequiredMode.REQUIRED, example = "24512")
    @NotNull(message = "partid不能为空")
    private Long partId;

    @Schema(description = "法规信息")
    private String reachCmpl;

    @Schema(description = "发布日期")
    private String candidateDate;

    @Schema(description = "更新日期")
    private String declarationDate;

    @Schema(description = "code")
    private String declarationCode;

    @Schema(description = "超出限值")
    private String containsReach;

    @Schema(description = "decl_date_flag")
    private Boolean declDateFlag;

    @Schema(description = "cand_date_flag")
    private Boolean candDateFlag;

}