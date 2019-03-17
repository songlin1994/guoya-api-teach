package com.guoyasoft.service;

import com.guoyasoft.model.TProdSku;
import java.util.List;

/**
 * @program: guoya-api-teach
 * @description: ${description}
 * @author: YSL
 * @create: 2019-03-09 15:32
 **/
public interface ITProdSkuSvc {

  List<TProdSku> selectBySkuCode(String skuCode);

  List<TProdSku> selectBySkuName(String skuName);

  List<TProdSku> getAllSKU(int pageNum, int pageSize);
}
