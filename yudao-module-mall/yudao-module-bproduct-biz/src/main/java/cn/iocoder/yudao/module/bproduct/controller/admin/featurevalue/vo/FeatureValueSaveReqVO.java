package cn.iocoder.yudao.module.bproduct.controller.admin.featurevalue.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 特征值新增/修改 Request VO")
@Data
public class FeatureValueSaveReqVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "13466")
    private Long id;

    @Schema(description = "名称", example = "李四")
    private String name;

    @Schema(description = "特性值id", example = "27926")
    private String dimValId;

    @Schema(description = "展示值")
    private String displayValue;

    @Schema(description = "主键id", example = "15362")
    private String primarySourceId;

    @Schema(description = "关键字")
    private String keywords;

    @Schema(description = "值")
    private String value;

    @Schema(description = "系统值")
    private String system;

    @Schema(description = "单位")
    private String unit;

    @Schema(description = "排序")
    private String sort;

}