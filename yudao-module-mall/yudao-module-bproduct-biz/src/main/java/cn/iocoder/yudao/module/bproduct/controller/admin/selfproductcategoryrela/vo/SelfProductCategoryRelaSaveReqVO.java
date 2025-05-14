package cn.iocoder.yudao.module.bproduct.controller.admin.selfproductcategoryrela.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 产品和自有分类的关联性新增/修改 Request VO")
@Data
public class SelfProductCategoryRelaSaveReqVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "20742")
    private Long id;

    @Schema(description = "关联对象id", example = "19507")
    private Long relationId;

    @Schema(description = "产品id", example = "22325")
    private Long productId;

    @Schema(description = "1.分类 2.系列", example = "2")
    private Integer type;

}