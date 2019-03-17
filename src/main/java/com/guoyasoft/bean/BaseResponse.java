package com.guoyasoft.bean;

/**
 * @program: mall-test
 * @description: ${description}
 * @author: YSL
 * @create: 2019-03-02 11:22
 **/
public class BaseResponse {
  int code;
  String msg;
  Object data;

  @Override
  public String toString() {
    return "BaseResponse{" +
        "code=" + code +
        ", msg='" + msg + '\'' +
        ", data=" + data +
        '}';
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
