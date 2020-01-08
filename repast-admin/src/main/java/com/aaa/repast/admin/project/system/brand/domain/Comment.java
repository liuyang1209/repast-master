package com.aaa.repast.admin.project.system.brand.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.repast.admin.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 商品评价表 pms_comment
 * 
 * @author Seven Lee
 * @date 2019-12-30
 */
public class Comment extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/**  */
	private Long shopId;
	/** 订单ID */
	private Long orderId;
	/** 订单为单一商品时，该字段有值 */
	private Long productId;
	/**  */
	private String memberNickName;
	/**  */
	private String productName;
	/** 评价星数：0->5 */
	private Integer star;
	/** 评价的ip */
	private String memberIp;
	/**  */
	private Date createTime;
	/**  */
	private Integer showStatus;
	/** 购买时的商品属性 */
	private String productAttribute;
	/**  */
	private Integer collectCouont;
	/**  */
	private Integer readCount;
	/**  */
	private String content;
	/** 上传图片地址，以逗号隔开 */
	private String pics;
	/** 评论用户头像 */
	private String memberIcon;
	/**  */
	private Integer replayCount;

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
	public void setOrderId(Long orderId) 
	{
		this.orderId = orderId;
	}

	public Long getOrderId() 
	{
		return orderId;
	}
	public void setProductId(Long productId) 
	{
		this.productId = productId;
	}

	public Long getProductId() 
	{
		return productId;
	}
	public void setMemberNickName(String memberNickName) 
	{
		this.memberNickName = memberNickName;
	}

	public String getMemberNickName() 
	{
		return memberNickName;
	}
	public void setProductName(String productName) 
	{
		this.productName = productName;
	}

	public String getProductName() 
	{
		return productName;
	}
	public void setStar(Integer star) 
	{
		this.star = star;
	}

	public Integer getStar() 
	{
		return star;
	}
	public void setMemberIp(String memberIp) 
	{
		this.memberIp = memberIp;
	}

	public String getMemberIp() 
	{
		return memberIp;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setShowStatus(Integer showStatus) 
	{
		this.showStatus = showStatus;
	}

	public Integer getShowStatus() 
	{
		return showStatus;
	}
	public void setProductAttribute(String productAttribute) 
	{
		this.productAttribute = productAttribute;
	}

	public String getProductAttribute() 
	{
		return productAttribute;
	}
	public void setCollectCouont(Integer collectCouont) 
	{
		this.collectCouont = collectCouont;
	}

	public Integer getCollectCouont() 
	{
		return collectCouont;
	}
	public void setReadCount(Integer readCount) 
	{
		this.readCount = readCount;
	}

	public Integer getReadCount() 
	{
		return readCount;
	}
	public void setContent(String content) 
	{
		this.content = content;
	}

	public String getContent() 
	{
		return content;
	}
	public void setPics(String pics) 
	{
		this.pics = pics;
	}

	public String getPics() 
	{
		return pics;
	}
	public void setMemberIcon(String memberIcon) 
	{
		this.memberIcon = memberIcon;
	}

	public String getMemberIcon() 
	{
		return memberIcon;
	}
	public void setReplayCount(Integer replayCount) 
	{
		this.replayCount = replayCount;
	}

	public Integer getReplayCount() 
	{
		return replayCount;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shopId", getShopId())
            .append("orderId", getOrderId())
            .append("productId", getProductId())
            .append("memberNickName", getMemberNickName())
            .append("productName", getProductName())
            .append("star", getStar())
            .append("memberIp", getMemberIp())
            .append("createTime", getCreateTime())
            .append("showStatus", getShowStatus())
            .append("productAttribute", getProductAttribute())
            .append("collectCouont", getCollectCouont())
            .append("readCount", getReadCount())
            .append("content", getContent())
            .append("pics", getPics())
            .append("memberIcon", getMemberIcon())
            .append("replayCount", getReplayCount())
            .toString();
    }
}
