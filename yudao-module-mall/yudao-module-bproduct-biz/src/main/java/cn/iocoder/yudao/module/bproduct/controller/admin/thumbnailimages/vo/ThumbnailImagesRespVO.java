package cn.iocoder.yudao.module.bproduct.controller.admin.thumbnailimages.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 商品缩略图 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ThumbnailImagesRespVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "26666")
    @ExcelProperty("主键")
    private Long id;

    @Schema(description = "产品id", requiredMode = Schema.RequiredMode.REQUIRED, example = "12181")
    @ExcelProperty("产品id")
    private Long productId;

    @Schema(description = "路径")
    @ExcelProperty("路径")
    private String path;

    @Schema(description = "图片名称", example = "芋艿")
    @ExcelProperty("图片名称")
    private String imageName;

    @Schema(description = "路径", example = "https://www.iocoder.cn")
    @ExcelProperty("路径")
    private String url;

    @Schema(description = "minio路径", example = "https://www.iocoder.cn")
    @ExcelProperty("minio路径")
    private String minioUrl;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}