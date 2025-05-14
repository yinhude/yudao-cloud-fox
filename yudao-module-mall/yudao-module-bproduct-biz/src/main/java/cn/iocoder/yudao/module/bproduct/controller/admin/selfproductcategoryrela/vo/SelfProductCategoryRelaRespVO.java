package cn.iocoder.yudao.module.bproduct.controller.admin.selfproductcategoryrela.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 产品和自有分类的关联性 Response VO")
@Data
@ExcelIgnoreUnannotated
public class SelfProductCategoryRelaRespVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "20742")
    @ExcelProperty("主键")
    private Long id;

    @Schema(description = "关联对象id", example = "19507")
    @ExcelProperty("关联对象id")
    private Long relationId;

    @Schema(description = "产品id", example = "22325")
    @ExcelProperty("产品id")
    private Long productId;

    @Schema(description = "1.分类 2.系列", example = "2")
    @ExcelProperty("1.分类 2.系列")
    private Integer type;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}