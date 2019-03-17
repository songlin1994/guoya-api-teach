package com.guoyasoft.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: guoya-mini-app-server
 * @description: ${description}
 * @author: YSL
 * @create: 2018-11-12 14:59
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer   {

//  @Autowired
//  private MiniInterceptor miniInterceptor;
//
//  @Autowired
//  private MyProps myProps;

  /**
  * @Author YSL
  * @Description addPathPatterns,需要拦截的访问路径
  * @Date 15:22 2018/11/12
  * @Param [registry]
  * @return void    ,""
  **/
//  @Override
//  public void addInterceptors(InterceptorRegistry registry) {
//    registry.addInterceptor(miniInterceptor).addPathPatterns(myProps.getAddPathPatterns()).excludePathPatterns(myProps.getExcludePathPatterns());
//  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**")
        .addResourceLocations("classpath:/META-INF/resources/")
        .addResourceLocations("classpath:/resources/")
        .addResourceLocations("classpath:/static/")
        .addResourceLocations("classpath:/public/");
    registry.addResourceHandler("swagger-ui.html")
            .addResourceLocations("classpath:/META-INF/resources/");
    registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
    registry.addResourceHandler("/**").addResourceLocations("file:/mall-test/");

  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
        .maxAge(3600)
        .allowCredentials(true);
  }
}
