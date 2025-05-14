package cn.iocoder.yudao.module.bproduct.controller.admin.featurevalue.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 特征值分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FeatureValuePageReqVO extends PageParam {

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

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}