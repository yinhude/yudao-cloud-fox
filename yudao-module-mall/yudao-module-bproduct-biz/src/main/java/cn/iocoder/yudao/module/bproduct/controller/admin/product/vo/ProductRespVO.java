package cn.iocoder.yudao.module.bproduct.controller.admin.product.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 商品系列 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ProductRespVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "23204")
    @ExcelProperty("主键id")
    private Long id;

    @Schema(description = "元数据id", example = "24603")
    @ExcelProperty("元数据id")
    private String originId;

    @Schema(description = "图片地址")
    @ExcelProperty("图片地址")
    private String img;

    @Schema(description = "1:regular:产品  2:model:归类", example = "2")
    @ExcelProperty("1:regular:产品  2:model:归类")
    private String partType;

    @Schema(description = "品牌id", example = "23633")
    @ExcelProperty("品牌id")
    private Long brandId;

    @Schema(description = "平台自身分类、系列id", example = "12554")
    @ExcelProperty("平台自身分类、系列id")
    private Long selfCategoryId;

    @Schema(description = "父级分类id", example = "1478")
    @ExcelProperty("父级分类id")
    private Long parentCategoryId;

    @Schema(description = "描述", example = "你说的对")
    @ExcelProperty("描述")
    private String description;

    @Schema(description = "友好的描述", example = "你猜")
    @ExcelProperty("友好的描述")
    private String friendlyDescription;

    @Schema(description = "产品型号")
    @ExcelProperty("产品型号")
    private String tcpn;

    @Schema(description = "elv描述")
    @ExcelProperty("elv描述")
    private String elvCompliance;

    @Schema(description = "elv描述")
    @ExcelProperty("elv描述")
    private String productOwningProfitCenter;

    @Schema(description = "替代品是否存在")
    @ExcelProperty("替代品是否存在")
    private Integer replacementProductExists;

    @Schema(description = "属性", example = "王五")
    @ExcelProperty("属性")
    private String attributeName;

    @Schema(description = "未知字段", example = "张三")
    @ExcelProperty("未知字段")
    private String buName;

    @Schema(description = "系列id", example = "24397")
    @ExcelProperty("系列id")
    private Long seriesId;

    @Schema(description = "家族描述id", example = "7444")
    @ExcelProperty("家族描述id")
    private Long familyId;

    @Schema(description = "合规性")
    @ExcelProperty("合规性")
    private String rohsCompliance;

    @Schema(description = "内部型号")
    @ExcelProperty("内部型号")
    private String marketingPartNumber;

    @Schema(description = "军用型号")
    @ExcelProperty("军用型号")
    private String milspecNumber;

    @Schema(description = "型号")
    @ExcelProperty("型号")
    private String marketingPartNumNormalized;

    @Schema(description = "状态 1 正常  0 停用", example = "2")
    @ExcelProperty("状态 1 正常  0 停用")
    private Integer status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}