package com.guoyasoft.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

  /*@Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("all apis")
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.guoyasoft.controller"))
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("guoya-virtual-mall RESTful APIs")
        .description("所有的接口")
        .termsOfServiceUrl("http://localhost:8999/")
        .contact("有问题找闫松林")
        .version("1.0")
        .build();
  }*/

  @Bean
  public Docket userApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("user apis")
        .apiInfo(userApiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.guoyasoft.controller"))
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo userApiInfo() {
    return new ApiInfoBuilder()
        .title("user RESTful APIs")
        .description("用户模块接口")
        .termsOfServiceUrl("http://localhost:8999/")
        .contact("有问题找闫松林")
        .version("1.0")
        .build();
  }

  /*@Bean
  public Docket productApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("product apis")
        .apiInfo(productApiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.guoyasoft.controller.product"))
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo productApiInfo() {
    return new ApiInfoBuilder()
        .title("product RESTful APIs")
        .description("商品模块接口")
        .termsOfServiceUrl("http://localhost:8999/")
        .contact("有问题找闫松林")
        .version("1.0")
        .build();
  }*/

  /*@Bean
  public Docket ordertApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("order apis")
        .apiInfo(ordertApiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.guoyasoft.controller.order"))
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo ordertApiInfo() {
    return new ApiInfoBuilder()
        .title("order RESTful APIs")
        .description("订单模块接口")
        .termsOfServiceUrl("http://localhost:8999/")
        .contact("有问题找闫松林")
        .version("1.0")
        .build();
  }*/
}
