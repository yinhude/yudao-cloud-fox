package cn.iocoder.yudao.module.bproduct.dal.dataobject.featuregroup;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 特征值分组 DO
 *
 * @author 合适连接器
 */
@TableName("bproduct_feature_group")
@KeySequence("bproduct_feature_group_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeatureGroupDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 展示值
     */
    private String featureSourceId;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 展示值
     */
    private String label;

}