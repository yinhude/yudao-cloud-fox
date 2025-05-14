/*
Navicat MySQL Data Transfer
Source Server         : 192.168.0.41
Source Server Version : 80002
Source Host           : 192.168.0.41:3306
Source Database       : ruoyi-vue-pro
Target Server Type    : MYSQL
Target Server Version : 80002
File Encoding         : 65001
Date: 2025-04-27 14:08:42
*/


SET FOREIGN_KEY_CHECKS=0;


-- ----------------------------
-- Table structure for bproduct_genghs_goods
-- ----------------------------
DROP TABLE IF EXISTS `bproduct_genghs_goods`;
CREATE TABLE `bproduct_genghs_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `pn` varchar(200) COLLATE utf8mb4_general_ci NOT NULL COMMENT '型号',
  `status` tinyint(1) DEFAULT '0' COMMENT '0,初始状态 1,完成抓取 2,任务失败',
  `brand_id` bigint(20) NOT NULL COMMENT '品牌id',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='脚本抓取控制表';


-- ----------------------------
-- Table structure for bproduct_brand
-- ----------------------------
DROP TABLE IF EXISTS `bproduct_brand`;
CREATE TABLE `bproduct_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '品牌名称',
  `short_name` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL  COMMENT '品牌简称',
  `url` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '对应的网址',
  `pic_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '品牌图片url',
  `sort` int(11) DEFAULT '0' COMMENT '品牌排序',
  `description` varchar(1024) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '品牌描述',
  `status` tinyint(4) NOT NULL COMMENT '状态 1 正常  0 停用',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='品牌表';



-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `bproduct_product`;
CREATE TABLE `bproduct_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `origin_id` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '元数据id',
  `part_type` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '1:regular:产品  2:model:归类',
  `brand_id` bigint(20)  DEFAULT NULL COMMENT '品牌id',
  `self_category_id` bigint(20) DEFAULT NULL COMMENT '平台自身分类、系列id',
  `parent_category_id` bigint(20) DEFAULT NULL COMMENT '父级分类id',
  `description` varchar(1024) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '描述',
  `friendly_description` varchar(510) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '友好的描述',
  `tcpn` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '产品型号',
  `elv_compliance` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'elv描述',
  `product_owning_profit_center` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL  COMMENT 'elv描述',
  `replacement_product_exists` tinyint(2) DEFAULT NULL COMMENT '替代品是否存在',
  `bu_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '未知字段',
  `series_id` bigint(20) DEFAULT NULL COMMENT '系列id',
  `family_id` bigint(20) DEFAULT NULL COMMENT '家族描述id',
  `rohs_compliance` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '合规性',
  `marketing_part_number` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '内部型号',
  `milSpec_number` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '军用型号',
  `marketing_part_num_normalized` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '型号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态 1 正常  0 停用',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `tcpn` (`tcpn`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品系列表';

-- ----------------------------
-- Table structure for bproduct_category
-- ----------------------------
DROP TABLE IF EXISTS `bproduct_category`;
CREATE TABLE `bproduct_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `brand_id` bigint(20)  DEFAULT NULL COMMENT '品牌id(如果没有就是合适自己的分类数据)',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级id',
  `origin_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '元数据id',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `short_name` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL  COMMENT '简称',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标题',
  `facet` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '元数据字段',
  `level` int(6) DEFAULT '0' COMMENT '层级',
  `category_pic_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '系列图片url',
  `type` int(6) NOT NULL COMMENT '0:初始化 \r\n1:applications:标识应用场景\r\n2:series:系列\r\n3:standards：标准\r\n4:industries：行业\r\n5:category：分类\r\n6:productfamilary\r\n7:合适种类信息（level0->根路径 level1->元器件种类 level->2种类下的小种类 level->3系列）',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `description` varchar(1024) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '描述',
  `status` tinyint(4) NOT NULL COMMENT '状态 1 正常  0 停用',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品系列表';


-- ----------------------------
-- Table structure for product_documents
-- ----------------------------
DROP TABLE IF EXISTS `bproduct_documents`;
CREATE TABLE `bproduct_documents` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT  COMMENT '主键id',
  `product_id` bigint(20) NOT NULL  COMMENT '产品id',
  `type` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '类型',
  `revision` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '产品id',
  `format` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '格式',
  `language` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '语言',
  `title` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标题',
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '名称',
  `local_type` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '本地类型',
  `raw_file_size` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件大小',
  `doc_number` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件编号',
  `lang_code` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'lang code',
  `viewable_size` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '页面显示大小',
  `filename` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件名称',
  `url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '路径',
  `minio_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '本地存储路径',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='文档表';



