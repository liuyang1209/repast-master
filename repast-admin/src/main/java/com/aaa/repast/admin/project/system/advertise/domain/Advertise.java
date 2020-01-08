package com.aaa.repast.admin.project.system.advertise.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.repast.admin.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 广告位表 sms_advertise
 *
 * @author Seven Lee
 * @date 2020-01-03
 */
public class Advertise extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Long id;
    /**
     *
     */
    private Long shopId;
    /**
     *
     */
    private String name;
    /**
     * 轮播位置
     */
    private Long positionId;
    /**
     *
     */
    private String pic;

    /**
     *
     */
    private Date startTime;
    /**
     *
     */
    private Date endTime;
    /**
     * 上下线状态：0->下线；1->上线
     */
    private Integer status;
    /**
     * 点击数
     */
    private Integer clickCount;
    /**
     * 下单数
     */
    private Integer orderCount;
    /**
     * 链接地址
     */
    private String url;
    /**
     * 备注
     */
    private String note;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 逻辑删除
     */
    private Integer delStatus;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSort() {
        return sort;
    }

    public Integer getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

/*    @Override
    public String toString() {
        return "Advertise{" +
                "id=" + id +
                ", shopId=" + shopId +
                ", name='" + name + '\'' +
                ", positionId=" + positionId +
                ", pic='" + pic + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                ", clickCount=" + clickCount +
                ", orderCount=" + orderCount +
                ", url='" + url + '\'' +
                ", note='" + note + '\'' +
                ", sort=" + sort +
                ", delStatus=" + delStatus +
                '}';
    }*/

		public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("shopId", getShopId())
                .append("name", getName())
                .append("positionId", getPositionId())
                .append("pic", getPic())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("status", getStatus())
                .append("clickCount", getClickCount())
                .append("orderCount", getOrderCount())
                .append("url", getUrl())
                .append("note", getNote())
                .append("sort", getSort())
                .append("delStatus", getDelStatus())
                .toString();
    }
}
