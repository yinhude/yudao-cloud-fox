package cn.iocoder.yudao.module.bproduct.controller.admin.featurevaluerela.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 特征值关联 Response VO")
@Data
@ExcelIgnoreUnannotated
public class FeatureValueRelaRespVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "497")
    @ExcelProperty("主键")
    private Long id;

    @Schema(description = "关联对象id（特征值）", example = "4191")
    @ExcelProperty("关联对象id（特征值）")
    private Long relationId;

    @Schema(description = "产品id", example = "20979")
    @ExcelProperty("产品id")
    private Long productId;

    @Schema(description = "1 feature 特性   2 合规性", example = "1")
    @ExcelProperty("1 feature 特性   2 合规性")
    private Integer type;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}