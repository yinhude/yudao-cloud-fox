package cn.iocoder.yudao.module.bproduct.controller.admin.primaryimages.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 商品主图分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PrimaryImagesPageReqVO extends PageParam {

    @Schema(description = "产品id", example = "21746")
    private Long productId;

    @Schema(description = "路径")
    private String path;

    @Schema(description = "图像路径", example = "赵六")
    private String imageName;

    @Schema(description = "url", example = "https://www.iocoder.cn")
    private String url;

    @Schema(description = "本地路径", example = "https://www.iocoder.cn")
    private String minioUrl;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}