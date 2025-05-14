package cn.iocoder.yudao.module.bproduct.controller.admin.feature.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 特征新增/修改 Request VO")
@Data
public class FeatureSaveReqVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "22014")
    private Long id;

    @Schema(description = "元数据id", example = "20684")
    private String originId;

    @Schema(description = "编码")
    private String code;

    @Schema(description = "展示值")
    private String displayValue;

    @Schema(description = "是否是数值")
    private Integer numeric;

    @Schema(description = "是否支持筛选")
    private Integer filterOnly;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "未知参数", example = "1")
    private String attributeType;

    @Schema(description = "主要参数")
    private Integer primaryFlag;

    @Schema(description = "主要字段", example = "16515")
    private String primarySourceId;

    @Schema(description = "未知参数")
    private String helpInfoVailable;

    @Schema(description = "未知")
    private Integer uom;

    @Schema(description = "未知")
    private String uiWidget;

    @Schema(description = "展示")
    private String showInCompareView;

    @Schema(description = "展示值")
    private String label;

    @Schema(description = "1:primary 2:normal", example = "2")
    private Integer type;

}