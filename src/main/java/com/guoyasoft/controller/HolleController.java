package com.guoyasoft.controller;


import com.guoyasoft.bean.BaseResponse;
import com.guoyasoft.bean.LoginBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: mall-test
 * @description: ${description}
 * @author: YSL
 * @create: 2019-03-02 10:50
 **/
@RestController
@RequestMapping("/index")
@Api(value = "HolleController", description = "练习")
public class HolleController {

  @RequestMapping(value = "holle", method = RequestMethod.GET)
  public String holle() {
    return "Holle Word";
  }

  @RequestMapping(value = "get", method = RequestMethod.GET)
  public String get(@RequestParam String name) {

    return "这是一个get----" + name;
  }

  @ApiOperation(value = "请求测试")
  @RequestMapping(value = "request", method = RequestMethod.POST)
  public BaseResponse post(@RequestBody LoginBean login, HttpServletRequest request, HttpServletResponse response) {
    String id = request.getHeader("id");
    response.setHeader("test", "XXXX");
    System.out.println(id);
    BaseResponse baseResponse = new BaseResponse();
    baseResponse.setCode(2000);
    baseResponse.setMsg("登陆成功");
    return baseResponse;
  }
}
