package com.myland.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        	.apiInfo(new ApiInfoBuilder()
        		.title("myProject swagger title")
        		.description("简单描述")
        		.version("1.0")
        		.build())
        	.select()
        	.apis(RequestHandlerSelectors.basePackage("com.myland.controller"))
        	.paths(PathSelectors.any())
        	.build()
        	.useDefaultResponseMessages(false);
    }

	@Bean
    UiConfiguration uiConfig() {
      return new UiConfiguration("validatorUrl");
//          "validatorUrl",// url
//          "none",       // docExpansion          => none | list
//          "alpha",      // apiSorter             => alpha
//          "schema",     // defaultModelRendering => schema
//          null,
//          false,        // enableJsonEditor      => true | false
//          false);         // showRequestHeaders    => true | false
    }
}
