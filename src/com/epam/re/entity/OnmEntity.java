package com.epam.re.entity;

import java.io.Serializable;

/**
 * @author A.Tymchenko
 * @version 1.0, 21.12.2015
 */
public class OnmEntity implements Serializable {
    // Fields
    private Integer onmId;
    private Integer filiaId;
    private String address;

    // Getters & Setters
    public Integer getOnmId() {
        return onmId;
    }

    public void setOnmId(Integer onmId) {
        this.onmId = onmId;
    }

    public Integer getFiliaId() {
        return filiaId;
    }

    public void setFiliaId(Integer filiaId) {
        this.filiaId = filiaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // equals & hashCode & toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OnmEntity that = (OnmEntity) o;
        return !(onmId != null ? !onmId.equals(that.onmId) : that.onmId != null);
    }

    @Override
    public int hashCode() {
        return onmId != null ? onmId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "OnmEntity{" +
                "onmId=" + onmId +
                ", filiaId=" + filiaId +
                ", address='" + address + '\'' +
                '}';
    }

}
