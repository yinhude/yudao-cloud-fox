package cn.iocoder.yudao.module.bproduct.dal.dataobject.partelvcompliance;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * elv合规数据 DO
 *
 * @author 合适连接器
 */
@TableName("bproduct_part_elv_compliance")
@KeySequence("bproduct_part_elv_compliance_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartElvComplianceDO extends BaseDO {

    /**
     * 主键id
     */
    @TableId
    private Long id;
    /**
     * part_id`
     */
    private Long partId;
    /**
     * ELV编码
     */
    private String complianceCode;
    /**
     * 描述信息
     */
    private String complianceDescription;
    /**
     * ELV详细描述
     */
    private String selfDescribingDesc;

}