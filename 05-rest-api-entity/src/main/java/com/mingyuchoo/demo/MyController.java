package com.mingyuchoo.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class MyController {
    @Autowired private MyService service;

    @GetMapping
    public String home() {
        return "Welcome home!";
    }

    @GetMapping("/hello")
    public MyResponseModel hello() {
        MyEntity myEntity = service.get();
        MyResponseModel myResponseModel = new MyResponseModel();
        myResponseModel.setMessage(myEntity.toString());
        myResponseModel.setSuccess(Boolean.TRUE);
        return myResponseModel;
    }
}
