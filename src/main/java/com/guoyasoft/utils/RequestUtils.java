package com.guoyasoft.utils;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: guoya-virtual-mall
 * @description: ${description}
 * @author: YSL
 * @create: 2018-10-30 17:35
 **/
public class RequestUtils {

  public static String getString(HttpServletRequest request){
    BufferedReader br = null;
    StringBuilder sb = new StringBuilder("");
    try
    {
      br = request.getReader();
      String str;
      while ((str = br.readLine()) != null)
      {
        sb.append(str);
      }
      br.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    finally
    {
      if (null != br)
      {
        try
        {
          br.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }
    }
    return sb.toString();
  }


}
