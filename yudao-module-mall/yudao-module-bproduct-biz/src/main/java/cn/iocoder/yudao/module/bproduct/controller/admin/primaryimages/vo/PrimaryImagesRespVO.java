package cn.iocoder.yudao.module.bproduct.controller.admin.primaryimages.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 商品主图 Response VO")
@Data
@ExcelIgnoreUnannotated
public class PrimaryImagesRespVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "3464")
    @ExcelProperty("主键id")
    private Long id;

    @Schema(description = "产品id", requiredMode = Schema.RequiredMode.REQUIRED, example = "21746")
    @ExcelProperty("产品id")
    private Long productId;

    @Schema(description = "路径")
    @ExcelProperty("路径")
    private String path;

    @Schema(description = "图像路径", example = "赵六")
    @ExcelProperty("图像路径")
    private String imageName;

    @Schema(description = "url", example = "https://www.iocoder.cn")
    @ExcelProperty("url")
    private String url;

    @Schema(description = "本地路径", example = "https://www.iocoder.cn")
    @ExcelProperty("本地路径")
    private String minioUrl;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}