package cn.iocoder.yudao.module.bproduct.controller.admin.brand.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 品牌 Response VO")
@Data
@ExcelIgnoreUnannotated
public class BrandRespVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "6365")
    @ExcelProperty("主键id")
    private Long id;

    @Schema(description = "品牌名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @ExcelProperty("品牌名称")
    private String name;

    @Schema(description = "首字母")
    @ExcelProperty("首字母")
    private String firstChar;

    @Schema(description = "区域名称", example = "芋艿")
    @ExcelProperty("区域名称")
    private String originName;

    @Schema(description = "区域编码")
    @ExcelProperty("区域编码")
    private String originCode;

    @Schema(description = "品牌简称", example = "李四")
    @ExcelProperty("品牌简称")
    private String shortName;

    @Schema(description = "对应的网址", example = "https://www.iocoder.cn")
    @ExcelProperty("对应的网址")
    private String url;

    @Schema(description = "品牌图片url", example = "https://www.iocoder.cn")
    @ExcelProperty("品牌图片url")
    private String picUrl;

    @Schema(description = "品牌排序")
    @ExcelProperty("品牌排序")
    private Integer sort;

    @Schema(description = "关键字")
    @ExcelProperty("关键字")
    private String keywords;

    @Schema(description = "品牌描述", example = "你猜")
    @ExcelProperty("品牌描述")
    private String description;

    @Schema(description = "状态 1 正常  0 停用", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("状态 1 正常  0 停用")
    private Integer status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}