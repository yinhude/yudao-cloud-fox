package cn.iocoder.yudao.module.bproduct.dal.dataobject.brand;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 品牌 DO
 *
 * @author 合适连接器
 */
@TableName("bproduct_brand")
@KeySequence("bproduct_brand_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrandDO extends BaseDO {

    /**
     * 主键id
     */
    @TableId
    private Long id;
    /**
     * 品牌名称
     */
    private String name;
    /**
     * 首字母
     */
    private String firstChar;
    /**
     * 区域名称
     */
    private String originName;
    /**
     * 区域编码
     */
    private String originCode;
    /**
     * 品牌简称
     */
    private String shortName;
    /**
     * 对应的网址
     */
    private String url;
    /**
     * 品牌图片url
     */
    private String picUrl;
    /**
     * 品牌排序
     */
    private Integer sort;
    /**
     * 关键字
     */
    private String keywords;
    /**
     * 品牌描述
     */
    private String description;
    /**
     * 状态 1 正常  0 停用
     */
    private Integer status;

}