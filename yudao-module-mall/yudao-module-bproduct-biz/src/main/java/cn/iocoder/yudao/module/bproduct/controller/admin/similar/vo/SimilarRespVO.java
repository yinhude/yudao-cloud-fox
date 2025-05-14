package cn.iocoder.yudao.module.bproduct.controller.admin.similar.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 商品替代品 Response VO")
@Data
@ExcelIgnoreUnannotated
public class SimilarRespVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "17728")
    @ExcelProperty("主键")
    private Long id;

    @Schema(description = "关联型号")
    @ExcelProperty("关联型号")
    private String relationPn;

    @Schema(description = "关联对象id", example = "26280")
    @ExcelProperty("关联对象id")
    private Long relationId;

    @Schema(description = "产品id", example = "21402")
    @ExcelProperty("产品id")
    private Long productId;

    @Schema(description = "1.替代品 2.对配 3.配套", example = "1")
    @ExcelProperty("1.替代品 2.对配 3.配套")
    private Integer type;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}