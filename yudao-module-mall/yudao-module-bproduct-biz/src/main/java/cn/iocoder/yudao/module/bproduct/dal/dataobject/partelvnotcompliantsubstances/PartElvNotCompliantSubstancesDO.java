package cn.iocoder.yudao.module.bproduct.dal.dataobject.partelvnotcompliantsubstances;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * elv不合规含量子 DO
 *
 * @author 合适连接器
 */
@TableName("bproduct_part_elv_not_compliant_substances")
@KeySequence("bproduct_part_elv_not_compliant_substances_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartElvNotCompliantSubstancesDO extends BaseDO {

    /**
     * 主键id
     */
    @TableId
    private Long id;
    /**
     * elvID
     */
    private Long elvComplianceId;
    /**
     * 子名称
     */
    private String substanceName;

}