package cn.iocoder.yudao.module.bproduct.controller.admin.featuregroup.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 特征值分组 Response VO")
@Data
@ExcelIgnoreUnannotated
public class FeatureGroupRespVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "8949")
    @ExcelProperty("主键")
    private Long id;

    @Schema(description = "展示值", example = "3418")
    @ExcelProperty("展示值")
    private String featureSourceId;

    @Schema(description = "排序")
    @ExcelProperty("排序")
    private Integer sort;

    @Schema(description = "展示值")
    @ExcelProperty("展示值")
    private String label;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}