package com.epam.re.entity;

import java.io.Serializable;

/**
 * @author Raccoon
 * @version 1.0, 21.12.2015.
 */

/**
 * Entity class for user representation
 */

public class UserEntity implements Serializable {
    // Fields
    private Integer userId;
    private Integer roleId;
    private Boolean active;
    private Integer filiaId;
    private String  username;
    private String  password;
    private String  email;

    // Getters & Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getFiliaId() {
        return filiaId;
    }

    public void setFiliaId(Integer filiaId) {
        this.filiaId = filiaId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // equals & hashCode & toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;
        return !(userId != null ? !userId.equals(that.userId) : that.userId != null);
    }

    @Override
    public int hashCode() {
        return userId != null ? userId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                ", active=" + active +
                ", filiaId=" + filiaId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
