package cn.iocoder.yudao.module.bproduct.dal.dataobject.thumbnailimages;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 商品缩略图 DO
 *
 * @author 合适连接器
 */
@TableName("bproduct_thumbnail_images")
@KeySequence("bproduct_thumbnail_images_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ThumbnailImagesDO extends BaseDO {

    /**
     * 主键
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
     * 图片名称
     */
    private String imageName;
    /**
     * 路径
     */
    private String url;
    /**
     * minio路径
     */
    private String minioUrl;

}