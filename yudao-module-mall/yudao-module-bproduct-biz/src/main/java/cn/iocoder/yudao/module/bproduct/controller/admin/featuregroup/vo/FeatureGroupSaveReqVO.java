package cn.iocoder.yudao.module.bproduct.controller.admin.featuregroup.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 特征值分组新增/修改 Request VO")
@Data
public class FeatureGroupSaveReqVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "8949")
    private Long id;

    @Schema(description = "展示值", example = "3418")
    private String featureSourceId;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "展示值")
    private String label;

}