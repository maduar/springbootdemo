package com.maduar.springbootdemo.test;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/*
 *
 * @author maduar
 * @date 04/07/2018 4:25 PM
 * @email maduar@163.com
 *
 * */
public class Playload implements Serializable{
  private String custId;
  private String email;
  private String mobile_phone;

  public Playload() {
  }

  public Playload(@NotNull String custId, @NotNull String email, @NotNull String mobile_phone) {
    this.custId = custId;
    this.email = email;
    this.mobile_phone = mobile_phone;
  }

  public String getCustId() {
    return custId;
  }

  public void setCustId(@NotNull String custId) {
    this.custId = custId;
  }

  @Override
  public String toString() {
    return "Playload{" +
            "custId='" + custId + '\'' +
            ", email='" + email + '\'' +
            ", mobile_phone='" + mobile_phone + '\'' +
            '}';
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(@NotNull String email) {
    this.email = email;
  }

  public String getMobile_phone() {
    return mobile_phone;
  }

  public void setMobile_phone(@NotNull String mobile_phone) {
    this.mobile_phone = mobile_phone;
  }
}
