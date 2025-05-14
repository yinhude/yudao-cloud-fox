package cn.iocoder.yudao.module.bproduct.controller.admin.feature.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 特征分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FeaturePageReqVO extends PageParam {

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

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}