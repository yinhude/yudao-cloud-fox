package cn.iocoder.yudao.module.bproduct.controller.admin.featurevaluerela.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 特征值关联新增/修改 Request VO")
@Data
public class FeatureValueRelaSaveReqVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "497")
    private Long id;

    @Schema(description = "关联对象id（特征值）", example = "4191")
    private Long relationId;

    @Schema(description = "产品id", example = "20979")
    private Long productId;

    @Schema(description = "1 feature 特性   2 合规性", example = "1")
    private Integer type;

}