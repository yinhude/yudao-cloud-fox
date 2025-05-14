package cn.iocoder.yudao.module.bproduct.dal.dataobject.partreachsvhcs;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * reach合规性 DO
 *
 * @author 合适连接器
 */
@TableName("bproduct_part_reach_svhcs")
@KeySequence("bproduct_part_reach_svhcs_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartReachSvhcsDO extends BaseDO {

    /**
     * 主键id
     */
    @TableId
    private Long id;
    /**
     * reach合规性表id
     */
    private Long reachComplianceId;
    /**
     * 具体信息
     */
    private String svhcName;

}