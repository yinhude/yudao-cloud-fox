package cn.iocoder.yudao.module.bproduct.controller.admin.brand.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 品牌新增/修改 Request VO")
@Data
public class BrandSaveReqVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "6365")
    private Long id;

    @Schema(description = "品牌名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @NotEmpty(message = "品牌名称不能为空")
    private String name;

    @Schema(description = "首字母")
    private String firstChar;

    @Schema(description = "区域名称", example = "芋艿")
    private String originName;

    @Schema(description = "区域编码")
    private String originCode;

    @Schema(description = "品牌简称", example = "李四")
    private String shortName;

    @Schema(description = "对应的网址", example = "https://www.iocoder.cn")
    private String url;

    @Schema(description = "品牌图片url", example = "https://www.iocoder.cn")
    private String picUrl;

    @Schema(description = "品牌排序")
    private Integer sort;

    @Schema(description = "关键字")
    private String keywords;

    @Schema(description = "品牌描述", example = "你猜")
    private String description;

    @Schema(description = "状态 1 正常  0 停用", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "状态 1 正常  0 停用不能为空")
    private Integer status;

}