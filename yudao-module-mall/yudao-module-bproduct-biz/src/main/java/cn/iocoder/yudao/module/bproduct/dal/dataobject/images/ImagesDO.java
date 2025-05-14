package cn.iocoder.yudao.module.bproduct.dal.dataobject.images;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 图片 DO
 *
 * @author 合适连接器
 */
@TableName("bproduct_images")
@KeySequence("bproduct_images_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImagesDO extends BaseDO {

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
     * 文件名称
     */
    private String imageName;
    /**
     * 文件路径
     */
    private String imageUrl;
    /**
     * 缩略图路径
     */
    private String imageThumbnailUrl;
    /**
     * minio路径
     */
    private String minioUrl;
    /**
     * minio缩略图路径
     */
    private String minioThumbnailUrl;

}