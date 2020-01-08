package com.aaa.repast.admin.project.system.homeRecommendProduct.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.repast.admin.framework.web.domain.BaseEntity;

/**
 * 人气推荐商品表 sms_home_recommend_product
 * 
 * @author Seven Lee
 * @date 2020-01-05
 */
public class HomeRecommendProduct extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/** 店铺ID */
	private Long shopId;
	/** 产品ID */
	private Long productId;
	/** 产品名称 */
	private String productName;
	/** 推荐状态，1推荐，0不再推荐 */
	private Integer recommendStatus;
	/** 排序字段 */
	private Integer sort;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setShopId(Long shopId) 
	{
		this.shopId = shopId;
	}

	public Long getShopId() 
	{
		return shopId;
	}
	public void setProductId(Long productId) 
	{
		this.productId = productId;
	}

	public Long getProductId() 
	{
		return productId;
	}
	public void setProductName(String productName) 
	{
		this.productName = productName;
	}

	public String getProductName() 
	{
		return productName;
	}
	public void setRecommendStatus(Integer recommendStatus) 
	{
		this.recommendStatus = recommendStatus;
	}

	public Integer getRecommendStatus() 
	{
		return recommendStatus;
	}
	public void setSort(Integer sort) 
	{
		this.sort = sort;
	}

	public Integer getSort() 
	{
		return sort;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shopId", getShopId())
            .append("productId", getProductId())
            .append("productName", getProductName())
            .append("recommendStatus", getRecommendStatus())
            .append("sort", getSort())
            .toString();
    }
}
