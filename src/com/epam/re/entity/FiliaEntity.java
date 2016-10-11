package com.epam.re.entity;

import java.io.Serializable;

/**
 * @author A.Tymchenko
 * @version 1.0, 21.12.2015
 */

/**
 * Entity class for Filia representation
 * Filia - region where Onm (real estate object) is registered
 */
public class FiliaEntity implements Serializable {
    // Fields
    private Integer filiaId;
    private String title;

    // Getters & Setters
    public Integer getFiliaId() {
        return filiaId;
    }

    public void setFiliaId(Integer filiaId) {
        this.filiaId = filiaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // equals & hashCode & toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FiliaEntity that = (FiliaEntity) o;

        return !(filiaId != null ? !filiaId.equals(that.filiaId) : that.filiaId != null);
    }

    @Override
    public int hashCode() {
        return filiaId != null ? filiaId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "FiliaEntity{" +
                "filiaId=" + filiaId +
                ", title='" + title + '\'' +
                '}';
    }

}
