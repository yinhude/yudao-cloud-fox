package cn.iocoder.yudao.module.bproduct.controller.admin.documents.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 文档新增/修改 Request VO")
@Data
public class DocumentsSaveReqVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "20047")
    private Long id;

    @Schema(description = "产品id", requiredMode = Schema.RequiredMode.REQUIRED, example = "16773")
    @NotNull(message = "产品id不能为空")
    private Long productId;

    @Schema(description = "类型", example = "1")
    private String type;

    @Schema(description = "产品id")
    private String revision;

    @Schema(description = "格式")
    private String format;

    @Schema(description = "语言")
    private String language;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "名称", example = "张三")
    private String name;

    @Schema(description = "本地类型", example = "2")
    private String localType;

    @Schema(description = "文件大小")
    private String rawFileSize;

    @Schema(description = "文件编号")
    private String docNumber;

    @Schema(description = "lang code")
    private String langCode;

    @Schema(description = "页面显示大小")
    private String viewableSize;

    @Schema(description = "文件名称", example = "张三")
    private String filename;

    @Schema(description = "路径", example = "https://www.iocoder.cn")
    private String url;

    @Schema(description = "本地存储路径", example = "https://www.iocoder.cn")
    private String minioUrl;

}