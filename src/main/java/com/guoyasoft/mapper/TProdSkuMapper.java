package com.guoyasoft.mapper;

import com.guoyasoft.model.TProdSku;
import com.guoyasoft.model.TProdSkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository  //表示 这个类是 访问数据库的
public interface TProdSkuMapper {

  int countByExample(TProdSkuExample example);

  int deleteByExample(TProdSkuExample example);

  int deleteByPrimaryKey(Integer skuId);

  int insert(TProdSku record);

  int insertSelective(TProdSku record);

  List<TProdSku> selectByExample(TProdSkuExample example);

  TProdSku selectByPrimaryKey(Integer skuId);

  int updateByExampleSelective(@Param("record") TProdSku record, @Param("example") TProdSkuExample example);

  int updateByExample(@Param("record") TProdSku record, @Param("example") TProdSkuExample example);

  int updateByPrimaryKeySelective(TProdSku record);

  int updateByPrimaryKey(TProdSku record);

  List<TProdSku> selectAllSku();
}
