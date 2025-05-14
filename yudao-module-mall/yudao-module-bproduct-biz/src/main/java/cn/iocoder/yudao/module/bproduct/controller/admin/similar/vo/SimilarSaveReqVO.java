package cn.iocoder.yudao.module.bproduct.controller.admin.similar.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 商品替代品新增/修改 Request VO")
@Data
public class SimilarSaveReqVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "17728")
    private Long id;

    @Schema(description = "关联型号")
    private String relationPn;

    @Schema(description = "关联对象id", example = "26280")
    private Long relationId;

    @Schema(description = "产品id", example = "21402")
    private Long productId;

    @Schema(description = "1.替代品 2.对配 3.配套", example = "1")
    private Integer type;

}