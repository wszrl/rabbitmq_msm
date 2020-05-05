package com.zrl.rabbitmq_msm.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/*
 *@autho  zhengruilong
 *@date 2020-03-16
 */
@Configuration
public class swaggerConfig {


    @Bean
    public Docket getDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .securitySchemes(securitySchemes())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zrl.rabbitmq_msm.Controller"))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot整合rabbitmq测试短信发送")
                .description("发送短信")
//                .termsOfServiceUrl("http://blog.csdn.net/saytime")
                .version("1.0")
                .build();
    }

    //
    private List<ApiKey> securitySchemes() {
        ArrayList<ApiKey> apiKeys = new ArrayList<>();
        apiKeys.add(new ApiKey("token", "token", "header"));
        return apiKeys;

    }


//    private List<SecurityContext> securityContexts() {
//        ArrayList<SecurityContext> list = new ArrayList<>();
//        list.add( SecurityContext.builder()
//                .securityReferences(defaultAuth())
//                .forPaths(PathSelectors.regex("^(?!auth).*$"))
//                .build());
//       return list;
//    }
//
//      private List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        ArrayList<SecurityReference> list = new ArrayList<>();
//        list.add(new SecurityReference("Authorization", authorizationScopes));
//        return list;
//    }

}
