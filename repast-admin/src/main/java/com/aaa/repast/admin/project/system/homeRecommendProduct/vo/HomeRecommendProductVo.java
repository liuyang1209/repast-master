package com.aaa.repast.admin.project.system.homeRecommendProduct.vo;

import com.aaa.repast.admin.framework.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * liyong
 *

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class HomeRecommendProductVo extends BaseEntity {

    /*商品表的商品id*/
    private Long id;
    /*商品表的商品名字*/
    private String name;
    /*商品推荐表中的店铺id*/
    private Long shop_id;
}
