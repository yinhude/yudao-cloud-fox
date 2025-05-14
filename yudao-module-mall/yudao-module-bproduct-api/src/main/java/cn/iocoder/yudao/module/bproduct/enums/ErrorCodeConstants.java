package cn.iocoder.yudao.module.bproduct.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * Product 错误码枚举类
 *
 * product 系统，使用 1-008-000-000 段
 */
public interface ErrorCodeConstants {
    ErrorCode PART_ROHS10_NOT_COMPLIANT_SUBSTANCES_NOT_EXISTS = new ErrorCode(1_016_001_000, "rohs不符合的含量不存在");
    ErrorCode PART_ROHS10_COMPLIANCE_NOT_EXISTS = new ErrorCode(1_016_001_001, "rohs合规性不存在");
    ErrorCode PART_REACH_SVHCS_NOT_EXISTS = new ErrorCode(1_016_001_002, "reach合规性不存在");
    ErrorCode PART_REACH_COMPLIANCES_NOT_EXISTS = new ErrorCode(1_016_001_003, "reach合规性不存在");
    ErrorCode FEATURE_VALUE_RELA_NOT_EXISTS = new ErrorCode(1_016_001_004, "特征值关联不存在");
    ErrorCode FEATURE_VALUE_CATEGORY_RELA_NOT_EXISTS = new ErrorCode(1_016_001_005, "特征值关联不存在");
    ErrorCode PART_PARTS_NOT_EXISTS = new ErrorCode(1_016_001_006, "part合规性不存在");
    ErrorCode PART_ELV_NOT_COMPLIANT_SUBSTANCES_NOT_EXISTS = new ErrorCode(1_016_001_007, "elv不合规含量子不存在");
    ErrorCode PART_ELV_COMPLIANCE_NOT_EXISTS = new ErrorCode(1_016_001_008, "elv合规数据不存在");
    ErrorCode THUMBNAIL_IMAGES_NOT_EXISTS = new ErrorCode(1_016_001_009, "商品缩略图不存在");
    ErrorCode PRODUCT_NOT_EXISTS = new ErrorCode(1_016_001_010, "商品系列不存在");
    ErrorCode PRIMARY_IMAGES_NOT_EXISTS = new ErrorCode(1_016_001_011, "商品主图不存在");
    ErrorCode FEATURE_GROUP_NOT_EXISTS = new ErrorCode(1_016_001_012, "特征值分组不存在");
    ErrorCode BRAND_NOT_EXISTS = new ErrorCode(1_016_001_013, "品牌不存在");
    ErrorCode FEATURE_NOT_EXISTS = new ErrorCode(1_016_001_014, "特征不存在");
    ErrorCode FEATURE_VALUE_NOT_EXISTS = new ErrorCode(1_016_001_016, "特征值不存在");
    ErrorCode DOCUMENTS_NOT_EXISTS = new ErrorCode(1_016_001_017, "文档不存在");
    ErrorCode GENGHS_GOODS_NOT_EXISTS = new ErrorCode(1_016_001_018, "脚本抓取控制不存在");
    ErrorCode IMAGES_NOT_EXISTS = new ErrorCode(1_016_001_019, "图片不存在");
    ErrorCode PART_CHINA_ROHS_COMPLIANCE_NOT_EXISTS = new ErrorCode(1_016_001_020, "rohs不存在");
    ErrorCode SIMILAR_NOT_EXISTS = new ErrorCode(1_016_001_021, "商品替代品不存在");
    ErrorCode CATEGORY_NOT_EXISTS = new ErrorCode(1_016_001_015, "商品系列不存在");
    ErrorCode CATEGORY_EXITS_CHILDREN = new ErrorCode(1_016_001_022, "存在存在子商品系列，无法删除");
    ErrorCode CATEGORY_PARENT_NOT_EXITS = new ErrorCode(1_016_001_023,"父级商品系列不存在");
    ErrorCode CATEGORY_PARENT_ERROR = new ErrorCode(1_016_001_024, "不能设置自己为父商品系列");
    ErrorCode CATEGORY_NAME_DUPLICATE = new ErrorCode(1_016_001_025, "已经存在该名称的商品系列");
    ErrorCode CATEGORY_PARENT_IS_CHILD = new ErrorCode(1_016_001_026, "不能设置自己的子Category为父Category");
    ErrorCode SELF_PRODUCT_CATEGORY_RELA_NOT_EXISTS = new ErrorCode(1_016_001_027, "产品和自有分类的关联性不存在");
}
