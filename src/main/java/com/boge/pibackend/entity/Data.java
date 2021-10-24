package com.boge.pibackend.entity;

import java.io.Serializable;

public class Data implements Serializable {
    private Long id;

    private Double temperature;

    private Double humidity;

    private Double pressure;

    private String time;

    private Double acc_x;

    private Double acc_y;

    private Double acc_z;

    private Double gyr_x;

    private Double gyr_y;

    private Double gyr_z;

    private Double mag_x;

    private Double mag_y;

    private Double mag_z;

    private Double reserved;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Double getAcc_x() {
        return acc_x;
    }

    public void setAcc_x(Double acc_x) {
        this.acc_x = acc_x;
    }

    public Double getAcc_y() {
        return acc_y;
    }

    public void setAcc_y(Double acc_y) {
        this.acc_y = acc_y;
    }

    public Double getAcc_z() {
        return acc_z;
    }

    public void setAcc_z(Double acc_z) {
        this.acc_z = acc_z;
    }

    public Double getGyr_x() {
        return gyr_x;
    }

    public void setGyr_x(Double gyr_x) {
        this.gyr_x = gyr_x;
    }

    public Double getGyr_y() {
        return gyr_y;
    }

    public void setGyr_y(Double gyr_y) {
        this.gyr_y = gyr_y;
    }

    public Double getGyr_z() {
        return gyr_z;
    }

    public void setGyr_z(Double gyr_z) {
        this.gyr_z = gyr_z;
    }

    public Double getMag_x() {
        return mag_x;
    }

    public void setMag_x(Double mag_x) {
        this.mag_x = mag_x;
    }

    public Double getMag_y() {
        return mag_y;
    }

    public void setMag_y(Double mag_y) {
        this.mag_y = mag_y;
    }

    public Double getMag_z() {
        return mag_z;
    }

    public void setMag_z(Double mag_z) {
        this.mag_z = mag_z;
    }

    public Double getReserved() {
        return reserved;
    }

    public void setReserved(Double reserved) {
        this.reserved = reserved;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", temperature=").append(temperature);
        sb.append(", humidity=").append(humidity);
        sb.append(", pressure=").append(pressure);
        sb.append(", time=").append(time);
        sb.append(", acc_x=").append(acc_x);
        sb.append(", acc_y=").append(acc_y);
        sb.append(", acc_z=").append(acc_z);
        sb.append(", gyr_x=").append(gyr_x);
        sb.append(", gyr_y=").append(gyr_y);
        sb.append(", gyr_z=").append(gyr_z);
        sb.append(", mag_x=").append(mag_x);
        sb.append(", mag_y=").append(mag_y);
        sb.append(", mag_z=").append(mag_z);
        sb.append(", reserved=").append(reserved);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}