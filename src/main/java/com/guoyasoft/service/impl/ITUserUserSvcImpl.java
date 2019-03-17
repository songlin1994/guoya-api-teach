package com.guoyasoft.service.impl;

import com.guoyasoft.mapper.TUserUserMapper;
import com.guoyasoft.model.TUserUser;
import com.guoyasoft.model.TUserUserExample;
import com.guoyasoft.model.TUserUserExample.Criteria;
import com.guoyasoft.service.ITUserUserSvc;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: guoya-api-teach
 * @description: ${description}
 * @author: YSL
 * @create: 2019-03-09 13:49
 **/
@Service
public class ITUserUserSvcImpl implements ITUserUserSvc {

  @Autowired
  private TUserUserMapper userMapper;

  @Override
  public List<TUserUser> selectByUserName(String userName) {
    TUserUserExample tUserUserExample = new TUserUserExample();
    Criteria criteria = tUserUserExample.createCriteria();
    criteria.andUserNameEqualTo(userName);
    List<TUserUser> tUserUsers = userMapper.selectByExample(tUserUserExample);
    return tUserUsers;
  }
}
