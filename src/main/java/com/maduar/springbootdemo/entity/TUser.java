package com.maduar.springbootdemo.entity;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user", schema = "test", catalog = "")
public class TUser {

    private int tId;
    private String tName;
    private Integer tAge;
    private String tAddress;

    @Id
    @Column(name = "t_id", nullable = false)
    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    @Basic
    @Column(name = "t_name", nullable = true, length = 30)
    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    @Basic
    @Column(name = "t_age", nullable = true)
    public Integer gettAge() {
        return tAge;
    }

    public void settAge(Integer tAge) {
        this.tAge = tAge;
    }

    @Basic
    @Column(name = "t_address", nullable = true, length = 100)
    public String gettAddress() {
        return tAddress;
    }

    public void settAddress(String tAddress) {
        this.tAddress = tAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TUser tUser = (TUser) o;
        return tId == tUser.tId &&
            Objects.equals(tName, tUser.tName) &&
            Objects.equals(tAge, tUser.tAge) &&
            Objects.equals(tAddress, tUser.tAddress);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tId, tName, tAge, tAddress);
    }
}