-- ----------------------------
-- Table structure for product_feature_group
-- ----------------------------
DROP TABLE IF EXISTS `bproduct_feature_group`;
CREATE TABLE `bproduct_feature_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `feature_source_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '展示值',
  `sort` int(20) DEFAULT NULL COMMENT '排序',
  `label` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '展示值',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='特征值分组表';



-- ----------------------------
-- Table structure for product_feature
-- ----------------------------
DROP TABLE IF EXISTS `bproduct_feature`;
CREATE TABLE `bproduct_feature` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `origin_id` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '元数据id',
  `code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '编码',
  `display_value` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '展示值',
  `numeric` tinyint(2) DEFAULT NULL COMMENT '是否是数值',
  `filter_only` tinyint(2) DEFAULT NULL COMMENT '是否支持筛选',
  `sort` int(20) DEFAULT NULL COMMENT '排序',
  `attribute_type` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '未知参数',
  `primary_flag` tinyint(2) DEFAULT NULL  COMMENT '主要参数',
  `primary_source_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL  COMMENT '主要字段',
  `help_info_vailable` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '未知参数',
  `uom` tinyint(2) DEFAULT NULL COMMENT '未知',
  `ui_widget` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '未知',
  `show_in_compare_view` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '展示',
  `label` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '展示值',
  `type` tinyint(20) DEFAULT NULL COMMENT '1:primary 2:normal',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='特征表';


-- ----------------------------
-- Table structure for product_feature_rela
-- ----------------------------
DROP TABLE IF EXISTS `bproduct_feature_value_category_rela`;
CREATE TABLE `bproduct_feature_value_category_rela` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `relation_id` bigint(20) DEFAULT NULL COMMENT '关联对象id（特征值）',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `type` tinyint(6) DEFAULT NULL COMMENT '0.品牌 1.种类 2.系列',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='特征值关联表';


-- ----------------------------
-- Table structure for product_feature_rela
-- ----------------------------
DROP TABLE IF EXISTS `bproduct_feature_value_rela`;
CREATE TABLE `bproduct_feature_value_rela` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `relation_id` bigint(20) DEFAULT NULL COMMENT '关联对象id（特征值）',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `type` tinyint(6) DEFAULT NULL COMMENT '1 feature 特性   2 合规性',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='特征值关联表';

-- ----------------------------
-- Table structure for product_feature_value
-- ----------------------------
DROP TABLE IF EXISTS `bproduct_feature_value`;
CREATE TABLE `bproduct_feature_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `dim_val_id` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '特性值id',
  `display_value` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '展示值',
  `primary_source_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '主键id',
  `value` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '值',
  `system` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '系统值',
  `unit` varchar(24) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '单位',
  `sort` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '排序',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='特征值表';


-- ----------------------------
-- Table structure for product_images
-- ----------------------------
DROP TABLE IF EXISTS `bproduct_images`;
CREATE TABLE `bproduct_images` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `product_id` bigint(20) NOT NULL COMMENT '产品id',
  `image_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件名称',
  `image_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件路径',
  `image_thumbnail_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '缩略图路径',
  `minio_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'minio路径',
  `minio_thumbnail_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'minio缩略图路径',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='图片表';

-- ----------------------------
-- Table structure for product_part_china_rohs_compliance
-- ----------------------------
DROP TABLE IF EXISTS `bproduct_part_china_rohs_compliance`;
CREATE TABLE `bproduct_part_china_rohs_compliance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT  COMMENT '主键id',
  `part_id` bigint(20) NOT NULL  COMMENT 'part_id`',
  `epup_compliance_code` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT 'epup_code受限编码',
  `epup_compliance_desc` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '描述',
  `epup_image_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '图片路径',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `part_id` (`part_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci  COMMENT='rohs表';

-- ----------------------------
-- Table structure for product_part_elv_compliance
-- ----------------------------
DROP TABLE IF EXISTS `bproduct_part_elv_compliance`;
CREATE TABLE `bproduct_part_elv_compliance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT  COMMENT '主键id',
  `part_id` bigint(20) NOT NULL COMMENT 'part_id`',
  `compliance_code` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'ELV编码',
  `compliance_description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述信息',
  `self_describing_desc` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'ELV详细描述',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `part_id` (`part_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='elv合规数据表';

