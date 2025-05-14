package cn.iocoder.yudao.module.bproduct.controller.admin.thumbnailimages.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 商品缩略图新增/修改 Request VO")
@Data
public class ThumbnailImagesSaveReqVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "26666")
    private Long id;

    @Schema(description = "产品id", requiredMode = Schema.RequiredMode.REQUIRED, example = "12181")
    @NotNull(message = "产品id不能为空")
    private Long productId;

    @Schema(description = "路径")
    private String path;

    @Schema(description = "图片名称", example = "芋艿")
    private String imageName;

    @Schema(description = "路径", example = "https://www.iocoder.cn")
    private String url;

    @Schema(description = "minio路径", example = "https://www.iocoder.cn")
    private String minioUrl;

}