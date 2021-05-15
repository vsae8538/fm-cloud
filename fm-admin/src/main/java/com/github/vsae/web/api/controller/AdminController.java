package com.github.vsae.web.api.controller;

import com.github.vsae.api.resource.http.ResponseMessage;
import com.github.vsae.web.api.service.AdminService;
import com.github.vsae.web.model.LoginParam;
import com.github.vsae.web.model.TokenResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseMessage login(@Valid @RequestBody LoginParam hrLoginParam){
        TokenResult tokenResult = adminService.doLogin(hrLoginParam);
        if(StringUtils.isNotBlank(tokenResult.getToken())){
            return ResponseMessage.success(tokenResult, "OK.");
        }else{
            return ResponseMessage.failed("No user or password failed.");
        }
    }

}
