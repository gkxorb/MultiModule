/*
package com.study.common.Config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer  {

    // 21.04.21
    // 정적 콘테츠 스캔 위치 추가 Default:classpath:/static/
    // thymeleaf 의존성 (MVC 템플릿) 추가 없이 resource/templates/ 의 .html 찾으려고 삽질.. ㅠㅠ
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        
        registry.addResourceHandler("/**")
        .addResourceLocations("classpath:/templates/", "classpath:/static/")
        .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
    }

}
*/