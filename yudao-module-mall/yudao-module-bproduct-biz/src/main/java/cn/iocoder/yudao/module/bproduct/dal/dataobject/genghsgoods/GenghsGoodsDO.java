package cn.iocoder.yudao.module.bproduct.dal.dataobject.genghsgoods;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 脚本抓取控制 DO
 *
 * @author 合适连接器
 */
@TableName("bproduct_genghs_goods")
@KeySequence("bproduct_genghs_goods_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenghsGoodsDO extends BaseDO {

    /**
     * 主键id
     */
    @TableId
    private Long id;
    /**
     * 型号
     */
    private String pn;
    /**
     * 0,初始状态 1,完成抓取 2,任务失败
     */
    private Boolean status;
    /**
     * 品牌id
     */
    private Long brandId;

}