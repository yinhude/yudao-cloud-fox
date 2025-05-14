package cn.iocoder.yudao.module.bproduct.controller.admin.partparts.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - part合规性分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PartPartsPageReqVO extends PageParam {

    @Schema(description = "产品ID", example = "16614")
    private Long productId;

    @Schema(description = "part_num")
    private String partNum;

    @Schema(description = "leaf code")
    private String leadFreeProcessCode;

    @Schema(description = "描述")
    private String leadFreeProcessDesc;

    @Schema(description = "material_declaration_indicator")
    private String materialDeclarationIndicator;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}