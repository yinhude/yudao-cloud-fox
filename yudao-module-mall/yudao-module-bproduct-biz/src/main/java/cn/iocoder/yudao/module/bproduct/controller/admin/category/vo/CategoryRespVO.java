package cn.iocoder.yudao.module.bproduct.controller.admin.category.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 商品系列 Response VO")
@Data
@ExcelIgnoreUnannotated
public class CategoryRespVO {

    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED, example = "3103")
    @ExcelProperty("主键id")
    private Long id;

    @Schema(description = "品牌id(如果没有就是合适自己的分类数据)", example = "20498")
    @ExcelProperty("品牌id(如果没有就是合适自己的分类数据)")
    private Long brandId;

    @Schema(description = "父级id", example = "30252")
    @ExcelProperty("父级id")
    private Long parentId;

    @Schema(description = "元数据id", example = "19858")
    @ExcelProperty("元数据id")
    private String originId;

    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @ExcelProperty("名称")
    private String name;

    @Schema(description = "关键字")
    @ExcelProperty("关键字")
    private String keywords;

    @Schema(description = "简称", example = "赵六")
    @ExcelProperty("简称")
    private String shortName;

    @Schema(description = "标题")
    @ExcelProperty("标题")
    private String title;

    @Schema(description = "元数据字段")
    @ExcelProperty("元数据字段")
    private String facet;

    @Schema(description = "层级")
    @ExcelProperty("层级")
    private Integer level;

    @Schema(description = "系列图片url", example = "https://www.iocoder.cn")
    @ExcelProperty("系列图片url")
    private String categoryPicUrl;

    @Schema(description = "0:初始化 	1:applications:标识应用场景	2:series:系列	3:standards：标准	4:industries：行业	5:category：分类	6:productfamilary	7:合适种类信息（level0->根路径 level1->元器件种类 level->2种类下的小种类 level->3系列）", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("0:初始化 	1:applications:标识应用场景	2:series:系列	3:standards：标准	4:industries：行业	5:category：分类	6:productfamilary	7:合适种类信息（level0->根路径 level1->元器件种类 level->2种类下的小种类 level->3系列）")
    private Integer type;

    @Schema(description = "排序")
    @ExcelProperty("排序")
    private Integer sort;

    @Schema(description = "描述", example = "随便")
    @ExcelProperty("描述")
    private String description;

    @Schema(description = "状态 1 正常  0 停用", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("状态 1 正常  0 停用")
    private Integer status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}