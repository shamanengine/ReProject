package com.epam.re.dto;

import java.io.Serializable;

/**
 * @author A.Tymchenko
 * @version 1.0, 23.12.2015
 */

/**
 * Class representing view of all user in the system (for admin)
 */
public class AllUsersView implements Serializable {
    // Fields
    private Integer userId;
    private String  role;
    private Boolean active;
    private String  filia;
    private String  username;
    // private String  password;
    private String  email;

    // Getters & Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getFilia() {
        return filia;
    }

    public void setFilia(String filia) {
        this.filia = filia;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

        AllUsersView that = (AllUsersView) o;
        return !(userId != null ? !userId.equals(that.userId) : that.userId != null);
    }

    @Override
    public int hashCode() {
        return userId != null ? userId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AllUsersView{" +
                "userId=" + userId +
                ", role='" + role + '\'' +
                ", active=" + active +
                ", filia='" + filia + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
