package com.study.web.admin.controller.api;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiTestController {

    //localhost:8080/hello-string?name=apitest
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {

        return "hello! " + name;
    }

    //localhost:8080/hello-api?name=apitest
    @GetMapping("hello-api")
    @ResponseBody
    public ApiSampleData helloApi(@RequestParam("name") String name) {

        ApiSampleData sampleData = new ApiSampleData();
        sampleData.setName(name);
        return sampleData;
    }

    @Data
    static class ApiSampleData {
        private String name;
    }

}
