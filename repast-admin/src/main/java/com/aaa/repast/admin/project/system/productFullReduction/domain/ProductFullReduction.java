package com.aaa.repast.admin.project.system.productFullReduction.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.repast.admin.framework.web.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 产品满减(只针对同商品)表 pms_product_full_reduction
 * 
 * @author Seven Lee
 * @date 2020-01-08
 */
public class ProductFullReduction extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/**  */
	private Long shopId;
	/**  */
	private Long productId;
	/**  */
	private BigDecimal fullPrice;
	/**  */
	private BigDecimal reducePrice;

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
	public void setFullPrice(BigDecimal fullPrice) 
	{
		this.fullPrice = fullPrice;
	}

	public BigDecimal getFullPrice() 
	{
		return fullPrice;
	}
	public void setReducePrice(BigDecimal reducePrice) 
	{
		this.reducePrice = reducePrice;
	}

	public BigDecimal getReducePrice() 
	{
		return reducePrice;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shopId", getShopId())
            .append("productId", getProductId())
            .append("fullPrice", getFullPrice())
            .append("reducePrice", getReducePrice())
            .toString();
    }
}
