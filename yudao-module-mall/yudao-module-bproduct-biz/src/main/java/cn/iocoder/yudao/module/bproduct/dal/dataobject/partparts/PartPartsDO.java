package cn.iocoder.yudao.module.bproduct.dal.dataobject.partparts;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * part合规性 DO
 *
 * @author 合适连接器
 */
@TableName("bproduct_part_parts")
@KeySequence("bproduct_part_parts_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartPartsDO extends BaseDO {

    /**
     * 主键id
     */
    @TableId
    private Long id;
    /**
     * 产品ID
     */
    private Long productId;
    /**
     * part_num
     */
    private String partNum;
    /**
     * leaf code
     */
    private String leadFreeProcessCode;
    /**
     * 描述
     */
    private String leadFreeProcessDesc;
    /**
     * material_declaration_indicator
     */
    private String materialDeclarationIndicator;

}