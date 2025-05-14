package cn.iocoder.yudao.module.bproduct.dal.dataobject.similar;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 商品替代品 DO
 *
 * @author 合适连接器
 */
@TableName("bproduct_similar")
@KeySequence("bproduct_similar_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimilarDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 关联型号
     */
    private String relationPn;
    /**
     * 关联对象id
     */
    private Long relationId;
    /**
     * 产品id
     */
    private Long productId;
    /**
     * 1.替代品 2.对配 3.配套
     */
    private Integer type;

}