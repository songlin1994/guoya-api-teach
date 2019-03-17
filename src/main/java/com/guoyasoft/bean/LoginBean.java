package com.guoyasoft.bean;

/**
 * @program: mall-test
 * @description: ${description}
 * @author: YSL
 * @create: 2019-03-02 11:14
 **/
public class LoginBean {
  String username;
  String passwd;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPasswd() {
    return passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }

  @Override
  public String toString() {
    return "LoginBean{" +
        "username='" + username + '\'' +
        ", passwd='" + passwd + '\'' +
        '}';
  }
}
