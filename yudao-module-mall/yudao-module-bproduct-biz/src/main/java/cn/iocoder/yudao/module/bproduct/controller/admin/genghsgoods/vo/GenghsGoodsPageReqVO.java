package cn.iocoder.yudao.module.bproduct.controller.admin.genghsgoods.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 脚本抓取控制分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GenghsGoodsPageReqVO extends PageParam {

    @Schema(description = "型号")
    private String pn;

    @Schema(description = "0,初始状态 1,完成抓取 2,任务失败", example = "1")
    private Boolean status;

    @Schema(description = "品牌id", example = "31692")
    private Long brandId;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}