package cn.iocoder.yudao.module.bproduct.controller.admin.genghsgoods.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 脚本抓取控制新增/修改 Request VO")
@Data
public class GenghsGoodsSaveReqVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "21230")
    private Long id;

    @Schema(description = "型号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "型号不能为空")
    private String pn;

    @Schema(description = "0,初始状态 1,完成抓取 2,任务失败", example = "1")
    private Boolean status;

    @Schema(description = "品牌id", requiredMode = Schema.RequiredMode.REQUIRED, example = "31692")
    @NotNull(message = "品牌id不能为空")
    private Long brandId;

}