package cn.iocoder.yudao.module.bproduct.dal.dataobject.primaryimages;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 商品主图 DO
 *
 * @author 合适连接器
 */
@TableName("bproduct_primary_images")
@KeySequence("bproduct_primary_images_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrimaryImagesDO extends BaseDO {

    /**
     * 主键id
     */
    @TableId
    private Long id;
    /**
     * 产品id
     */
    private Long productId;
    /**
     * 路径
     */
    private String path;
    /**
     * 图像路径
     */
    private String imageName;
    /**
     * url
     */
    private String url;
    /**
     * 本地路径
     */
    private String minioUrl;

}