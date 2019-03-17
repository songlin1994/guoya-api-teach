package com.guoyasoft.mapper;

import com.guoyasoft.model.TUserUser;
import com.guoyasoft.model.TUserUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TUserUserMapper {
    int countByExample(TUserUserExample example);

    int deleteByExample(TUserUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(TUserUser record);

    int insertSelective(TUserUser record);

    List<TUserUser> selectByExample(TUserUserExample example);

    TUserUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") TUserUser record, @Param("example") TUserUserExample example);

    int updateByExample(@Param("record") TUserUser record, @Param("example") TUserUserExample example);

    int updateByPrimaryKeySelective(TUserUser record);

    int updateByPrimaryKey(TUserUser record);
}
