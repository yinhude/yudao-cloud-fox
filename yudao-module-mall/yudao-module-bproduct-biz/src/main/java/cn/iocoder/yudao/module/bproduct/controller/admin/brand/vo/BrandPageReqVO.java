package cn.iocoder.yudao.module.bproduct.controller.admin.brand.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 品牌分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BrandPageReqVO extends PageParam {

    @Schema(description = "品牌名称", example = "芋艿")
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

    @Schema(description = "状态 1 正常  0 停用", example = "2")
    private Integer status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}