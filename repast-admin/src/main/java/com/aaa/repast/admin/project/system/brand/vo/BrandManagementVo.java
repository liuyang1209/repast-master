package com.aaa.repast.admin.project.system.brand.vo;

import com.aaa.repast.admin.framework.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 *liyong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BrandManagementVo  extends BaseEntity {

    private Long id;
    /*商品信息中关联店铺表的shop_id*/
    private Long shop_id;
    /*品牌管理表中的品牌名字*/
    private String name;
    /*品牌表中的品牌首字母*/
    private String first_letter;
    /*品牌排序*/
    private Integer sort;
    /*是否为品牌制造商：0->不是；1->是*/
    private String factory_status;
    /*是否显示*/
    private Integer show_status;
    /*商品表中的商品数量*/
    private Integer stock;
    /*评论表中的产品编号,产品评论数量*/
    private Long product_id;
    /*品牌logo*/
    private String logo;
    /*品牌表中专区大图*/
    private String big_pic;
    /*品牌表品牌故事*/
    private String brand_story;



}
