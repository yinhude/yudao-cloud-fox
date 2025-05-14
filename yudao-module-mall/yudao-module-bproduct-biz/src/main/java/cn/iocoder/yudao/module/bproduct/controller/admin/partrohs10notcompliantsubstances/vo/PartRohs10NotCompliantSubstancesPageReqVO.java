package cn.iocoder.yudao.module.bproduct.controller.admin.partrohs10notcompliantsubstances.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - rohs不符合的含量分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PartRohs10NotCompliantSubstancesPageReqVO extends PageParam {

    @Schema(description = "rohs", example = "16048")
    private Long rohs10ComplianceId;

    @Schema(description = "子系列名称", example = "赵六")
    private String substanceName;

    @Schema(description = "包含的子系列")
    private String containsSubstance;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}