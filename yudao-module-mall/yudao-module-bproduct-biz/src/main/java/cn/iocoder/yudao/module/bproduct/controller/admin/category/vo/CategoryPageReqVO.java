package cn.iocoder.yudao.module.bproduct.controller.admin.category.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 商品系列分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CategoryPageReqVO extends PageParam {

    @Schema(description = "品牌id(如果没有就是合适自己的分类数据)", example = "27305")
    private Long brandId;

    @Schema(description = "父级id", example = "27738")
    private Long parentId;

    @Schema(description = "元数据id", example = "22800")
    private String originId;

    @Schema(description = "名称", example = "张三")
    private String name;

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

    @Schema(description = "0:初始化 	1:applications:标识应用场景	2:series:系列	3:standards：标准	4:industries：行业	5:category：分类	6:productfamilary	7:合适种类信息（level0->根路径 level1->元器件种类 level->2种类下的小种类 level->3系列）", example = "1")
    private Integer type;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "描述", example = "随便")
    private String description;

    @Schema(description = "状态 1 正常  0 停用", example = "1")
    private Integer status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}