package cn.iocoder.yudao.module.bproduct.controller.admin.product.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 商品系列新增/修改 Request VO")
@Data
public class ProductSaveReqVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "23204")
    private Long id;

    @Schema(description = "元数据id", example = "24603")
    private String originId;

    @Schema(description = "图片地址")
    private String img;

    @Schema(description = "1:regular:产品  2:model:归类", example = "2")
    private String partType;

    @Schema(description = "品牌id", example = "23633")
    private Long brandId;

    @Schema(description = "平台自身分类、系列id", example = "12554")
    private Long selfCategoryId;

    @Schema(description = "父级分类id", example = "1478")
    private Long parentCategoryId;

    @Schema(description = "描述", example = "你说的对")
    private String description;

    @Schema(description = "友好的描述", example = "你猜")
    private String friendlyDescription;

    @Schema(description = "产品型号")
    private String tcpn;

    @Schema(description = "elv描述")
    private String elvCompliance;

    @Schema(description = "elv描述")
    private String productOwningProfitCenter;

    @Schema(description = "替代品是否存在")
    private Integer replacementProductExists;

    @Schema(description = "属性", example = "王五")
    private String attributeName;

    @Schema(description = "未知字段", example = "张三")
    private String buName;

    @Schema(description = "系列id", example = "24397")
    private Long seriesId;

    @Schema(description = "家族描述id", example = "7444")
    private Long familyId;

    @Schema(description = "合规性")
    private String rohsCompliance;

    @Schema(description = "内部型号")
    private String marketingPartNumber;

    @Schema(description = "军用型号")
    private String milspecNumber;

    @Schema(description = "型号")
    private String marketingPartNumNormalized;

    @Schema(description = "状态 1 正常  0 停用", example = "2")
    private Integer status;

}