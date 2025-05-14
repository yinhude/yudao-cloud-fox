package cn.iocoder.yudao.module.bproduct.controller.admin.partelvcompliance.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - elv合规数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PartElvCompliancePageReqVO extends PageParam {

    @Schema(description = "part_id`", example = "10582")
    private Long partId;

    @Schema(description = "ELV编码")
    private String complianceCode;

    @Schema(description = "描述信息", example = "你说的对")
    private String complianceDescription;

    @Schema(description = "ELV详细描述")
    private String selfDescribingDesc;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}