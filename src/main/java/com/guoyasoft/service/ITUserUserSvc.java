package com.guoyasoft.service;

import com.guoyasoft.model.TUserUser;
import java.util.List;

/**
 * @program: guoya-api-teach
 * @description: ${description}
 * @author: YSL
 * @create: 2019-03-09 13:48
 **/
public interface ITUserUserSvc {

  List<TUserUser> selectByUserName (String userName);

}
