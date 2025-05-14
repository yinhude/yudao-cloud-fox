package cn.iocoder.yudao.module.bproduct.controller.admin.selfproductcategoryrela.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 产品和自有分类的关联性分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SelfProductCategoryRelaPageReqVO extends PageParam {

    @Schema(description = "关联对象id", example = "19507")
    private Long relationId;

    @Schema(description = "产品id", example = "22325")
    private Long productId;

    @Schema(description = "1.分类 2.系列", example = "2")
    private Integer type;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}