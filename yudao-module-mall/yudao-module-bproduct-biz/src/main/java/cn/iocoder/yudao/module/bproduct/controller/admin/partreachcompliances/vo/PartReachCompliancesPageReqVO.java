package cn.iocoder.yudao.module.bproduct.controller.admin.partreachcompliances.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - reach合规性分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PartReachCompliancesPageReqVO extends PageParam {

    @Schema(description = "partid", example = "24512")
    private Long partId;

    @Schema(description = "法规信息")
    private String reachCmpl;

    @Schema(description = "发布日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private String[] candidateDate;

    @Schema(description = "更新日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private String[] declarationDate;

    @Schema(description = "code")
    private String declarationCode;

    @Schema(description = "超出限值")
    private String containsReach;

    @Schema(description = "decl_date_flag")
    private Boolean declDateFlag;

    @Schema(description = "cand_date_flag")
    private Boolean candDateFlag;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}