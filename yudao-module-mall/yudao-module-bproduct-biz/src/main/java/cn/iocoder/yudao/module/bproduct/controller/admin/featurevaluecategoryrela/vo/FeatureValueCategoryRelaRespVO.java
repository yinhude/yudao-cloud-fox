package cn.iocoder.yudao.module.bproduct.controller.admin.featurevaluecategoryrela.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 特征值关联 Response VO")
@Data
@ExcelIgnoreUnannotated
public class FeatureValueCategoryRelaRespVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "24431")
    @ExcelProperty("主键")
    private Long id;

    @Schema(description = "关联对象id（特征值）", example = "26000")
    @ExcelProperty("关联对象id（特征值）")
    private Long relationId;

    @Schema(description = "产品id", example = "26983")
    @ExcelProperty("产品id")
    private Long productId;

    @Schema(description = "0.品牌 1.种类 2.系列", example = "2")
    @ExcelProperty("0.品牌 1.种类 2.系列")
    private Integer type;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}