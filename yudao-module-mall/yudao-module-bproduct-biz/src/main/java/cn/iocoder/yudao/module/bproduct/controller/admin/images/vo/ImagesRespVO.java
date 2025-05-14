package cn.iocoder.yudao.module.bproduct.controller.admin.images.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 图片 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ImagesRespVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "19346")
    @ExcelProperty("主键id")
    private Long id;

    @Schema(description = "产品id", requiredMode = Schema.RequiredMode.REQUIRED, example = "32737")
    @ExcelProperty("产品id")
    private Long productId;

    @Schema(description = "文件名称", example = "李四")
    @ExcelProperty("文件名称")
    private String imageName;

    @Schema(description = "文件路径", example = "https://www.iocoder.cn")
    @ExcelProperty("文件路径")
    private String imageUrl;

    @Schema(description = "缩略图路径", example = "https://www.iocoder.cn")
    @ExcelProperty("缩略图路径")
    private String imageThumbnailUrl;

    @Schema(description = "minio路径", example = "https://www.iocoder.cn")
    @ExcelProperty("minio路径")
    private String minioUrl;

    @Schema(description = "minio缩略图路径", example = "https://www.iocoder.cn")
    @ExcelProperty("minio缩略图路径")
    private String minioThumbnailUrl;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}