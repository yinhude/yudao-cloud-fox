package cn.iocoder.yudao.module.bproduct.controller.admin.genghsgoods.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 脚本抓取控制 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GenghsGoodsRespVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "21230")
    @ExcelProperty("主键id")
    private Long id;

    @Schema(description = "型号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("型号")
    private String pn;

    @Schema(description = "0,初始状态 1,完成抓取 2,任务失败", example = "1")
    @ExcelProperty("0,初始状态 1,完成抓取 2,任务失败")
    private Boolean status;

    @Schema(description = "品牌id", requiredMode = Schema.RequiredMode.REQUIRED, example = "31692")
    @ExcelProperty("品牌id")
    private Long brandId;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}