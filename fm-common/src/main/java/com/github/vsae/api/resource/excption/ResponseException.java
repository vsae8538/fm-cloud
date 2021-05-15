package com.github.vsae.api.resource.excption;

import com.github.vsae.api.resource.http.FmErrorCode;
import com.github.vsae.api.resource.http.ResponseCode;

public class ResponseException extends RuntimeException{

    private String responseMessage;

    private FmErrorCode responseCode;

    private Object data;

    public ResponseException(String message) {
        super(message);
    }

    public ResponseException(String message, String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public ResponseException(String message, String responseMessage,FmErrorCode responseCode) {
        this.responseMessage = responseMessage;
        this.responseCode = responseCode;
    }

    public ResponseException(FmErrorCode responseCode) {
        this.responseCode = responseCode;
    }

    public ResponseException(FmErrorCode responseCode, String responseMessage) {
        this.responseMessage = responseMessage;
        this.responseCode = responseCode;
    }

    public ResponseException(String message, String responseMessage, FmErrorCode responseCode, Object data) {
        this.responseMessage = responseMessage;
        this.responseCode = responseCode;
        this.data = data;
    }

    public FmErrorCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(FmErrorCode responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
