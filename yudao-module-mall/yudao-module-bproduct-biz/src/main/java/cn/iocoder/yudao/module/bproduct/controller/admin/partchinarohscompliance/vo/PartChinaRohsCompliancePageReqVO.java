package cn.iocoder.yudao.module.bproduct.controller.admin.partchinarohscompliance.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - rohs分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PartChinaRohsCompliancePageReqVO extends PageParam {

    @Schema(description = "part_id`", example = "25363")
    private Long partId;

    @Schema(description = "epup_code受限编码")
    private String epupComplianceCode;

    @Schema(description = "描述")
    private String epupComplianceDesc;

    @Schema(description = "图片路径", example = "https://www.iocoder.cn")
    private String epupImageUrl;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}