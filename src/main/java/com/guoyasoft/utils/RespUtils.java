package com.guoyasoft.utils;

import com.guoyasoft.bean.BaseResponse;
import java.util.List;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * @program: guoya-api-teach
 * @description: ${description}
 * @author: YSL
 * @create: 2019-03-09 15:21
 **/
public class RespUtils {
  public static BaseResponse getEro( BindingResult bindingResult) {
    BaseResponse resp = new BaseResponse();
    resp.setCode(41000);
    String msg = "";
    List<FieldError> fieldErrors = bindingResult.getFieldErrors();
    // bindingResult.getFieldErrors()  获取所有错的字段  List<FieldError> 对象
    // 单个对象类型  对象名 : List<对象类型>
    /*for (int i = 0; i < fieldErrors.size(); i++) {
      FieldError fieldError = fieldErrors.get(i);
      msg = msg + fieldError.getDefaultMessage() + "；";
    }*/
    for (FieldError fieldError : fieldErrors) {
      // fieldError.getDefaultMessage() 每个错误对象的 错误信息
      msg = msg + fieldError.getDefaultMessage() + "；";
    }
    resp.setMsg(msg);
    return resp;
  }
  public static BaseResponse getBase(int code,String msg,Object data){
    BaseResponse resp = new BaseResponse();
    resp.setCode(code);
    resp.setMsg(msg);
    resp.setData(data);
    return resp;
  }
}
