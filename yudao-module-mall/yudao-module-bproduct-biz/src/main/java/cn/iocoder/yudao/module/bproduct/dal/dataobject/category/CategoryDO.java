package cn.iocoder.yudao.module.bproduct.dal.dataobject.category;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 商品系列 DO
 *
 * @author 合适连接器
 */
@TableName("bproduct_category")
@KeySequence("bproduct_category_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDO extends BaseDO {

    public static final Long PARENT_ID_ROOT = 0L;

    /**
     * 主键id
     */
    @TableId
    private Long id;
    /**
     * 品牌id(如果没有就是合适自己的分类数据)
     */
    private Long brandId;
    /**
     * 父级id
     */
    private Long parentId;
    /**
     * 元数据id
     */
    private String originId;
    /**
     * 名称
     */
    private String name;
    /**
     * 关键字
     */
    private String keywords;
    /**
     * 简称
     */
    private String shortName;
    /**
     * 标题
     */
    private String title;
    /**
     * 元数据字段
     */
    private String facet;
    /**
     * 层级
     */
    private Integer level;
    /**
     * 系列图片url
     */
    private String categoryPicUrl;
    /**
     * 0:初始化 	1:applications:标识应用场景	2:series:系列	3:standards：标准	4:industries：行业	5:category：分类	6:productfamilary	7:合适种类信息（level0->根路径 level1->元器件种类 level->2种类下的小种类 level->3系列）
     */
    private Integer type;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 描述
     */
    private String description;
    /**
     * 状态 1 正常  0 停用
     */
    private Integer status;

}