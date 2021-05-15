package com.github.vsae.web.api.controller;


import com.github.vsae.api.resource.http.ResponseMessage;
import com.github.vsae.web.api.service.VerifyService;
import com.github.vsae.web.model.JWTLoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class VerifyController {

    @Autowired
    VerifyService verifyService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseMessage login(@RequestBody @Valid JWTLoginParam jwtLoginParam){
        String token = verifyService.doLogin(jwtLoginParam);
        return new ResponseMessage(token, 200);
    }

}
