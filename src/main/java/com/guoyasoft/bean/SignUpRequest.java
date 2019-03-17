package com.guoyasoft.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @program: mall-test
 * @description: ${description}
 * @author: YSL
 * @create: 2019-03-02 14:09
 **/
@ApiModel(value = "注册实体",description = "注册bean")
public class SignUpRequest {

  @NotNull(message = "用户名为空") //非空校验 message 错误提示
//  @Pattern(regexp = "^[a-zA-Z0-9] {6,12}$",message = "请输入正确的姓名")  //正则校验 只适用于string类型  regexp: 要匹配的正则
  @ApiModelProperty(value = "用户名",required = true)  //swagger的 参数注释 , required: 是否必填
  String username;

  @NotNull(message = "用户名为空")
  @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号码格式错误")
  @ApiModelProperty(value = "手机号",required = true)
  String phone;

  @NotNull(message = "用户名为空")
  @ApiModelProperty(value = "密码",required = true)
  String pwd;

  @NotNull(message = "用户名为空")
  @ApiModelProperty(value = "重复密码",required = true)
  String repwd;

  @Min(value = 10,message = "年龄应该大于10")   //该参数的最小值
  @Max(value = 90,message = "年龄应该小于90")   //该参数的最大值
  @ApiModelProperty(value = "年龄",required = true)
  int age;

  @Override
  public String toString() {
    return "SignUpRequest{" +
        "username='" + username + '\'' +
        ", phone='" + phone + '\'' +
        ", pwd='" + pwd + '\'' +
        ", repwd='" + repwd + '\'' +
        ", age=" + age +
        '}';
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public String getRepwd() {
    return repwd;
  }

  public void setRepwd(String repwd) {
    this.repwd = repwd;
  }
}
