package cn.iocoder.yudao.module.bproduct.controller.admin.documents.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 文档 Response VO")
@Data
@ExcelIgnoreUnannotated
public class DocumentsRespVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "20047")
    @ExcelProperty("主键id")
    private Long id;

    @Schema(description = "产品id", requiredMode = Schema.RequiredMode.REQUIRED, example = "16773")
    @ExcelProperty("产品id")
    private Long productId;

    @Schema(description = "类型", example = "1")
    @ExcelProperty("类型")
    private String type;

    @Schema(description = "产品id")
    @ExcelProperty("产品id")
    private String revision;

    @Schema(description = "格式")
    @ExcelProperty("格式")
    private String format;

    @Schema(description = "语言")
    @ExcelProperty("语言")
    private String language;

    @Schema(description = "标题")
    @ExcelProperty("标题")
    private String title;

    @Schema(description = "名称", example = "张三")
    @ExcelProperty("名称")
    private String name;

    @Schema(description = "本地类型", example = "2")
    @ExcelProperty("本地类型")
    private String localType;

    @Schema(description = "文件大小")
    @ExcelProperty("文件大小")
    private String rawFileSize;

    @Schema(description = "文件编号")
    @ExcelProperty("文件编号")
    private String docNumber;

    @Schema(description = "lang code")
    @ExcelProperty("lang code")
    private String langCode;

    @Schema(description = "页面显示大小")
    @ExcelProperty("页面显示大小")
    private String viewableSize;

    @Schema(description = "文件名称", example = "张三")
    @ExcelProperty("文件名称")
    private String filename;

    @Schema(description = "路径", example = "https://www.iocoder.cn")
    @ExcelProperty("路径")
    private String url;

    @Schema(description = "本地存储路径", example = "https://www.iocoder.cn")
    @ExcelProperty("本地存储路径")
    private String minioUrl;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}