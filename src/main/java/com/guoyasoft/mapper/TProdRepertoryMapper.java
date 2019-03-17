package com.guoyasoft.mapper;

import com.guoyasoft.model.TProdRepertory;
import com.guoyasoft.model.TProdRepertoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TProdRepertoryMapper {
    int countByExample(TProdRepertoryExample example);

    int deleteByExample(TProdRepertoryExample example);

    int deleteByPrimaryKey(Integer repertoryId);

    int insert(TProdRepertory record);

    int insertSelective(TProdRepertory record);

    List<TProdRepertory> selectByExample(TProdRepertoryExample example);

    TProdRepertory selectByPrimaryKey(Integer repertoryId);

    int updateByExampleSelective(@Param("record") TProdRepertory record, @Param("example") TProdRepertoryExample example);

    int updateByExample(@Param("record") TProdRepertory record, @Param("example") TProdRepertoryExample example);

    int updateByPrimaryKeySelective(TProdRepertory record);

    int updateByPrimaryKey(TProdRepertory record);
}