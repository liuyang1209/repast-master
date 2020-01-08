package com.aaa.repast.admin.project.system.product.domain;


import com.aaa.repast.admin.framework.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProductVos extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String  shopName;

    private String brandNames;

    private  String productCategoryNames;

    private String productAttributeCategoryName;

    /**  */
    private Long id;
    /** 店铺ID */
    private Long shopId;
    /** 品牌ID */
    private Long brandId;
    /** 产品类别ID */
    private Long productCategoryId;
    /** 产品属性类别ID */
    private Long productAttributeCategoryId;
    /** 名字 */
    private String name;
    /** 图片路径 */
    private String pic;
    /** 货号 */
    private String productSn;
    /** 删除状态：0->未删除；1->已删除 */
    private Integer deleteStatus;
    /** 上架状态：0->下架；1->上架 */
    private Integer publishStatus;
    /** 新品状态:0->不是新品；1->新品 */
    private Integer newStatus;
    /** 推荐状态；0->不推荐；1->推荐 */
    private Integer recommandStatus;
    /** 排序 */
    private Integer sort;
    /** 销量 */
    private Integer sale;
    /** 价格 */
    private BigDecimal price;
    /** 促销价格 */
    private BigDecimal promotionPrice;
    /** 赠送的积分 */
    private Integer giftPoint;
    /** 副标题 */
    private String subTitle;
    /** 商品描述 */
    private String description;
    /** 市场价 */
    private BigDecimal originalPrice;
    /** 库存 */
    private Integer stock;
    /** 库存预警值 */
    private Integer lowStock;
    /** 单位 */
    private String unit;
    /** 商品重量，默认为克 */
    private BigDecimal weight;
    /** 以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮 */
    private String serviceIds;
    /** 关键字 */
    private String keywords;
    /** 注意事项 */
    private String note;
    /** 画册id */
    private Long albumId;
    /** 详细标题 */
    private String detailTitle;
    /** 细节 */
    private String detailDesc;
    /** 产品详情网页内容 */
    private String detailHtml;
    /** 移动端网页详情 */
    private String detailMobileHtml;
    /** 促销开始时间 */
    private String promotionStartTime;
    /** 促销结束时间 */
    private String promotionEndTime;
    /** 活动限购数量 */
    private Integer promotionPerLimit;
    /** 促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购 */
    private Integer promotionType;
    /** 品牌名称 */
    private String brandName;
    /** 商品分类名称 */
    private String productCategoryName;
    /** 币种，0-> 人民币;  1-> 积分 */
    private Integer currency;
    /** 霸王餐0-->参加,1-->不参加 */
    private Integer free;



}
