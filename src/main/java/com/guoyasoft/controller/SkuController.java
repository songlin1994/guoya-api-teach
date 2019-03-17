package com.guoyasoft.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guoyasoft.bean.AddSkuReq;
import com.guoyasoft.mapper.TProdRepertoryMapper;
import com.guoyasoft.mapper.TProdSkuMapper;
import com.guoyasoft.model.TProdRepertory;
import com.guoyasoft.model.TProdSku;
import com.guoyasoft.service.ITProdRepertorySvc;
import com.guoyasoft.service.ITProdSkuSvc;
import com.guoyasoft.utils.RespUtils;
import io.swagger.annotations.Api;
import java.util.List;
import javax.validation.constraints.Min;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: guoya-api-teach
 * @description: ${description}
 * @author: YSL
 * @create: 2019-03-09 15:03
 **/
@Validated
@RestController // 把这个类 变成 接口类 restfull
@RequestMapping("/sku")  // 给接口路径 加统一的前缀  /sku/addsku   /sku/getSku  可以用于类 和 方法
@Api(value = "SkuController",description = "商品接口")  //swagger 对 类 的 接口注解
public class SkuController {

  private static final Logger logger = LoggerFactory.getLogger(SkuController.class);


  @Autowired  // 自动注入 (相当于新建对象)
  private TProdSkuMapper skuMapper;

  @Autowired
  private TProdRepertoryMapper repertoryMapper;

  @Autowired  // 自动注入  注入服务
  private ITProdSkuSvc skuSvc;

  @Autowired
  private ITProdRepertorySvc repertorySvc;

  @RequestMapping(value = "addSku",method = RequestMethod.POST)  //springMVC的注解  给方法映射访问路径 value:接口的路径  method:声明 这个接口的请求方法
  public Object addSku(@Validated @RequestBody AddSkuReq addSkuReq, BindingResult bindingResult){

  //  @Validated : 校验 后面的实体bean 是否满足Validated的规则 (如果不加注解 不启用 校验规则)
    // @RequestBody : 声明 参数在 body, 后面的 AddSkuReq addSkuReq  表示 将参数 放到 addSkuReq里面
    //  BindingResult : 将 Validated 校验的 结果 放入 bindingResult 对象
    // bindingResult.getErrorCount() : 返回错误数
    if (bindingResult.getErrorCount()>0){
      // 如果错误数大于0 ,直接返回 错误结果
      return RespUtils.getEro(bindingResult);
    }

    // 调用 服务层  selectBySkuCode 方法 返回 商品List
    List<TProdSku> tProdSkus = skuSvc.selectBySkuCode(addSkuReq.getSkuCode());

    // 判断 查询出的商品编码 是否存在 , 存在直接返回
    if (tProdSkus.size()>0){
      return RespUtils.getBase(41000,"已有这个商品编码",null);
    }
    // 新建 TProdSku , TProdRepertory 的数据库实体bean
    TProdSku tProdSku = new TProdSku();
    TProdRepertory tProdRepertory = new TProdRepertory();

    //从addSkuReq中复制相同字段名 的值 到 目标bean里面(tProdSku/tProdRepertory)
    BeanUtils.copyProperties(addSkuReq,tProdSku);
    BeanUtils.copyProperties(addSkuReq,tProdRepertory);
    logger.info("---------------------------插入之前商品ID为: "+ tProdSku.getSkuId());
    // 插入数据库
    skuMapper.insertSelective(tProdSku);
    // 要实现ID 反向赋值 需要配置 mapper.xml : keyColumn="sku_id" keyProperty="skuId" useGeneratedKeys="true"
    logger.info("---------------------------插入商品ID为: "+ tProdSku.getSkuId());
    repertoryMapper.insertSelective(tProdRepertory);
    return RespUtils.getBase(20000,"添加成功;插入商品ID为:"+tProdSku.getSkuId(),null);
  }

  @RequestMapping(value = "updateSku",method = RequestMethod.POST)  //springMVC的注解  给方法映射访问路径 value:接口的路径  method:声明 这个接口的请求方法
  public Object updateSku(@Validated @RequestBody AddSkuReq addSkuReq, BindingResult bindingResult){
    if (bindingResult.getErrorCount()>0){
      // 如果错误数大于0 ,直接返回 错误结果
      return RespUtils.getEro(bindingResult);
    }

    // 调用 服务层  selectBySkuCode 方法 返回 商品List
    List<TProdSku> tProdSkus = skuSvc.selectBySkuCode(addSkuReq.getSkuCode());

    // 判断 查询出的商品编码 是否存在 , 存在直接返回
    if (tProdSkus.size()>0){
      TProdSku tProdSku = new TProdSku();
      BeanUtils.copyProperties(addSkuReq,tProdSku);
      skuSvc.updateBySkuCode(tProdSku);
      return RespUtils.getBase(20000,"更新成功",null);
    }
    return RespUtils.getBase(41000,"商品不存在",null);
  }

  @RequestMapping(value = "delSku",method = RequestMethod.POST)  //springMVC的注解  给方法映射访问路径 value:接口的路径  method:声明 这个接口的请求方法
  public Object delSku(@RequestParam String skuCode){
    List<TProdSku> tProdSkus = skuSvc.selectBySkuCode(skuCode);
    if (tProdSkus.size()>0){
      skuSvc.delBySkuCode(skuCode);
      return RespUtils.getBase(20000,"删除成功/'/",null);
    }
    return RespUtils.getBase(41000,"商品不存在",null);
  }

  @RequestMapping(value = "getSku/{pageNum}/{pageSize}",method = RequestMethod.GET)
  // {pageNum}/{pageSize} 与  @PathVariable("pageNum") @PathVariable("pageSize") 相互绑定,赋值给 int pageNum  int pageSize
  public Object getAllSKU(@PathVariable("pageNum") @Min(value = 1, message = "pageNum必须是大于等于1的整数") int pageNum, @PathVariable("pageSize")
  @Min(value = 1, message = "pageSize必须是大于等于1的整数") int pageSize) {

    // 启用分页查询,传入 num,size, 获得一个page 对象
    Page page = PageHelper.startPage(pageNum,pageSize);
    //执行查询
    List<TProdSku> tProdSkus = skuMapper.selectAllSku();
    // 放入page 对象 ,获取此次查询的 其他信息(pageInfo)
    PageInfo pageInfo = new PageInfo<>(page);
    //获取 查询总数据量
    long total = pageInfo.getTotal();

    return RespUtils.getBase(20000,"查询成功:"+total+"条;",tProdSkus);
  }

}
