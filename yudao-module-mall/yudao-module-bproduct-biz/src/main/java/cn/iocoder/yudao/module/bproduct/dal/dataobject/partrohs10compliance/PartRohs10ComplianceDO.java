package cn.iocoder.yudao.module.bproduct.dal.dataobject.partrohs10compliance;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * rohs合规性 DO
 *
 * @author 合适连接器
 */
@TableName("bproduct_part_rohs10_compliance")
@KeySequence("bproduct_part_rohs10_compliance_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartRohs10ComplianceDO extends BaseDO {

    /**
     * 主键id
     */
    @TableId
    private Long id;
    /**
     * part_id
     */
    private Long partId;
    /**
     * code
     */
    private String complianceCode;
    /**
     * 描述
     */
    private String complianceDescription;
    /**
     * 描述
     */
    private String selfDescribingDesc;
    /**
     * 分组信息
     */
    private String productCategoryEn;
    /**
     * 分组信息
     */
    private String productCategoryZh;

}