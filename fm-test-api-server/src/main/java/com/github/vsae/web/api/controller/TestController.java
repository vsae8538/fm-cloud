package com.github.vsae.web.api.controller;


import com.github.vsae.api.resource.http.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/test")
    public ResponseMessage test(){
        return new ResponseMessage("test OK.", 200);
    }

}
