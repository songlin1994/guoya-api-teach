package com.guoyasoft.service.impl;

import com.guoyasoft.mapper.TProdSkuMapper;
import com.guoyasoft.model.TProdSku;
import com.guoyasoft.model.TProdSkuExample;
import com.guoyasoft.model.TProdSkuExample.Criteria;
import com.guoyasoft.service.ITProdSkuSvc;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: guoya-api-teach
 * @description: ${description}
 * @author: YSL
 * @create: 2019-03-09 15:33
 **/
@Service  // 表示这个 是 服务层 的类
public class ITProdSkuSvcImpl implements ITProdSkuSvc {

  @Autowired
  private TProdSkuMapper skuMapper;

  // 实现 查询方法
  @Override
  public List<TProdSku> selectBySkuCode(String skuCode) {
    //新建 TProdSkuExample
    TProdSkuExample tProdSkuExample = new TProdSkuExample();
    // 生成 criteria
    Criteria criteria = tProdSkuExample.createCriteria();
    // 加条件: where sku_code = skuCode (String skuCode)
    criteria.andSkuCodeEqualTo(skuCode);

    // 执行 设置好的 TProdSkuExample ,获取 查询结果
    List<TProdSku> tProdSkus = skuMapper.selectByExample(tProdSkuExample);

    return tProdSkus;
  }

  @Override
  public List<TProdSku> selectBySkuName(String skuName) {
    return null;
  }

  @Override
  public List<TProdSku> getAllSKU(int pageNum, int pageSize) {
    return  skuMapper.selectAllSku();
  }
}
