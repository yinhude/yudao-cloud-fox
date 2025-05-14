package cn.iocoder.yudao.module.bproduct.dal.dataobject.product;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 商品系列 DO
 *
 * @author 合适连接器
 */
@TableName("bproduct_product")
@KeySequence("bproduct_product_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDO extends BaseDO {

    /**
     * 主键id
     */
    @TableId
    private Long id;
    /**
     * 元数据id
     */
    private String originId;
    /**
     * 图片地址
     */
    private String img;
    /**
     * 1:regular:产品  2:model:归类
     */
    private String partType;
    /**
     * 品牌id
     */
    private Long brandId;
    /**
     * 平台自身分类、系列id
     */
    private Long selfCategoryId;
    /**
     * 父级分类id
     */
    private Long parentCategoryId;
    /**
     * 描述
     */
    private String description;
    /**
     * 友好的描述
     */
    private String friendlyDescription;
    /**
     * 产品型号
     */
    private String tcpn;
    /**
     * elv描述
     */
    private String elvCompliance;
    /**
     * elv描述
     */
    private String productOwningProfitCenter;
    /**
     * 替代品是否存在
     */
    private Integer replacementProductExists;
    /**
     * 属性
     */
    private String attributeName;
    /**
     * 未知字段
     */
    private String buName;
    /**
     * 系列id
     */
    private Long seriesId;
    /**
     * 家族描述id
     */
    private Long familyId;
    /**
     * 合规性
     */
    private String rohsCompliance;
    /**
     * 内部型号
     */
    private String marketingPartNumber;
    /**
     * 军用型号
     */
    private String milspecNumber;
    /**
     * 型号
     */
    private String marketingPartNumNormalized;
    /**
     * 状态 1 正常  0 停用
     */
    private Integer status;

}