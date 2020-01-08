package com.aaa.repast.admin.project.system.advertisePosition.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.repast.admin.framework.web.domain.BaseEntity;

/**
 * 广告位位置表 sms_advertise_position
 * 
 * @author Seven Lee
 * @date 2020-01-03
 */
public class AdvertisePosition extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/** 业务类型，餐饮小程序0 */
	private Integer type;
	/** 广告位置名称 */
	private String name;
	/** 广告位置描述 */
	private String descrition;
	/** 该位置最多几个广告 */
	private Integer maxCount;
	/**
	 * 逻辑删除
	 */
	private Integer delStatus;
	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setType(Integer type) 
	{
		this.type = type;
	}

	public Integer getType() 
	{
		return type;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setDescrition(String descrition) 
	{
		this.descrition = descrition;
	}

	public String getDescrition() 
	{
		return descrition;
	}
	public void setMaxCount(Integer maxCount) 
	{
		this.maxCount = maxCount;
	}

	public Integer getMaxCount() 
	{
		return maxCount;
	}

	public Integer getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(Integer delStatus) {
		this.delStatus = delStatus;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("name", getName())
            .append("descrition", getDescrition())
            .append("maxCount", getMaxCount())
            .append("delStatus", getDelStatus())
            .toString();
    }
}
