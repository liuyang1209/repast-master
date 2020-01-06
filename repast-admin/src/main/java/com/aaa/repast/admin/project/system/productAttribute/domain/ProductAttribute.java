package com.aaa.repast.admin.project.system.productAttribute.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.repast.admin.framework.web.domain.BaseEntity;

/**
 * 商品属性参数表 pms_product_attribute
 * 
 * @author Seven Lee
 * @date 2020-01-02
 */
public class ProductAttribute extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/** 店铺id */
	private Long shopId;
	/** 产品属性分类id */
	private Long productAttributeCategoryId;
	/** 属性名称 */
	private String name;
	/** 属性选择类型：0->唯一；1->单选；2->多选 */
	private Integer selectType;
	/** 属性录入方式：0->手工录入；1->从列表中选取 */
	private Integer inputType;
	/** 可选值列表，以逗号隔开 */
	private String inputList;
	/** 排序字段：最高的可以单独上传图片 */
	private Integer sort;
	/** 分类筛选样式：1->普通；1->颜色 */
	private Integer filterType;
	/** 检索类型；0->不需要进行检索；1->关键字检索；2->范围检索 */
	private Integer searchType;
	/** 相同属性产品是否关联；0->不关联；1->关联 */
	private Integer relatedStatus;
	/** 是否支持手动新增；0->不支持；1->支持 */
	private Integer handAddStatus;
	/** 属性的类型；0->规格；1->参数 */
	private Integer type;

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
	public void setProductAttributeCategoryId(Long productAttributeCategoryId) 
	{
		this.productAttributeCategoryId = productAttributeCategoryId;
	}

	public Long getProductAttributeCategoryId() 
	{
		return productAttributeCategoryId;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setSelectType(Integer selectType) 
	{
		this.selectType = selectType;
	}

	public Integer getSelectType() 
	{
		return selectType;
	}
	public void setInputType(Integer inputType) 
	{
		this.inputType = inputType;
	}

	public Integer getInputType() 
	{
		return inputType;
	}
	public void setInputList(String inputList) 
	{
		this.inputList = inputList;
	}

	public String getInputList() 
	{
		return inputList;
	}
	public void setSort(Integer sort) 
	{
		this.sort = sort;
	}

	public Integer getSort() 
	{
		return sort;
	}
	public void setFilterType(Integer filterType) 
	{
		this.filterType = filterType;
	}

	public Integer getFilterType() 
	{
		return filterType;
	}
	public void setSearchType(Integer searchType) 
	{
		this.searchType = searchType;
	}

	public Integer getSearchType() 
	{
		return searchType;
	}
	public void setRelatedStatus(Integer relatedStatus) 
	{
		this.relatedStatus = relatedStatus;
	}

	public Integer getRelatedStatus() 
	{
		return relatedStatus;
	}
	public void setHandAddStatus(Integer handAddStatus) 
	{
		this.handAddStatus = handAddStatus;
	}

	public Integer getHandAddStatus() 
	{
		return handAddStatus;
	}
	public void setType(Integer type) 
	{
		this.type = type;
	}

	public Integer getType() 
	{
		return type;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shopId", getShopId())
            .append("productAttributeCategoryId", getProductAttributeCategoryId())
            .append("name", getName())
            .append("selectType", getSelectType())
            .append("inputType", getInputType())
            .append("inputList", getInputList())
            .append("sort", getSort())
            .append("filterType", getFilterType())
            .append("searchType", getSearchType())
            .append("relatedStatus", getRelatedStatus())
            .append("handAddStatus", getHandAddStatus())
            .append("type", getType())
            .toString();
    }
}
