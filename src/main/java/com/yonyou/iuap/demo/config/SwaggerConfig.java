package com.yonyou.iuap.demo.config;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
* @author liuklm:
* @version 创建时间：2018年11月21日 下午2:10:41
* 类说明  swagger config class 
*/

@Configuration //声明该类为配置类
@EnableSwagger2 //声明启动Swagger2
@EnableWebMvc //声明启动mvc
public class SwaggerConfig {
	
    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2) 
                .apiInfo(apiInfo())
                .select()
                .apis(basePackage("com.yonyou.iuap.demo"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("DEMO-API接口")
                .description("iuap-pap-baseservice-demo示例api接口说明文档")
                .version("1.0")
                .build();
    }
       
     private static Predicate<RequestHandler> basePackage(final String basePackage) {
    	 return new Predicate<RequestHandler>() {
		     @Override 
		     public boolean apply(RequestHandler input){ 
		    	 return declaringClass(input).transform(handlerPackage(basePackage)).or(true); 
		     } 
		 }; 
	  } 
     /**
      * 源代码不支持多路径扫描，
      * 这里实现新的扫描包路径规则,支持多路径扫描匹配以逗号“,”隔开
      * @param basePackage
      * @return
      */
     private static Function<Class<?>, Boolean> handlerPackage(final String basePackage){
    	 return new Function<Class<?>, Boolean>() {
    		 @Override 
    		 public Boolean apply(Class<?> input) { 
    			 for (String strPackage : basePackage.split(",")) { 
    				 boolean isMatch = input.getPackage().getName().startsWith(strPackage); 
    				 if (isMatch) { 
    					 return true; 
    					 } 
    				 } 
    			 return false; 
    			 } 
    		 }; 
     } 
     private static Optional<? extends Class<?>> declaringClass(RequestHandler input){
    	 return Optional.fromNullable(input.declaringClass());
    	 } 

}