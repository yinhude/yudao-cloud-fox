package cn.iocoder.yudao.module.bproduct.controller.admin.images.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 图片新增/修改 Request VO")
@Data
public class ImagesSaveReqVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "19346")
    private Long id;

    @Schema(description = "产品id", requiredMode = Schema.RequiredMode.REQUIRED, example = "32737")
    @NotNull(message = "产品id不能为空")
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

}