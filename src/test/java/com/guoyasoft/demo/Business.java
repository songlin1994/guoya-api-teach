package com.guoyasoft.demo;

import com.guoyasoft.demo.IAnimal;

/**
 * @program: guoya-api-teach
 * @description: ${description}
 * @author: YSL
 * @create: 2019-03-09 14:01
 **/
public class Business {
  private IAnimal iAnimal;
  public void sing(){
    iAnimal.sing();
  }
  public void setiAnimal (IAnimal iAnimal){
    this.iAnimal = iAnimal;
  }
}
