package cn.iocoder.yudao.module.bproduct.controller.admin.feature.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 特征 Response VO")
@Data
@ExcelIgnoreUnannotated
public class FeatureRespVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "22014")
    @ExcelProperty("主键")
    private Long id;

    @Schema(description = "元数据id", example = "20684")
    @ExcelProperty("元数据id")
    private String originId;

    @Schema(description = "编码")
    @ExcelProperty("编码")
    private String code;

    @Schema(description = "展示值")
    @ExcelProperty("展示值")
    private String displayValue;

    @Schema(description = "是否是数值")
    @ExcelProperty("是否是数值")
    private Integer numeric;

    @Schema(description = "是否支持筛选")
    @ExcelProperty("是否支持筛选")
    private Integer filterOnly;

    @Schema(description = "排序")
    @ExcelProperty("排序")
    private Integer sort;

    @Schema(description = "未知参数", example = "1")
    @ExcelProperty("未知参数")
    private String attributeType;

    @Schema(description = "主要参数")
    @ExcelProperty("主要参数")
    private Integer primaryFlag;

    @Schema(description = "主要字段", example = "16515")
    @ExcelProperty("主要字段")
    private String primarySourceId;

    @Schema(description = "未知参数")
    @ExcelProperty("未知参数")
    private String helpInfoVailable;

    @Schema(description = "未知")
    @ExcelProperty("未知")
    private Integer uom;

    @Schema(description = "未知")
    @ExcelProperty("未知")
    private String uiWidget;

    @Schema(description = "展示")
    @ExcelProperty("展示")
    private String showInCompareView;

    @Schema(description = "展示值")
    @ExcelProperty("展示值")
    private String label;

    @Schema(description = "1:primary 2:normal", example = "2")
    @ExcelProperty("1:primary 2:normal")
    private Integer type;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}