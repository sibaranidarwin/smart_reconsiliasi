package com.hackathon.smart_reconsiliasi.dto;

import lombok.Data;

@Data
public class BaseResponse {
    private String responseMessage;
    private String responseCode;

    public BaseResponse() {}

    public BaseResponse(String responseMessage, String responseCode) {
        this.responseMessage = responseMessage;
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}

