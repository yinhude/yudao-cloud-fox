package cn.iocoder.yudao.module.bproduct.controller.admin.category.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 商品系列新增/修改 Request VO")
@Data
public class CategorySaveReqVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "3103")
    private Long id;

    @Schema(description = "品牌id(如果没有就是合适自己的分类数据)", example = "20498")
    private Long brandId;

    @Schema(description = "父级id", example = "30252")
    private Long parentId;

    @Schema(description = "元数据id", example = "19858")
    private String originId;

    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @NotEmpty(message = "名称不能为空")
    private String name;

    @Schema(description = "关键字")
    private String keywords;

    @Schema(description = "简称", example = "赵六")
    private String shortName;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "元数据字段")
    private String facet;

    @Schema(description = "层级")
    private Integer level;

    @Schema(description = "系列图片url", example = "https://www.iocoder.cn")
    private String categoryPicUrl;

    @Schema(description = "0:初始化 	1:applications:标识应用场景	2:series:系列	3:standards：标准	4:industries：行业	5:category：分类	6:productfamilary	7:合适种类信息（level0->根路径 level1->元器件种类 level->2种类下的小种类 level->3系列）", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "0:初始化 	1:applications:标识应用场景	2:series:系列	3:standards：标准	4:industries：行业	5:category：分类	6:productfamilary	7:合适种类信息（level0->根路径 level1->元器件种类 level->2种类下的小种类 level->3系列）不能为空")
    private Integer type;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "描述", example = "随便")
    private String description;

    @Schema(description = "状态 1 正常  0 停用", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "状态 1 正常  0 停用不能为空")
    private Integer status;

}