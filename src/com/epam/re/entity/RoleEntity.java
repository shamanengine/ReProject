package com.epam.re.entity;

import java.io.Serializable;

/**
 * @author A.Tymchenko
 * @version 1.0, 21.12.2015
 */
public class RoleEntity implements Serializable {
    // Fields
    private Integer roleId;
    private String title;

    // Getters & Setters
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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

        RoleEntity that = (RoleEntity) o;

        return !(roleId != null ? !roleId.equals(that.roleId) : that.roleId != null);
    }

    @Override
    public int hashCode() {
        return roleId != null ? roleId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "roleId=" + roleId +
                ", title='" + title + '\'' +
                '}';
    }

}
