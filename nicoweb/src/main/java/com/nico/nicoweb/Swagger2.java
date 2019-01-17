package com.nico.nicoweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Administrator
 * @version 1.0.0
 * @ClassName Swagger2
 * @Description swagger配置类  swagger接口api输出工具
 * @Configuration 注解，让Spring来加载该类配置
 * @EnableSwagger2 注解来启用Swagger2。
 * @Date 2019/1/17 0017 10:51
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    /**
     * @author Administrator
     * @Date  2019/1/17 0017 11:13
     * @return
     * @version 1.0.0
     * createRestApi函数创建Docket的Bean之后，apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）。
     * select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，本例采用指定扫描的包路径来定义，
     * Swagger会扫描该包下所有Controller定义的API，并产生文档内容（除了被@ApiIgnore指定的请求）
     */
    @Bean
    public Docket createRestApi(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nico.nicoweb.swagger"))
                .paths(PathSelectors.any())
                .build();

    }
    /**
     * @author Administrator
     * @Date  2019/1/17 0017 11:14
     * 访问地址：http://项目实际地址/swagger-ui.html
     * @return
     * @version 1.0.0
     */
    private ApiInfo apiInfo(){
        return  new ApiInfoBuilder()
                .title("spring cloud 使用 swagger 构建 api")
                .description("更多关注基于百度开发")
                .termsOfServiceUrl("http://www.nico.io")
                .contact("nico")
                .version("1.0")
                .build();


    }
}
