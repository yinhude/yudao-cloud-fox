package cn.iocoder.yudao.module.bproduct.dal.dataobject.featurevalue;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 特征值 DO
 *
 * @author 合适连接器
 */
@TableName("bproduct_feature_value")
@KeySequence("bproduct_feature_value_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeatureValueDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 特性值id
     */
    private String dimValId;
    /**
     * 展示值
     */
    private String displayValue;
    /**
     * 主键id
     */
    private String primarySourceId;
    /**
     * 关键字
     */
    private String keywords;
    /**
     * 值
     */
    private String value;
    /**
     * 系统值
     */
    private String system;
    /**
     * 单位
     */
    private String unit;
    /**
     * 排序
     */
    private String sort;

}