-- ----------------------------
-- Table structure for product_part_elv_not_compliant_substances
-- ----------------------------
DROP TABLE IF EXISTS `bproduct_part_elv_not_compliant_substances`;
CREATE TABLE `bproduct_part_elv_not_compliant_substances` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT  COMMENT '主键id',
  `elv_compliance_id` bigint(20) NOT NULL COMMENT 'elvID',
  `substance_name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '子名称',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `elv_compliance_id` (`elv_compliance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci  COMMENT='elv不合规含量子表';

-- ----------------------------
-- Table structure for product_part_parts
-- ----------------------------
DROP TABLE IF EXISTS `bproduct_part_parts`;
CREATE TABLE `bproduct_part_parts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT   COMMENT '主键id',
  `product_id` bigint(20) NOT NULL COMMENT '产品ID',
  `part_num` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'part_num',
  `lead_free_process_code` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'leaf code',
  `lead_free_process_desc` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
  `material_declaration_indicator` char(1) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'material_declaration_indicator',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci  COMMENT='part合规性表';

-- ----------------------------
-- Table structure for product_part_reach_compliances
-- ----------------------------
DROP TABLE IF EXISTS `bproduct_part_reach_compliances`;
CREATE TABLE `bproduct_part_reach_compliances` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `part_id` bigint(20) NOT NULL COMMENT 'partid',
  `reach_cmpl` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '法规信息',
  `candidate_date` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '发布日期',
  `declaration_date` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新日期',
  `declaration_code` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'code',
  `contains_reach` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '超出限值',
  `decl_date_flag` tinyint(1) DEFAULT NULL COMMENT 'decl_date_flag',
  `cand_date_flag` tinyint(1) DEFAULT NULL COMMENT 'cand_date_flag',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `part_id` (`part_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci  COMMENT='reach合规性表';

-- ----------------------------
-- Table structure for product_part_reach_svhcs
-- ----------------------------
DROP TABLE IF EXISTS `bproduct_part_reach_svhcs`;
CREATE TABLE `bproduct_part_reach_svhcs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT  COMMENT '主键id',
  `reach_compliance_id` bigint(20) NOT NULL  COMMENT 'reach合规性表id',
  `svhc_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '具体信息',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `reach_compliance_id` (`reach_compliance_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci  COMMENT='reach合规性表';

-- ----------------------------
-- Table structure for product_part_rohs10_compliance
-- ----------------------------
DROP TABLE IF EXISTS `bproduct_part_rohs10_compliance`;
CREATE TABLE `bproduct_part_rohs10_compliance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT  COMMENT '主键id',
  `part_id` bigint(20) NOT NULL  COMMENT 'part_id',
  `compliance_code` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL   COMMENT 'code',
  `compliance_description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL   COMMENT '描述',
  `self_describing_desc` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL   COMMENT '描述',
  `product_category_en` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '分组信息',
  `product_category_zh` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '分组信息',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `part_id` (`part_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='rohs合规性表';

-- ----------------------------
-- Table structure for product_part_rohs10_not_compliant_substances
-- ----------------------------
DROP TABLE IF EXISTS `bproduct_part_rohs10_not_compliant_substances`;
CREATE TABLE `bproduct_part_rohs10_not_compliant_substances` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `rohs10_compliance_id` bigint(20) NOT NULL COMMENT 'rohs',
  `substance_name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '子系列名称',
  `contains_substance` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '包含的子系列',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `rohs10_compliance_id` (`rohs10_compliance_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='rohs不符合的含量表';

-- ----------------------------
-- Table structure for product_primary_images
-- ----------------------------
DROP TABLE IF EXISTS `bproduct_primary_images`;
CREATE TABLE `bproduct_primary_images` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `product_id` bigint(20) NOT NULL COMMENT '产品id',
  `path` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '路径',
  `image_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图像路径',
  `url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'url',
  `minio_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '本地路径',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品主图表';

-- ----------------------------
-- Table structure for product_similar
-- ----------------------------
DROP TABLE IF EXISTS `bproduct_similar`;
CREATE TABLE `bproduct_similar` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `relation_id` bigint(20) DEFAULT NULL COMMENT '关联对象id',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `type` tinyint(6) DEFAULT NULL COMMENT '1.替代品 0.相似商品',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品替代品表';

-- ----------------------------
-- Table structure for product_thumbnail_images
-- ----------------------------
DROP TABLE IF EXISTS `bproduct_thumbnail_images`;
CREATE TABLE `bproduct_thumbnail_images` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_id` bigint(20) NOT NULL COMMENT '产品id',
  `path` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '路径',
  `image_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片名称',
  `url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '路径',
  `minio_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'minio路径',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品缩略图表';
