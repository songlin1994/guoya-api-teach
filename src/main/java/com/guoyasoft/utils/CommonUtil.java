package com.guoyasoft.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.guoyasoft.commons.MyX509TrustManager;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import org.springframework.web.multipart.MultipartFile;

//import net.sf.json.JSONObject;

public class CommonUtil {

  /**
   * 发送https请求
   * @param requestUrl 请求地址
   * @param requestMethod 请求方式（GET、POST）
   * @param outputStr 提交的数据
   * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
   */
  public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
    JSONObject jsonObject = null;
    try {
      // 创建SSLContext对象，并使用我们指定的信任管理器初始化
      TrustManager[] tm = { new MyX509TrustManager() };
      SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
      sslContext.init(null, tm, new java.security.SecureRandom());
      // 从上述SSLContext对象中得到SSLSocketFactory对象
      SSLSocketFactory ssf = sslContext.getSocketFactory();

      URL url = new URL(requestUrl);
      HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
      conn.setSSLSocketFactory(ssf);

      conn.setDoOutput(true);
      conn.setDoInput(true);
      conn.setUseCaches(false);
      // 设置请求方式（GET/POST）
      conn.setRequestMethod(requestMethod);

      // 当outputStr不为null时向输出流写数据
      if (null != outputStr) {
        OutputStream outputStream = conn.getOutputStream();
        // 注意编码格式
        outputStream.write(outputStr.getBytes("UTF-8"));
        outputStream.close();
      }

      // 从输入流读取返回内容
      InputStream inputStream = conn.getInputStream();
      InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
      String str = null;
      StringBuffer buffer = new StringBuffer();
      while ((str = bufferedReader.readLine()) != null) {
        buffer.append(str);
      }

      // 释放资源
      bufferedReader.close();
      inputStreamReader.close();
      inputStream.close();
      inputStream = null;
      conn.disconnect();
      jsonObject = JSON.parseObject(buffer.toString());
    } catch (ConnectException ce) {
      System.out.println("连接超时");
    } catch (Exception e) {
      System.out.println("请求异常");
      e.printStackTrace();
    }
    return jsonObject;
  }


    /**
     * 第一步：判断文件是否为空   true：返回提示为空信息   false：执行第二步
     * 第二步：判断目录是否存在   不存在：创建目录
     * 第三部：通过输出流将文件写入硬盘文件夹并关闭流
     * @param file
     * @return
     */
    public static String uploadFile(MultipartFile file,String filePath,boolean isChangeName){
      String fileName = file.getOriginalFilename();
      if (isChangeName){
        String[] strings = fileName.split("\\.");
        //通过 . 分开 名字 和 文件格式
        fileName = UUID.randomUUID() + "." + strings[strings.length - 1];
        //重置文件名+ 文件格式
      }
      File targetFile = new File(filePath);
      //第一步：判断文件是否为空
      if(file.isEmpty()){return fileName+"文件为空";}
      //第二步：判断目录是否存在   不存在：创建目录
      if(!targetFile.exists()){
        targetFile.mkdirs();
      }
      //第三部：通过输出流将文件写入硬盘文件夹并关闭流
      BufferedOutputStream stream = null;
      try {
        stream = new BufferedOutputStream(new FileOutputStream(filePath+fileName));
        stream.write(file.getBytes());
        stream.flush();
      }catch (IOException e){
        e.printStackTrace();
      }finally {
        try {
          if (stream != null) stream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return fileName;
    }

}
