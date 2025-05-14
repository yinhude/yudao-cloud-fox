package cn.iocoder.yudao.module.bproduct.dal.dataobject.feature;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 特征 DO
 *
 * @author 合适连接器
 */
@TableName("bproduct_feature")
@KeySequence("bproduct_feature_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeatureDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 元数据id
     */
    private String originId;
    /**
     * 编码
     */
    private String code;
    /**
     * 展示值
     */
    private String displayValue;
    /**
     * 是否是数值
     */
    private Integer numeric;
    /**
     * 是否支持筛选
     */
    private Integer filterOnly;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 未知参数
     */
    private String attributeType;
    /**
     * 主要参数
     */
    private Integer primaryFlag;
    /**
     * 主要字段
     */
    private String primarySourceId;
    /**
     * 未知参数
     */
    private String helpInfoVailable;
    /**
     * 未知
     */
    private Integer uom;
    /**
     * 未知
     */
    private String uiWidget;
    /**
     * 展示
     */
    private String showInCompareView;
    /**
     * 展示值
     */
    private String label;
    /**
     * 1:primary 2:normal
     */
    private Integer type;

}