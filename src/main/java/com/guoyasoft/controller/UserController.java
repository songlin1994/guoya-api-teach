package com.guoyasoft.controller;


import com.guoyasoft.bean.BaseResponse;
import com.guoyasoft.bean.SignUpRequest;
import com.guoyasoft.mapper.TUserUserMapper;
import com.guoyasoft.model.TUserUser;
import com.guoyasoft.service.ITUserUserSvc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: mall-test
 * @description: ${description}
 * @author: YSL
 * @create: 2019-03-02 14:11
 **/
@RestController
@RequestMapping("/user")
@Api(value = "UserController", description = "用户接口")
public class UserController {

  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private TUserUserMapper tUserUserMapper;

  @Autowired
  private ITUserUserSvc userSvc;

  @ApiOperation("注册接口")
  @RequestMapping(value = "signin", method = RequestMethod.POST)
  public BaseResponse signin(@Validated @RequestBody SignUpRequest signUpRequest, BindingResult bindingResult) {
    //@Validated 校验 bean ,BindingResult : 校验结果的对象
    String msg = "";
    BaseResponse baseResponse = new BaseResponse();
    //bindingResult.getFieldErrors(): 校验结果的错误对象List
    //fieldError: 单个错误对象
    //fieldError.getDefaultMessage(): 获取message
    for (FieldError fieldError : bindingResult.getFieldErrors()) {
      msg = msg + fieldError.getDefaultMessage() + "；";
    }

    if (msg.equals("")) {
      if (signUpRequest.getPwd().equals(signUpRequest.getRepwd())) {
        TUserUser tUserUser = new TUserUser();
        tUserUser.setIphone(signUpRequest.getPhone());
        tUserUser.setAge(signUpRequest.getAge());
        tUserUser.setPasswd(signUpRequest.getPwd());
        tUserUser.setUserName(signUpRequest.getUsername());
        List<TUserUser> tUserUsers = userSvc.selectByUserName(signUpRequest.getUsername());
        if (tUserUsers.size() > 0) {
          baseResponse.setCode(41000);
          baseResponse.setMsg("已有该用户名");
          return baseResponse;
        }
        logger.info("--------------------选择插入");
        tUserUserMapper.insertSelective(tUserUser);
        baseResponse.setCode(2000);
        baseResponse.setMsg("注册成功");
        return baseResponse;
      }
      baseResponse.setCode(4000);
      baseResponse.setMsg("密码不一致");

      return baseResponse;
    }
//    for (int i = 0; i < bindingResult.getErrorCount(); i++) {
//      FieldError fieldError = bindingResult.getFieldError();
//      System.out.println(fieldError.getDefaultMessage());
//    }
    logger.info("--------------");
    logger.info(signUpRequest.toString());

    baseResponse.setCode(4000);
    baseResponse.setMsg(msg);

    return baseResponse;
  }

}
