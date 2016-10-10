package com.epam.re.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author A.Tymchenko
 * @version 1.0, 21.12.2015
 */
public class RentEntity implements Serializable {
    // Fields
    private Integer     rentId;
    private Integer     userId;
    private Integer     onmId;
    private String      contractor;
    private BigDecimal  square;
    private BigDecimal  rent;
    private Date        startD;
    private Date        endD;

    // Getters & Setters
    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOnmId() {
        return onmId;
    }

    public void setOnmId(Integer onmId) {
        this.onmId = onmId;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public BigDecimal getSquare() {
        return square;
    }

    public void setSquare(BigDecimal square) {
        this.square = square;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    public Date getStartD() {
        return startD;
    }

    public void setStartD(Date startD) {
        this.startD = startD;
    }

    public Date getEndD() {
        return endD;
    }

    public void setEndD(Date endD) {
        this.endD = endD;
    }

    // equals & hashCode & toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RentEntity that = (RentEntity) o;

        return !(rentId != null ? !rentId.equals(that.rentId) : that.rentId != null);
    }

    @Override
    public int hashCode() {
        return rentId != null ? rentId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "RentEntity{" +
                "rentId=" + rentId +
                ", userId=" + userId +
                ", onmId=" + onmId +
                ", contractor='" + contractor + '\'' +
                ", square=" + square +
                ", rent=" + rent +
                ", startD=" + startD +
                ", endD=" + endD +
                '}';
    }
}
