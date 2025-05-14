package cn.iocoder.yudao.module.bproduct.dal.dataobject.partchinarohscompliance;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * rohs DO
 *
 * @author 合适连接器
 */
@TableName("bproduct_part_china_rohs_compliance")
@KeySequence("bproduct_part_china_rohs_compliance_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartChinaRohsComplianceDO extends BaseDO {

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
     * epup_code受限编码
     */
    private String epupComplianceCode;
    /**
     * 描述
     */
    private String epupComplianceDesc;
    /**
     * 图片路径
     */
    private String epupImageUrl;

}