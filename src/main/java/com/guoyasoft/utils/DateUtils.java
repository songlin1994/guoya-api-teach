package com.guoyasoft.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: guoya-virtual-mall
 * @description: ${description}
 * @author: YSL
 * @create: 2018-10-20 17:23
 **/
public class DateUtils {
  public static final String DF ="yyyy-MM-dd HH:mm:ss";
  public static final String DFD ="yyyy-MM-dd";

  /**
   * @Description 入参 : 2018-10-31T07:17:50.000+0000
   **/
  public static Date htmlparseDate(String stringDate){
    stringDate=stringDate.substring(0,19).replace("T"," ");
    return parseDate(DF,stringDate);
  }

  /**
   * @Description 入参 :  2018-10-31 07:17:50
   **/
  public static Date secondparseDate(String stringDate){
    return parseDate(DF,stringDate);
  }

  /**
   * @Description 入参 :  2018-10-31
   **/
  public static Date dayparseDate(String stringDate){
    return parseDate(DFD,stringDate);
  }

  static Date parseDate(String sdf,String stringDate){
    SimpleDateFormat df = new SimpleDateFormat(sdf);
    Date parse = null;
    try {
      parse = df.parse(stringDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return parse;
  }

  /**
   * @Description 出参 :  2018-10-31 07:17:50
   **/
  public static String getDateSecond(Date date){
    return dateFormat(DF,date);
  }

  /**
   * @Description 出参 :  2018-10-31
   **/
  public static String getDateDay(Date date){
    return dateFormat(DFD,date);
  }

  private static String dateFormat(String df, Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat(df);
    return sdf.format(date);
  }


  public static String getFormatN(){
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    Date date = new Date();
    return sdf.format(date);
  }

}
