package com.guoyasoft.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @program: guoya-virtual-mall
 * @description: ${description}
 * @author: YSL
 * @create: 2018-10-30 17:41
 **/
public class EncryptUtils {
  public static String enMD5(String s){
    MessageDigest md = null;
    try {
      md = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    // 计算md5函数
    md.update(s.getBytes());
    return new BigInteger(1, md.digest()).toString(16);
  }

  public static String enBase64(String s) throws UnsupportedEncodingException{
    Base64.Encoder encoder = Base64.getEncoder();
    byte[] textByte = s.getBytes("UTF-8");
    return encoder.encodeToString(textByte);
  }

  public static String deBase64(String s) throws UnsupportedEncodingException{
    Base64.Decoder decoder = Base64.getDecoder();

    return new String(decoder.decode(s), "UTF-8");
  }

  public static void main(String[] args) throws UnsupportedEncodingException {
    System.out.println(enBase64("{  \"ordeerPrice\": 500,  \"orderLineList\": [    {      \"qty\": 5,      \"skuCode\": \"ysl_红_m\"    },{      \"qty\": 5,      \"skuCode\": \"ysl_红_s\"    }  ],  \"receiver\": \"闫松林\",  \"receiverPhone\": \"18812341234\",  \"receivingAddress\": \"山西\",  \"userName\": \"ysl001\"}"));
    System.out.println(deBase64("Z2FkZmdhZGZn"));
  }
}
