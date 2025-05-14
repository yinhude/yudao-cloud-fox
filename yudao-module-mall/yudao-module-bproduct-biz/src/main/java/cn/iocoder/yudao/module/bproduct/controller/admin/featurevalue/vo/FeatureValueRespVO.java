package cn.iocoder.yudao.module.bproduct.controller.admin.featurevalue.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 特征值 Response VO")
@Data
@ExcelIgnoreUnannotated
public class FeatureValueRespVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "13466")
    @ExcelProperty("主键")
    private Long id;

    @Schema(description = "名称", example = "李四")
    @ExcelProperty("名称")
    private String name;

    @Schema(description = "特性值id", example = "27926")
    @ExcelProperty("特性值id")
    private String dimValId;

    @Schema(description = "展示值")
    @ExcelProperty("展示值")
    private String displayValue;

    @Schema(description = "主键id", example = "15362")
    @ExcelProperty("主键id")
    private String primarySourceId;

    @Schema(description = "关键字")
    @ExcelProperty("关键字")
    private String keywords;

    @Schema(description = "值")
    @ExcelProperty("值")
    private String value;

    @Schema(description = "系统值")
    @ExcelProperty("系统值")
    private String system;

    @Schema(description = "单位")
    @ExcelProperty("单位")
    private String unit;

    @Schema(description = "排序")
    @ExcelProperty("排序")
    private String sort;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}