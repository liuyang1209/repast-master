package com.aaa.repast.admin.project.system.productLadder.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.repast.admin.framework.web.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 产品阶梯价格(只针对同商品)表 pms_product_ladder
 * 
 * @author Seven Lee
 * @date 2020-01-08
 */
public class ProductLadder extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/**  */
	private Long shopId;
	/**  */
	private Long productId;
	/** 满足的商品数量 */
	private Integer count;
	/** 折扣 */
	private BigDecimal discount;
	/** 折后价格 */
	private BigDecimal price;

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
	public void setCount(Integer count) 
	{
		this.count = count;
	}

	public Integer getCount() 
	{
		return count;
	}
	public void setDiscount(BigDecimal discount) 
	{
		this.discount = discount;
	}

	public BigDecimal getDiscount() 
	{
		return discount;
	}
	public void setPrice(BigDecimal price) 
	{
		this.price = price;
	}

	public BigDecimal getPrice() 
	{
		return price;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shopId", getShopId())
            .append("productId", getProductId())
            .append("count", getCount())
            .append("discount", getDiscount())
            .append("price", getPrice())
            .toString();
    }
}
