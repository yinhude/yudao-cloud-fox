package cn.iocoder.yudao.module.bproduct.controller.admin.featurevaluecategoryrela.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 特征值关联分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FeatureValueCategoryRelaPageReqVO extends PageParam {

    @Schema(description = "关联对象id（特征值）", example = "26000")
    private Long relationId;

    @Schema(description = "产品id", example = "26983")
    private Long productId;

    @Schema(description = "0.品牌 1.种类 2.系列", example = "2")
    private Integer type;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}