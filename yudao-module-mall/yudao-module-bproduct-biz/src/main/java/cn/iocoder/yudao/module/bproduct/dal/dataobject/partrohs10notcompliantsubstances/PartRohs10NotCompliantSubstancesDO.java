package cn.iocoder.yudao.module.bproduct.dal.dataobject.partrohs10notcompliantsubstances;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * rohs不符合的含量 DO
 *
 * @author 合适连接器
 */
@TableName("bproduct_part_rohs10_not_compliant_substances")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartRohs10NotCompliantSubstancesDO extends BaseDO {

    /**
     * 主键id
     */
    @TableId
    private Long id;
    /**
     * rohs
     */
    private Long rohs10ComplianceId;
    /**
     * 子系列名称
     */
    private String substanceName;
    /**
     * 包含的子系列
     */
    private String containsSubstance;

}