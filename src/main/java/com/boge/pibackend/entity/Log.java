package com.boge.pibackend.entity;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {
    private Long id;

    private Long bridge_id;

    private Long device_id;

    private Integer degree;

    private Integer parameter;

    private Date date;

    private String timestamp;

    private String reserved;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBridge_id() {
        return bridge_id;
    }

    public void setBridge_id(Long bridge_id) {
        this.bridge_id = bridge_id;
    }

    public Long getDevice_id() {
        return device_id;
    }

    public void setDevice_id(Long device_id) {
        this.device_id = device_id;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public Integer getParameter() {
        return parameter;
    }

    public void setParameter(Integer parameter) {
        this.parameter = parameter;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp == null ? null : timestamp.trim();
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
        sb.append(", bridge_id=").append(bridge_id);
        sb.append(", device_id=").append(device_id);
        sb.append(", degree=").append(degree);
        sb.append(", parameter=").append(parameter);
        sb.append(", date=").append(date);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", reserved=").append(reserved);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}