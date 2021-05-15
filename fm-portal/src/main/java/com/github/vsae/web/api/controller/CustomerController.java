package com.github.vsae.web.api.controller;

import com.github.vsae.api.resource.excption.ResponseException;
import com.github.vsae.api.resource.http.ResponseCode;
import com.github.vsae.api.resource.http.ResponseMessage;
import com.github.vsae.api.resource.model.LoginResult;
import com.github.vsae.api.resource.model.RegisterResult;
import com.github.vsae.api.resource.model.TokenDTO;
import com.github.vsae.web.annotation.AuthToken;
import com.github.vsae.web.api.service.CustomerService;
import com.github.vsae.web.model.CustomerLoginParam;
import com.github.vsae.web.model.CustomerSignUpParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/customer")
@Api(value = "Customer", tags = {"Customer"})
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @ApiOperation(value = "login", response = ResponseMessage.class, authorizations = @Authorization(value = "Authorization"))
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseMessage login(@ApiParam(required = true, value = "login parameter") @Valid @RequestBody CustomerLoginParam customerLoginParam){
        LoginResult loginResult = customerService.doLogin(customerLoginParam);
        if(StringUtils.isNotBlank(loginResult.getTokenDTO().getToken())){
            return ResponseMessage.success(loginResult, "login success");
        }else{
            return ResponseMessage.failed("Email or Password failed");
        }
    }

    @ApiOperation(value = "register", response = ResponseMessage.class)
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseMessage register(@ApiParam(required = true, value = "register parameter")  @Valid @RequestBody CustomerSignUpParam customerSignUpParam) {
        try{
            RegisterResult registerResult = customerService.doRegister(customerSignUpParam);
            return ResponseMessage.success(registerResult, "register success.");
        }catch (ResponseException e){
            logger.error("Request occurred error code:{}, error message:{}", e.getResponseCode(), e.getResponseMessage());
            return ResponseMessage.failed(e.getResponseCode(), e.getResponseMessage());
        }catch(Exception e){
            logger.error("Request occurred error: {}", e.getMessage());
            e.fillInStackTrace();
            return ResponseMessage.failed(e.getMessage());
        }
    }

    @AuthToken
    @ApiOperation(value = "logout", response = ResponseMessage.class)
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseMessage logout(HttpServletRequest request) {
        try{
            String token = request.getHeader(AUTHORIZATION);

            if (StringUtils.isEmpty(token)) {
                return ResponseMessage.failed(ResponseCode.TOKEN_IS_EMPTY, ResponseCode.TOKEN_IS_EMPTY.getMessage());
            }

            customerService.logout(token);

            return ResponseMessage.success(null, "logout success");
        }catch (ResponseException e){
            logger.error("Request occurred error code:{}, error message:{}", e.getResponseCode(), e.getResponseMessage());
            return ResponseMessage.failed(e.getResponseCode(), e.getResponseMessage());
        } catch(Exception e){
            logger.error("Request occurred error: {}", e.getMessage());
            e.fillInStackTrace();
            return ResponseMessage.failed(e.getMessage());
        }
    }


}
