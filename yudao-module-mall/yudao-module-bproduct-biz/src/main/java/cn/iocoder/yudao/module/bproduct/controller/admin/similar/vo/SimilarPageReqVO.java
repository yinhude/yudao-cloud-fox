package cn.iocoder.yudao.module.bproduct.controller.admin.similar.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 商品替代品分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SimilarPageReqVO extends PageParam {

    @Schema(description = "关联型号")
    private String relationPn;

    @Schema(description = "关联对象id", example = "26280")
    private Long relationId;

    @Schema(description = "产品id", example = "21402")
    private Long productId;

    @Schema(description = "1.替代品 2.对配 3.配套", example = "1")
    private Integer type;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}