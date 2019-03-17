package com.guoyasoft.bean;

import io.swagger.annotations.ApiModel;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @program: guoya-api-teach
 * @description: ${description}
 * @author: YSL
 * @create: 2019-03-09 15:01
 **/
@ApiModel(value = "添加商品")
public class AddSkuReq {

  @NotNull(message = "商品编码不能为空")
  private String skuCode;

  @NotNull(message = "商品名称不能为空")
  private String skuName;

  @Min(10)
  private Integer skuPrice;

  @NotNull(message = "颜色不能为空")
  private String color;

  @NotNull(message = "尺码不能为空")
  private String size;

  @Min(1)
  private Integer qty;

  public String getSkuCode() {
    return skuCode;
  }

  public void setSkuCode(String skuCode) {
    this.skuCode = skuCode;
  }

  public String getSkuName() {
    return skuName;
  }

  public void setSkuName(String skuName) {
    this.skuName = skuName;
  }

  public Integer getSkuPrice() {
    return skuPrice;
  }

  public void setSkuPrice(Integer skuPrice) {
    this.skuPrice = skuPrice;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public Integer getQty() {
    return qty;
  }

  public void setQty(Integer qty) {
    this.qty = qty;
  }
}
