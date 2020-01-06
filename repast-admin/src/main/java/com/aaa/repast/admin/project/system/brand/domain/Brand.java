package com.aaa.repast.admin.project.system.brand.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.repast.admin.framework.web.domain.BaseEntity;

/**
 * 品牌表 pms_brand
 * 
 * @author Seven Lee
 * @date 2019-12-28
 */
public class Brand extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**主键id  */
	private Long id;
	/**店铺id  */
	private Long shopId;
	/** 名称 */
	private String name;
	/** 首字母 */
	private String firstLetter;
	/** 排序 */
	private Integer sort;
	/** 是否为品牌制造商：0->不是；1->是 */
	private Integer factoryStatus;
	/** 是否显示：0->不显示；1->显示 */
	private Integer showStatus;
	/** 产品数量 */
	private Integer productCount;
	/** 产品评论数量 */
	private Integer productCommentCount;
	/** 品牌logo */
	private String logo;
	/** 专区大图 */
	private String bigPic;
	/** 品牌故事 */
	private String brandStory;

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
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setFirstLetter(String firstLetter) 
	{
		this.firstLetter = firstLetter;
	}

	public String getFirstLetter() 
	{
		return firstLetter;
	}
	public void setSort(Integer sort) 
	{
		this.sort = sort;
	}

	public Integer getSort() 
	{
		return sort;
	}
	public void setFactoryStatus(Integer factoryStatus) 
	{
		this.factoryStatus = factoryStatus;
	}

	public Integer getFactoryStatus() 
	{
		return factoryStatus;
	}
	public void setShowStatus(Integer showStatus) 
	{
		this.showStatus = showStatus;
	}

	public Integer getShowStatus() 
	{
		return showStatus;
	}
	public void setProductCount(Integer productCount) 
	{
		this.productCount = productCount;
	}

	public Integer getProductCount() 
	{
		return productCount;
	}
	public void setProductCommentCount(Integer productCommentCount) 
	{
		this.productCommentCount = productCommentCount;
	}

	public Integer getProductCommentCount() 
	{
		return productCommentCount;
	}
	public void setLogo(String logo) 
	{
		this.logo = logo;
	}

	public String getLogo() 
	{
		return logo;
	}
	public void setBigPic(String bigPic) 
	{
		this.bigPic = bigPic;
	}

	public String getBigPic() 
	{
		return bigPic;
	}
	public void setBrandStory(String brandStory) 
	{
		this.brandStory = brandStory;
	}

	public String getBrandStory() 
	{
		return brandStory;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shopId", getShopId())
            .append("name", getName())
            .append("firstLetter", getFirstLetter())
            .append("sort", getSort())
            .append("factoryStatus", getFactoryStatus())
            .append("showStatus", getShowStatus())
            .append("productCount", getProductCount())
            .append("productCommentCount", getProductCommentCount())
            .append("logo", getLogo())
            .append("bigPic", getBigPic())
            .append("brandStory", getBrandStory())
            .toString();
    }
}
