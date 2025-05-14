package cn.iocoder.yudao.module.bproduct.controller.admin.images.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 图片分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ImagesPageReqVO extends PageParam {

    @Schema(description = "产品id", example = "32737")
    private Long productId;

    @Schema(description = "文件名称", example = "李四")
    private String imageName;

    @Schema(description = "文件路径", example = "https://www.iocoder.cn")
    private String imageUrl;

    @Schema(description = "缩略图路径", example = "https://www.iocoder.cn")
    private String imageThumbnailUrl;

    @Schema(description = "minio路径", example = "https://www.iocoder.cn")
    private String minioUrl;

    @Schema(description = "minio缩略图路径", example = "https://www.iocoder.cn")
    private String minioThumbnailUrl;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}