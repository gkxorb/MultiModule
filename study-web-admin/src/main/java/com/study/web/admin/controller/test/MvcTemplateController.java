package com.study.web.admin.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Data;

/**
 * 21.04.21
 * Model View Controller
 * thymeleaf 의존성 추가 시 thymeleaf 템플릿 엔진은 아래의 항목을 자동 포함함.
 * - 콘텐츠 위치 추가 스캔 : /resource/templates/
 * - mvc:view:suffix: .html 설정 추가 : .html 맵핑.
 */
@Controller
public class MvcTemplateController {

    @GetMapping("hello")
    public String hello(Model model) {

        model.addAttribute("data", "spring!!");     // Model 객체를 이용하여 뷰와 데이터 렌더링
        return "hello1";                                                    // → resources/templates/hello1.html 파일을 찾아 렌더링 처리.
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {

        model.addAttribute("name", name);       // Model 객체를 이용하여 뷰와 데이터 렌더링
        return "hello-template";                            // → resources/templates/hello-template.html 파일을 찾아 렌더링 처리.
    }
}
