package com.github.vsae.web.api.controller;

import com.github.vsae.api.resource.excption.ResponseException;
import com.github.vsae.api.resource.http.ResponseMessage;
import com.github.vsae.web.annotation.AuthToken;
import com.github.vsae.web.api.service.CartService;
import com.github.vsae.web.api.service.HomePageService;
import com.github.vsae.web.model.*;
import com.github.vsae.web.utils.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/cart")
@Api(value = "Cart", tags = {"Cart"})
public class CartController {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    CartService cartService;

    @AuthToken
    @ApiOperation(value = "Cart", response = ResponseMessage.class)
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseMessage add(@ApiParam(required = true, value = "add Cart parameter")  @Valid @RequestBody AddCartParam addCartParam) {
        try{
            cartService.addCart(addCartParam);
            return ResponseMessage.success("add cart success.");
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
    @ApiOperation(value = "Cart", response = ResponseMessage.class)
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseMessage delete(@ApiParam(required = true, value = "delete Cart parameter")  @Valid @RequestBody DeleteCartParam deleteCartParam) {
        try{
            cartService.deleteCart(deleteCartParam);
            return ResponseMessage.success("delete cart success.");
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
    @ApiOperation(value = "Cart", response = ResponseMessage.class)
    @RequestMapping(value = "/getItems", method = RequestMethod.POST, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseMessage getItems(@ApiParam(required = true, value = "get Cart items parameter")  @Valid @RequestBody GetCartItemsParam getCartItemsParam) {
        try{
            List<CartProductDetail> cartProductDetailList = cartService.getCartItems(getCartItemsParam);
            return ResponseMessage.success(cartProductDetailList);
        }catch (ResponseException e){
            logger.error("Request occurred error code:{}, error message:{}", e.getResponseCode(), e.getResponseMessage());
            return ResponseMessage.failed(e.getResponseCode(), e.getResponseMessage());
        }catch(Exception e){
            logger.error("Request occurred error: {}", e.getMessage());
            e.fillInStackTrace();
            return ResponseMessage.failed(e.getMessage());
        }
    }

}
