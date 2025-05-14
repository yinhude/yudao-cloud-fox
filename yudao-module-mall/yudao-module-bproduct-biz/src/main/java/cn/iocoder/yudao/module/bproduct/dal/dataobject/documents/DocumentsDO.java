package cn.iocoder.yudao.module.bproduct.dal.dataobject.documents;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 文档 DO
 *
 * @author 合适连接器
 */
@TableName("bproduct_documents")
@KeySequence("bproduct_documents_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentsDO extends BaseDO {

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
     * 类型
     */
    private String type;
    /**
     * 产品id
     */
    private String revision;
    /**
     * 格式
     */
    private String format;
    /**
     * 语言
     */
    private String language;
    /**
     * 标题
     */
    private String title;
    /**
     * 名称
     */
    private String name;
    /**
     * 本地类型
     */
    private String localType;
    /**
     * 文件大小
     */
    private String rawFileSize;
    /**
     * 文件编号
     */
    private String docNumber;
    /**
     * lang code
     */
    private String langCode;
    /**
     * 页面显示大小
     */
    private String viewableSize;
    /**
     * 文件名称
     */
    private String filename;
    /**
     * 路径
     */
    private String url;
    /**
     * 本地存储路径
     */
    private String minioUrl;

}