package cn.iocoder.yudao.module.bproduct.dal.dataobject.partreachcompliances;

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
@TableName("bproduct_part_reach_compliances")
@KeySequence("bproduct_part_reach_compliances_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartReachCompliancesDO extends BaseDO {

    /**
     * 主键id
     */
    @TableId
    private Long id;
    /**
     * partid
     */
    private Long partId;
    /**
     * 法规信息
     */
    private String reachCmpl;
    /**
     * 发布日期
     */
    private String candidateDate;
    /**
     * 更新日期
     */
    private String declarationDate;
    /**
     * code
     */
    private String declarationCode;
    /**
     * 超出限值
     */
    private String containsReach;
    /**
     * decl_date_flag
     */
    private Boolean declDateFlag;
    /**
     * cand_date_flag
     */
    private Boolean candDateFlag;

}