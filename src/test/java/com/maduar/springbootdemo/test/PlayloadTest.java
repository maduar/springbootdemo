package com.maduar.springbootdemo.test;

/*
 *
 * @author maduar
 * @date 02/07/2018 2:27 PM
 * @email maduar@163.com
 *
 * */
public class PlayloadTest {

  private String sub;
  private String name;
  private boolean admin;

  public PlayloadTest() {
    this.sub = "1234567890";
    this.name = "John Doe";
    this.admin = true;
  }

  public String getSub() {
    return sub;
  }

  public void setSub(String sub) {
    this.sub = sub;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isAdmin() {
    return admin;
  }

  public void setAdmin(boolean admin) {
    this.admin = admin;
  }
}
