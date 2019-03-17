package com.guoyasoft.utils;

/**
 * @program: guoya-virtual-mall
 * @description: ${description}
 * @author: YSL
 * @create: 2018-10-30 10:27
 **/
public class NumberUtils {
  /**
  * @Author YSL
  * @Description 是不是整数的判断
  * @Date 12:41 2018/10/30
  * @Param [obj]
  * @return boolean
  **/
  public static boolean isIntegerForDouble(double obj) {
    double eps = 1e-10;  // 精度范围  
    return obj-Math.floor(obj) < eps;
  }

}
