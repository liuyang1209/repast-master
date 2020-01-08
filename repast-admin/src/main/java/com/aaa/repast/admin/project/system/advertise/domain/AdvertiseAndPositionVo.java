package com.aaa.repast.admin.project.system.advertise.domain;

import java.util.Date;

public class AdvertiseAndPositionVo {
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;
    /**  */
    private Long shopId;
    /**店铺名称*/
    private String shopName;
    /**  */
    private String name;
    /** 轮播位置 */
    private Long positionId;
    /**广告位置名称*/
    private String positionName;
    /**  */
    private String pic;
    /**  */
    private Date startTime;
    /**  */
    private Date endTime;
    /** 上下线状态：0->下线；1->上线 */
    private Integer status;
    /** 点击数 */
    private Integer clickCount;
    /** 下单数 */
    private Integer orderCount;
    /** 链接地址 */
    private String url;
    /** 备注 */
    private String note;
    /** 排序 */
    private Integer sort;
    /**
     * 逻辑删除
     */
    private Integer delStatus;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    @Override
    public String toString() {
        return "AdvertiseAndPositionVo{" +
                "id=" + id +
                ", shopId=" + shopId +
                ", shopName='" + shopName + '\'' +
                ", name='" + name + '\'' +
                ", positionId=" + positionId +
                ", positionName='" + positionName + '\'' +
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
    }
}
