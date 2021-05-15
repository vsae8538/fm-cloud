package com.github.vsae.web.api.service.impl;

import com.github.vsae.api.resource.excption.ResponseException;
import com.github.vsae.api.resource.http.ResponseCode;
import com.github.vsae.api.resource.model.Customer;
import com.github.vsae.api.resource.model.LoginResult;
import com.github.vsae.api.resource.model.RegisterResult;
import com.github.vsae.api.resource.model.TokenDTO;
import com.github.vsae.api.resource.utils.BCryptPasswordEncoder;
import com.github.vsae.api.resource.utils.Md5TokenGenerator;
import com.github.vsae.web.api.mapper.CustomerMapper;
import com.github.vsae.web.api.service.CustomerService;
import com.github.vsae.web.interceptor.AuthInterceptor;
import com.github.vsae.web.model.CustomerLoginParam;
import com.github.vsae.web.model.CustomerSignUpParam;
import com.github.vsae.web.utils.RedisUtils;
import com.github.vsae.web.utils.TokenUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    Md5TokenGenerator tokenGenerator;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private TokenUtils tokenUtils;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public LoginResult doLogin(CustomerLoginParam customerLoginParam){
        String email = customerLoginParam.getEmail();
        String password = customerLoginParam.getPassword();

        Customer customer = customerMapper.getCustomerByEmail(email);

        logger.info("customer login: " + customer);

        if(customer != null && encoder.matches(password, customer.getPassword())){
            String token = (String) redisUtils.get(AuthInterceptor.CUSTOMER_ID_KEY + String.valueOf(customer.getSeqno()));
            if(StringUtils.isNotBlank(token)){
                logout(token);
                logger.info("Repeat login customer : {}", customer.getEmail());
            }

            LoginResult loginResult = new LoginResult();
            loginResult.setTokenDTO(tokenUtils.createToken(customer.getEmail(), customer.getPassword(), customer.getSeqno()));
            loginResult.setEmail(email);
            return loginResult;
        }

        return new LoginResult();
    }

    @Override
    public void logout(String token) {

        String customerId = (String) redisUtils.get(token);
        redisUtils.del(token);
        redisUtils.del(AuthInterceptor.CUSTOMER_ID_KEY + customerId);

        logger.info("customer logout token: " + token);
    }

    @Override
    public RegisterResult doRegister(CustomerSignUpParam customerSignUpParam) {
        String email = customerSignUpParam.getEmail();

        Customer customer = customerMapper.getCustomerByEmail(email);
        if(customer != null){
            throw new ResponseException(ResponseCode.EMAIL_IS_REGISTERED, ResponseCode.EMAIL_IS_REGISTERED.getMessage());
        }

        String encodePassowrd = encoder.encode(customerSignUpParam.getPassword());

        Customer regCustomer = new Customer();
        regCustomer.setFirstName(customerSignUpParam.getFirstName());
        regCustomer.setLastName(customerSignUpParam.getLastName());
        regCustomer.setEmail(customerSignUpParam.getEmail());
        regCustomer.setPassword(encodePassowrd);

        int result = customerMapper.insertCustomer(regCustomer);
        if(result <= 0){
            throw new ResponseException(ResponseCode.INSERT_DB_FAILED, ResponseCode.INSERT_DB_FAILED.getMessage());
        }

        customer = customerMapper.getCustomerByEmail(regCustomer.getEmail());

        RegisterResult registerResult = new RegisterResult();
        registerResult.setTokenDTO(tokenUtils.createToken(customer.getEmail(), customer.getPassword(), customer.getSeqno()));
        registerResult.setEmail(customer.getEmail());
        return registerResult;
    }


}
