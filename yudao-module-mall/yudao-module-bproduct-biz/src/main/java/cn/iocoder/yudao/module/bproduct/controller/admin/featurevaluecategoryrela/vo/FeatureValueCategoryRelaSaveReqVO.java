package cn.iocoder.yudao.module.bproduct.controller.admin.featurevaluecategoryrela.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 特征值关联新增/修改 Request VO")
@Data
public class FeatureValueCategoryRelaSaveReqVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "24431")
    private Long id;

    @Schema(description = "关联对象id（特征值）", example = "26000")
    private Long relationId;

    @Schema(description = "产品id", example = "26983")
    private Long productId;

    @Schema(description = "0.品牌 1.种类 2.系列", example = "2")
    private Integer type;

}