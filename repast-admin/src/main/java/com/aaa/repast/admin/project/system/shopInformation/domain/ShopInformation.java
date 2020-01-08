package com.aaa.repast.admin.project.system.shopInformation.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.repast.admin.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 店铺的基本表 ums_shop_information
 * 
 * @author Seven Lee
 * @date 2020-01-03
 */
public class ShopInformation extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/** 店铺所有者ID */
	private Long ownerId;
	/** 店铺名称 */
	private String name;
	/** 省 */
	private String province;
	/** 市 */
	private String city;
	/** 区 */
	private String borough;
	/** 地址 */
	private String address;
	/**  */
	private String lng;
	/**  */
	private String lat;
	/** 是否打烊（手动打烊标示）和营业时间一起使用 */
	private Integer closed;
	/** 字符串，如：1-5|10:00-14:00，1-5|17:00-22:00，6-7|9:00-24:00  周和时间用“|”分割，周几到周几用“-”分割，多个设置用“，”分割 */
	private String openTime;
	/** 商家电话 */
	private String phone;
	/** 商家实景照片URL，json格式 {realimsg:['http://xxx','http://xxx']} */
	private String images;
	/** 0：冻结状态，1：正常，2：违规关闭，3：店铺到期关闭 */
	private Integer status;
	/** 授权开始时间 */
	private Date authStartTime;
	/** 授权时长，单位是月 */
	private Integer authLong;
	/** 授权版本的ID */
	private Integer templateId;
	/** 营业执照图片链接 */
	private String businessLicense;
	/** 食品安全许可证图片链接 */
	private String foodLicense;
	/** 卫生许可证图片链接 */
	private String sanitationLicense;
	/** 量化考核图片链接 */
	private String assess;
	/** 合同ID */
	private Long contractId;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setOwnerId(Long ownerId) 
	{
		this.ownerId = ownerId;
	}

	public Long getOwnerId() 
	{
		return ownerId;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setProvince(String province) 
	{
		this.province = province;
	}

	public String getProvince() 
	{
		return province;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}

	public String getCity() 
	{
		return city;
	}
	public void setBorough(String borough) 
	{
		this.borough = borough;
	}

	public String getBorough() 
	{
		return borough;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getAddress() 
	{
		return address;
	}
	public void setLng(String lng) 
	{
		this.lng = lng;
	}

	public String getLng() 
	{
		return lng;
	}
	public void setLat(String lat) 
	{
		this.lat = lat;
	}

	public String getLat() 
	{
		return lat;
	}
	public void setClosed(Integer closed) 
	{
		this.closed = closed;
	}

	public Integer getClosed() 
	{
		return closed;
	}
	public void setOpenTime(String openTime) 
	{
		this.openTime = openTime;
	}

	public String getOpenTime() 
	{
		return openTime;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}
	public void setImages(String images) 
	{
		this.images = images;
	}

	public String getImages() 
	{
		return images;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}
	public void setAuthStartTime(Date authStartTime) 
	{
		this.authStartTime = authStartTime;
	}

	public Date getAuthStartTime() 
	{
		return authStartTime;
	}
	public void setAuthLong(Integer authLong) 
	{
		this.authLong = authLong;
	}

	public Integer getAuthLong() 
	{
		return authLong;
	}
	public void setTemplateId(Integer templateId) 
	{
		this.templateId = templateId;
	}

	public Integer getTemplateId() 
	{
		return templateId;
	}
	public void setBusinessLicense(String businessLicense) 
	{
		this.businessLicense = businessLicense;
	}

	public String getBusinessLicense() 
	{
		return businessLicense;
	}
	public void setFoodLicense(String foodLicense) 
	{
		this.foodLicense = foodLicense;
	}

	public String getFoodLicense() 
	{
		return foodLicense;
	}
	public void setSanitationLicense(String sanitationLicense) 
	{
		this.sanitationLicense = sanitationLicense;
	}

	public String getSanitationLicense() 
	{
		return sanitationLicense;
	}
	public void setAssess(String assess) 
	{
		this.assess = assess;
	}

	public String getAssess() 
	{
		return assess;
	}
	public void setContractId(Long contractId) 
	{
		this.contractId = contractId;
	}

	public Long getContractId() 
	{
		return contractId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("ownerId", getOwnerId())
            .append("name", getName())
            .append("province", getProvince())
            .append("city", getCity())
            .append("borough", getBorough())
            .append("address", getAddress())
            .append("lng", getLng())
            .append("lat", getLat())
            .append("closed", getClosed())
            .append("openTime", getOpenTime())
            .append("phone", getPhone())
            .append("images", getImages())
            .append("status", getStatus())
            .append("authStartTime", getAuthStartTime())
            .append("authLong", getAuthLong())
            .append("templateId", getTemplateId())
            .append("businessLicense", getBusinessLicense())
            .append("foodLicense", getFoodLicense())
            .append("sanitationLicense", getSanitationLicense())
            .append("assess", getAssess())
            .append("contractId", getContractId())
            .toString();
    }
}
