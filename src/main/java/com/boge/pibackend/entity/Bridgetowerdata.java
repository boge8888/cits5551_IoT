package com.boge.pibackend.entity;

import java.io.Serializable;

public class Bridgetowerdata implements Serializable {
    private Long id;

    private String time;

    private Double temperature;

    private Double humidity;

    private Double air_pressure;

    private Double tilter_aline;

    private Double tilter_vertical;

    private Integer risk_level;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
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

    public Double getAir_pressure() {
        return air_pressure;
    }

    public void setAir_pressure(Double air_pressure) {
        this.air_pressure = air_pressure;
    }

    public Double getTilter_aline() {
        return tilter_aline;
    }

    public void setTilter_aline(Double tilter_aline) {
        this.tilter_aline = tilter_aline;
    }

    public Double getTilter_vertical() {
        return tilter_vertical;
    }

    public void setTilter_vertical(Double tilter_vertical) {
        this.tilter_vertical = tilter_vertical;
    }

    public Integer getRisk_level() {
        return risk_level;
    }

    public void setRisk_level(Integer risk_level) {
        this.risk_level = risk_level;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", time=").append(time);
        sb.append(", temperature=").append(temperature);
        sb.append(", humidity=").append(humidity);
        sb.append(", air_pressure=").append(air_pressure);
        sb.append(", tilter_aline=").append(tilter_aline);
        sb.append(", tilter_vertical=").append(tilter_vertical);
        sb.append(", risk_level=").append(risk_level);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}