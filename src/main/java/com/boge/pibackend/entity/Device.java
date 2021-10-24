package com.boge.pibackend.entity;

import java.io.Serializable;
import java.util.Date;

public class Device implements Serializable {
    private Long id;

    private String type;

    private Date date;

    private String location;

    private Long bridge_id;

    private String bridge;

    private Long user_id;

    private Integer status;

    private String reserved;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Long getBridge_id() {
        return bridge_id;
    }

    public void setBridge_id(Long bridge_id) {
        this.bridge_id = bridge_id;
    }

    public String getBridge() {
        return bridge;
    }

    public void setBridge(String bridge) {
        this.bridge = bridge == null ? null : bridge.trim();
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved == null ? null : reserved.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", date=").append(date);
        sb.append(", location=").append(location);
        sb.append(", bridge_id=").append(bridge_id);
        sb.append(", bridge=").append(bridge);
        sb.append(", user_id=").append(user_id);
        sb.append(", status=").append(status);
        sb.append(", reserved=").append(reserved);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}