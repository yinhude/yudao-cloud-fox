package cn.iocoder.yudao.module.bproduct.controller.admin.primaryimages.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 商品主图新增/修改 Request VO")
@Data
public class PrimaryImagesSaveReqVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "3464")
    private Long id;

    @Schema(description = "产品id", requiredMode = Schema.RequiredMode.REQUIRED, example = "21746")
    @NotNull(message = "产品id不能为空")
    private Long productId;

    @Schema(description = "路径")
    private String path;

    @Schema(description = "图像路径", example = "赵六")
    private String imageName;

    @Schema(description = "url", example = "https://www.iocoder.cn")
    private String url;

    @Schema(description = "本地路径", example = "https://www.iocoder.cn")
    private String minioUrl;

}