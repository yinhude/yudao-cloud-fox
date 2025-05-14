package cn.iocoder.yudao.module.bproduct.dal.dataobject.featurevaluecategoryrela;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 特征值关联 DO
 *
 * @author 合适连接器
 */
@TableName("bproduct_feature_value_category_rela")
@KeySequence("bproduct_feature_value_category_rela_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeatureValueCategoryRelaDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 关联对象id（特征值）
     */
    private Long relationId;
    /**
     * 产品id
     */
    private Long productId;
    /**
     * 0.品牌 1.种类 2.系列
     */
    private Integer type;

}