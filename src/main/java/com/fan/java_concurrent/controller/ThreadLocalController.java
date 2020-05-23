package com.fan.java_concurrent.controller;

import com.fan.java_concurrent.example.threadLocal.RequestHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/threadLocal")
public class ThreadLocalController {

    @RequestMapping("/test")
    public Long test() {
        return RequestHolder.getId();
    }
}
