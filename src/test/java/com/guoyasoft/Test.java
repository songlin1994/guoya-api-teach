package com.guoyasoft;

import com.guoyasoft.demo.Business;
import com.guoyasoft.demo.Dog;
import com.guoyasoft.demo.Tiger;

/**
 * @program: guoya-mini-app-server
 * @description: ${description}
 * @author: YSL
 * @create: 2018-11-14 10:41
 **/
public class Test {

  public static void main(String[] args) {
    Business business = new Business();
    business.setiAnimal(new Dog());
    business.sing();
    business.setiAnimal(new Tiger());
    business.sing();
  }

}
